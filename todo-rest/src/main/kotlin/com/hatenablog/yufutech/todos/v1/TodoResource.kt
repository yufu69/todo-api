package com.hatenablog.yufutech.todos.v1

import com.hatenablog.yufutech.Todo
import com.hatenablog.yufutech.TodoUseCase
import com.hatenablog.yufutech.Todos
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TodoResource(private val todoUseCase: TodoUseCase) {
    @GetMapping("/v1/todos")
    fun getTodos (): TodosJson {
        return todoUseCase.findAll().toJson()
    }
}

data class TodosJson(val todos: List<TodoJson>)

data class TodoJson(val id: String, val name: String)

fun Todos.toJson(): TodosJson {
    return todo.map { it.toJson() }.let(::TodosJson)
}

fun Todo.toJson(): TodoJson {
    return TodoJson(
        id.value.toString(),
        name.value
    )
}
