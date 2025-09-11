package controller;

import model.Page;
import model.Todo;
import view.PageView;

import java.time.LocalDate;
import java.util.List;

public class PageController {
    private final Page page;
    private final PageView view;

    public PageController(Page page, PageView view) {
        this.page = page;
        this.view = view;
    }

    public Todo addTodo(String title, String description, int priority, LocalDate dueDate) {
        Todo todo = new Todo(title, description, priority, dueDate);
        page.addTodo(todo);
        return todo;
    }

    public List<Todo> showAllIncompleteTodos() {
        return page.getIncompleteTodos();
    }

    public List<Todo> showAllCompletedTodos() {
        return page.getCompletedTodos();
    }

    public Todo showTodoById(int id) {
        return page.findTodoById(id);
    }

    public int getTotalTodoCount() {
        return page.getTotalTodoCount();
    }

    public int getIncompleteTodoCount() {
        return page.getIncompleteTodoCount();
    }

    public int getCompletedTodoCount() {
        return page.getCompletedTodoCount();
    }

    public Todo updateTodoById(int id, String title, String description, int prio, LocalDate dueDate) {
        return page.updateTodoById(id, title, description, prio, dueDate);
    }

    public Todo markCompleted(Todo todo) {
        return page.markCompleted(todo);
    }

    public Todo markIncomplete(Todo todo) {
        return page.markIncomplete(todo);
    }

    public boolean deleteTodoById(int id) {
        return page.deleteTodoById(id);
    }

    public boolean deleteAllCompletedTodos() {
        return page.deleteAllCompletedTodos();
    }

    public boolean deleteAllIncompleteTodos() {
        return page.deleteAllIncompleteTodos();
    }

    public boolean deleteAllTodos() {
        return page.deleteAllTodos();
    }




}
