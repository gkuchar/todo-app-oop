package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Page {
    // attributes
    private List<Todo> incompleteTodos = new ArrayList<>();
    private List<Todo> completedTodos = new ArrayList<>();

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

    // CRUD
    public Todo addTodo(Todo todo) {
        if(incompleteTodos.contains(todo) || completedTodos.contains(todo)) {
            throw new IllegalArgumentException("Task already exists");
        }
        else {
            incompleteTodos.add(todo); // all Todos start incomplete
        }
        return todo;
    }

    public Todo findTodoById(int id) {
        for(Todo todo : incompleteTodos) {
            if (todo.getId() == id) {
                return todo;
            }
        }
        for(Todo todo : completedTodos) {
            if (todo.getId() == id) {
                return todo;
            }
        }
        return null;
    }

    public Todo updateTodoById(int id, String newTitle, String newDesc, int newPrio, LocalDate newDueDate) {
        Todo todo = findTodoById(id);
        if (todo == null) {
            throw new IllegalArgumentException("Todo with id '" + id + "' does not exist");
        }
        todo.setTitle(newTitle);
        todo.setDescription(newDesc);
        todo.setPriority(newPrio);
        todo.setDueDate(newDueDate);

        return todo;
    }

    public boolean deleteTodoById(int id) {
        Todo todo = findTodoById(id);
        if(todo == null) {
            return false;
        }
        if(incompleteTodos.contains(todo)) {
            incompleteTodos.remove(todo);
        }
        if(completedTodos.contains(todo)) {
            completedTodos.remove(todo);
        }
        return true;
    }

    public boolean deleteAllCompletedTodos() {
        if (completedTodos.isEmpty()) {
            return false;
        }
        completedTodos.clear();
        return true;
    }

    public boolean deleteAllIncompleteTodos() {
        if(incompleteTodos.isEmpty()) {
            return false;
        }
        incompleteTodos.clear();
        return true;
    }

    public boolean deleteAllTodos() {
        return (deleteAllCompletedTodos() && deleteAllIncompleteTodos());
    }




}
