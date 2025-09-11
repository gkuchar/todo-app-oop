package model;

import java.util.Objects;
import java.time.*;

public class Todo {

    private static int counter = 0;
    // attributes
    private int id;
    private String title;
    private String description;
    private boolean completed;
    private int priority;
    private boolean archived;
    private LocalDate dueDate;

    // constructor
    public Todo(String title, String description, int priority, LocalDate dueDate) {
        this.title = Objects.requireNonNull(title, "title must not be null");
        this.description = Objects.requireNonNull(description, "description must not be null");
        this.dueDate = Objects.requireNonNull(dueDate);
        this.completed = false;
        this.archived = false;
        this.priority =  priority;
        this.id = ++counter;
    }

    // getters
    public int getId() { return id;}
    public String getTitle() { return title;}
    public String getDescription() {return description;}
    public boolean isCompleted() {return completed;}
    public int getPriority(){ return priority;}
    public boolean isArchived(){ return archived;}
    public LocalDate getDueDate() { return dueDate;}

    // setters
    public void setId(int id) {
        this.id = id;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
    public void setPriority(int priority) {
        if (priority < 1 || priority > 5) {
           throw new IllegalArgumentException("Priority must be a value from 1 (highest priority) to 5 (lowest priority)");
        }
        else {
            this.priority = priority;
        }
    }
    public void setArchived(boolean archived) {
        this.archived = archived;
    }
    public void setDueDate(LocalDate dueDate) {
        if(dueDate.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Due date is in the past");
        }
        else {
            this.dueDate = dueDate;
        }
    }

    // operations

}
