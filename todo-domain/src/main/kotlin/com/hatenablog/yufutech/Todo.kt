package com.hatenablog.yufutech

import java.util.UUID

class Todos(val todo: List<Todo>)

class Todo(val id: TodoId, val name: TodoName)

class TodoId(val value: UUID)

class TodoName(val value: String)