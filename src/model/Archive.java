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
    // addToArchive()

}
