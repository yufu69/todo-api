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
            val todo1 = mockk<Todo>()
            val todo2 = mockk<Todo>()

            val target = Todos(listOf(todo1, todo2))

            val todo1Json = mockk<TodoJson>()
            val todo2Json = mockk<TodoJson>()

            val expected = TodosJson(listOf(todo1Json, todo2Json))

            mockkStatic(Todo::toJson)
            every { todo1.toJson() } returns todo1Json
            every { todo2.toJson() } returns todo2Json

            assertEquals(expected, target.toJson())

            verify { todo1.toJson() }
            verify { todo2.toJson() }
        }

        @Test
        fun `Todo が存在しない場合`() {
            val target = Todos(emptyList())

            val expected = TodosJson(
                todos = emptyList())

            assertEquals(expected, target.toJson())
        }
    }

    @Test
    fun `Todo オブジェクトを TodoJson に変換する`() {
        val uuid = UUID.randomUUID()
        val todoName = "todo-name"
        val target = Todo(TodoId(uuid), TodoName(todoName))

        val expected = TodoJson(
            id = uuid.toString(),
            name = todoName
        )

        assertEquals(expected, target.toJson())
    }
}