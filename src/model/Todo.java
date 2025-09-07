package model;

import java.util.Objects;

public class Todo {

    // attributes
    private int id;
    private String title;
    private String description;
    private boolean completed;
    private int priority;
    private boolean archived;

    // constructor
    public Todo(String title, String description) {
        this.title = Objects.requireNonNull(title, "title must not be null");
        this.description = Objects.requireNonNull(description, "description must not be null");
        this.completed = false;
        this.archived = false;
        this.priority =  5;
    }

    // getters
    public int getId() { return id;}
    public String getTitle() { return title;}
    public String getDescription() {return description;}
    public boolean isCompleted() {return completed;}
    public int getPriority(){ return priority;}
    public boolean isArchived(){ return archived;}

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

    // operations


}
