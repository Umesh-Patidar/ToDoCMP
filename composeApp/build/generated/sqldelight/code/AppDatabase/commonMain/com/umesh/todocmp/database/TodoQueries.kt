package com.umesh.todocmp.database

import app.cash.sqldelight.Query
import app.cash.sqldelight.TransacterImpl
import app.cash.sqldelight.db.QueryResult
import app.cash.sqldelight.db.SqlDriver
import kotlin.Any
import kotlin.Long
import kotlin.String

public class TodoQueries(
  driver: SqlDriver,
) : TransacterImpl(driver) {
  public fun <T : Any> selectAll(mapper: (
    id: Long,
    title: String,
    isDone: Long,
    priority: String,
  ) -> T): Query<T> = Query(-130_381_831, arrayOf("Todo"), driver, "Todo.sq", "selectAll",
      "SELECT Todo.id, Todo.title, Todo.isDone, Todo.priority FROM Todo") { cursor ->
    mapper(
      cursor.getLong(0)!!,
      cursor.getString(1)!!,
      cursor.getLong(2)!!,
      cursor.getString(3)!!
    )
  }

  public fun selectAll(): Query<Todo> = selectAll { id, title, isDone, priority ->
    Todo(
      id,
      title,
      isDone,
      priority
    )
  }

  /**
   * @return The number of rows updated.
   */
  public fun insertTodo(
    title: String,
    isDone: Long,
    priority: String,
  ): QueryResult<Long> {
    val result = driver.execute(-1_419_146_197,
        """INSERT INTO Todo(title, isDone, priority) VALUES (?, ?, ?)""", 3) {
          bindString(0, title)
          bindLong(1, isDone)
          bindString(2, priority)
        }
    notifyQueries(-1_419_146_197) { emit ->
      emit("Todo")
    }
    return result
  }

  /**
   * @return The number of rows updated.
   */
  public fun deleteTodo(id: Long): QueryResult<Long> {
    val result = driver.execute(-620_722_659, """DELETE FROM Todo WHERE id = ?""", 1) {
          bindLong(0, id)
        }
    notifyQueries(-620_722_659) { emit ->
      emit("Todo")
    }
    return result
  }

  /**
   * @return The number of rows updated.
   */
  public fun updateTodo(
    title: String,
    isDone: Long,
    priority: String,
    id: Long,
  ): QueryResult<Long> {
    val result = driver.execute(1_613_724_219, """
        |UPDATE Todo
        |SET title = ?, isDone = ?, priority = ?
        |WHERE id = ?
        """.trimMargin(), 4) {
          bindString(0, title)
          bindLong(1, isDone)
          bindString(2, priority)
          bindLong(3, id)
        }
    notifyQueries(1_613_724_219) { emit ->
      emit("Todo")
    }
    return result
  }
}
