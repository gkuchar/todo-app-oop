package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Page {
    // attributes
    private final List<Todo> incompleteTodos = new ArrayList<>();
    private final List<Todo> completedTodos = new ArrayList<>();

    // constructor
    public Page() {
    }

    // getters
    public List<Todo> getCompletedTodos() { return Collections.unmodifiableList(completedTodos);}
    public List<Todo> getIncompleteTodos() { return Collections.unmodifiableList(incompleteTodos);}

    // setters

    // operations
    public int getTotalTodoCount() {
        return incompleteTodos.size() + completedTodos.size();
    }

    public int getIncompleteTodoCount() {
        return incompleteTodos.size();
    }

    public int getCompletedTodoCount() {
        return completedTodos.size();
    }

    public Todo addIncompleteTodo(Todo todo) {
        if(incompleteTodos.contains(todo) || completedTodos.contains(todo)) {
            throw new IllegalArgumentException("Task already exists");
        }
        else {
            incompleteTodos.add(todo);
        }
        return todo;
    }

    public Todo markCompleted(Todo todo) {
        if(!incompleteTodos.contains(todo)) {
            throw new IllegalArgumentException("Task is already completed");
        }
        else {
            incompleteTodos.remove(todo);
        }
        completedTodos.add(todo);
        todo.setCompleted(true);
        return todo;
    }

    public Todo markIncomplete(Todo todo) {
        if(!completedTodos.contains(todo)) {
            throw new IllegalArgumentException("Task is already marked incomplete");
        }
        else {
            completedTodos.remove(todo);
        }
        incompleteTodos.add(todo);
        todo.setCompleted(false);
        return todo;
    }

}
