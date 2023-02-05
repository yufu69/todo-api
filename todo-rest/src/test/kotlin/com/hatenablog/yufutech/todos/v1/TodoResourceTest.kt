package com.hatenablog.yufutech.todos.v1

import org.junit.jupiter.api.Assertions.assertEquals
import com.hatenablog.yufutech.Todo
import com.hatenablog.yufutech.TodoId
import com.hatenablog.yufutech.TodoName
import com.hatenablog.yufutech.Todos
import io.mockk.every
import io.mockk.mockk
import io.mockk.mockkStatic
import io.mockk.verify
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import java.util.*

class TodoResourceTest {
    @Nested
    inner class `Todos オプジェクトを TodosJson に変換する` {

        @Test
        fun `Todo が存在する場合`() {
//            val todo1 = mockk<Todo>()
//            val todo2 = mockk<Todo>()
////            val todo1 = mockkStatic("com.hatenablog.yufutech.todos.v1.TodoResourceKt")
////            val todo2 = mockkStatic("com.hatenablog.yufutech.todos.v1.TodoResourceKt")
//
//            val todos = Todos(listOf(todo1, todo2))
//
//            val todo1Json = mockk<TodoJson>()
//            val todo2Json = mockk<TodoJson>()
//
//            val expected = TodosJson(listOf(todo1Json, todo2Json))
//
//            every { todo1.toJson() } returns todo1Json
//            every { todo2.toJson() } returns todo2Json
//
//            assertEquals(expected, todos.toJson())
//
//            verify { todo1.toJson() }
//            verify { todo2.toJson() }

            // このテストでは Todo を本物にする必要はないと思ってて、↑ のモック使う方がやりたいけど、なんかエラーになっちゃう。。
            val id1 = UUID.randomUUID()
            val id2 = UUID.randomUUID()
            val name1 = "todo-name-1"
            val name2 = "todo-name-2"

            val todo1 = Todo(TodoId(id1), TodoName(name1))
            val todo2 = Todo(TodoId(id2), TodoName(name2))
            val target = Todos(listOf(todo1, todo2))

            val todoJson1 = TodoJson(id = id1.toString(), name = name1)
            val todoJson2 = TodoJson(id = id2.toString(), name = name2)

            val expected = TodosJson(todos = listOf(todoJson1, todoJson2))

            assertEquals(expected, target.toJson())
        }
    }

    @Test
    fun `Todo オブジェクトを TodoJson に変換する`() {
        val uuid = UUID.randomUUID()
        val todoName = "todo-name"
        val todo = Todo(TodoId(uuid), TodoName(todoName))

        val expected = TodoJson(
            id = uuid.toString(),
            name = todoName
        )

        assertEquals(expected, todo.toJson())
    }
}