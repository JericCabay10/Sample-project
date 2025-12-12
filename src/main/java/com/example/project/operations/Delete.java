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
        new File("orders").mkdirs();
    }

    public void clear() throws Exception {
        storage.mapper.writeValue(new File(storage.FILE_PATH), new ArrayList<>());
    }
}
