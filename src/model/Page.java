package model;

import java.util.ArrayList;
import java.util.List;

public class Page {
    // attributes
    private int todo_count;
    private final List<Todo> incomplete_todos = new ArrayList<>();
    private final List<Todo> completed_todos = new ArrayList<>();

    // constructor
    public Page() {
        this.todo_count = 0;
    }

    // getters
    public int getTodo_count(){ return todo_count;}
    public List<Todo> getCompleted_todos() { return completed_todos;}
    public List<Todo> getIncomplete_todos() { return incomplete_todos;}

    // setters
    public void setTodo_count(int count) {
        this.todo_count = count;
    }

    // operations

}
