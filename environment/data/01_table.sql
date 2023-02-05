\c todo;

CREATE SCHEMA todo;

CREATE TABLE todo.todo(
    id UUID PRIMARY KEY,
    name TEXT NOT NULL
)