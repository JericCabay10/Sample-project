package com.example.project.operations;

import com.example.project.storage.LocalStorage;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;

@Service
public class Delete {

    private final LocalStorage storage;

    public Delete(LocalStorage storage) {
        this.storage = storage;
    }

    public void clear() throws Exception {
        // Ensure folder exists
        File file = new File(storage.FILE_PATH);

        file.getParentFile().mkdirs();

        // Clear orders
        storage.mapper.writeValue(file, new ArrayList<>());
    }
}
