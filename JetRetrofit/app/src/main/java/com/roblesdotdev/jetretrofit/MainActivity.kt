package com.roblesdotdev.jetretrofit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.roblesdotdev.jetretrofit.ui.theme.JetRetrofitTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel: TodosViewModel = viewModel()
            JetRetrofitTheme {
                TodosScreen(state = viewModel.state.value)
            }
        }
    }
}

@Composable
fun TodosScreen(state: TodoState) {
   LazyColumn  {
       items(state.todos) {todo ->
           Row(
               modifier = Modifier.fillMaxWidth()
           ) {
               Text(
                   text = todo.title,
                   modifier = Modifier.weight(1f),
               )
               Checkbox(checked = todo.completed, onCheckedChange = {})
           }
       }
   }
}