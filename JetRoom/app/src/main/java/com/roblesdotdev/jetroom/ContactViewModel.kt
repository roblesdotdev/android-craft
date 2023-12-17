package com.roblesdotdev.jetroom

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@OptIn(ExperimentalCoroutinesApi::class)
class ContactViewModel(
    private val dao: ContactDao
) : ViewModel() {
    private val _sortType = MutableStateFlow(SortType.FIRST_NAME)
    private val _contacts = _sortType
        .flatMapLatest { sortType ->
            when(sortType) {
                SortType.FIRST_NAME -> dao.getContactsOrderByFirstName()
                SortType.LAST_NAME -> dao.getContactsOrderByLastName()
            }
        }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())
    private val _state = MutableStateFlow(ContactState())
    val state = combine(_state, _sortType, _contacts) { state, sortType, contacts ->
        state.copy(
            contacts = contacts,
            sortType = sortType
        )
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), ContactState())


    fun onEvent(e: ContactEvent) {
        when (e) {
            is ContactEvent.DeleteContact -> {
                viewModelScope.launch {
                    dao.deleteContact(e.contact)
                }
            }
            ContactEvent.HideDialog -> {
                _state.update { it.copy(
                    isAddingContact = false
                ) }
            }
            ContactEvent.SaveContact -> {
                val firstName = state.value.firstName
                val lastName = state.value.lastName
                val phoneNumber = state.value.phoneNumber
                if (firstName.isBlank() || lastName.isBlank() || phoneNumber.isBlank()) {
                    return
                }
                val contact = Contact(firstName, lastName, phoneNumber)
                viewModelScope.launch {
                    dao.upsertContact(contact)
                }
                _state.update { it.copy(
                    isAddingContact = false,
                    firstName = "",
                    lastName = "",
                    phoneNumber = "",
                ) }
            }
            is ContactEvent.SetFirstName -> {
                _state.update { it.copy(
                    firstName = e.firstName
                ) }
            }
            is ContactEvent.SetLastName -> {
                _state.update { it.copy(
                    lastName = e.lastName
                ) }
            }
            is ContactEvent.SetPhoneNumber -> {
                _state.update { it.copy(
                    phoneNumber = e.phoneNumber
                ) }
            }
            ContactEvent.ShowDialog -> {
                _state.update { it.copy(
                    isAddingContact = true
                ) }
            }
            is ContactEvent.SortContacts -> {
                _sortType.value = e.sortType
            }
        }
    }
}