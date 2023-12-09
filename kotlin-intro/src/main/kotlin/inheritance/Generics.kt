package inheritance

data class Item(val id: Int, val title: String)

data class Task(val id: Int, val title: String, val description: String)

interface CrudRepository<T> {
    fun getById(id: Int): T
    fun store(obj: T)
    fun getAll(): List<T>
}

class CrudRepositoryItemImpl: CrudRepository<Item> {
    override fun getById(id: Int): Item {
        TODO("Not yet implemented")
    }

    override fun getAll(): List<Item> {
        TODO("Not yet implemented")
    }

    override fun store(obj: Item) {
        TODO("Not yet implemented")
    }

}

class CrudRepositoryTaskImpl: CrudRepository<Task> {
    override fun getById(id: Int): Task {
        TODO("Not yet implemented")
    }

    override fun getAll(): List<Task> {
        TODO("Not yet implemented")
    }

    override fun store(obj: Task) {
        TODO("Not yet implemented")
    }
}