package com.umesh.todocmp.database

import app.cash.sqldelight.Transacter
import app.cash.sqldelight.db.QueryResult
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.db.SqlSchema
import com.umesh.todocmp.database.composeApp.newInstance
import com.umesh.todocmp.database.composeApp.schema
import kotlin.Unit

public interface AppDatabase : Transacter {
  public val todoQueries: TodoQueries

  public companion object {
    public val Schema: SqlSchema<QueryResult.Value<Unit>>
      get() = AppDatabase::class.schema

    public operator fun invoke(driver: SqlDriver): AppDatabase =
        AppDatabase::class.newInstance(driver)
  }
}
