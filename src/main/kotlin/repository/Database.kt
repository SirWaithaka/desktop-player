package repository

interface Database {
    fun getAll(): List<String>
    fun getById(id: Long): String
}