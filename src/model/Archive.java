package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Archive {

    // attributes
    private final List<Todo> archive = new ArrayList<>();

    // getters
    public List<Todo> getArchive() {
        return Collections.unmodifiableList(archive);
    }

    // operations
    public Todo addToArchive(Todo todo) {
        if(archive.contains(todo)) {
            throw new IllegalArgumentException("Todo already in Archive");
        }
        todo.setArchived(true);
        archive.add(todo);
        return todo;
    }

    public Todo removeFromArchive(Todo todo) {
        if(!archive.contains(todo)) {
            throw new IllegalArgumentException("Todo already removed from Archive");
        }
        todo.setArchived(false);
        archive.remove(todo);
        return todo;
    }

    public int getArchiveCount() {
        return archive.size();
    }

}
