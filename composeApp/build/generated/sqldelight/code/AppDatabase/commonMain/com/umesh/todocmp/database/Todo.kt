package com.umesh.todocmp.database

import kotlin.Long
import kotlin.String

public data class Todo(
  public val id: Long,
  public val title: String,
  public val isDone: Long,
  public val priority: String,
)
