package controller;

import model.Archive;
import model.Todo;
import view.ArchiveView;

import java.util.List;

public class ArchiveController {
    private final Archive archive;
    private final ArchiveView view;

    public ArchiveController(Archive archive, ArchiveView view) {
        this.archive = archive;
        this.view = view;
    }

    public Todo addToArchive(Todo todo) {
        return archive.addToArchive(todo);
    }

    public Todo removeFromArchive(Todo todo) {
        return archive.removeFromArchive(todo);
    }

    public int showArchiveCount() {
        return archive.getArchiveCount();
    }

    public List<Todo> showArchive() {
        return archive.getArchive();
    }
}
