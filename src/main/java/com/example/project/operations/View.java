package com.example.project.operations;

import com.example.project.model.Order;
import com.example.project.storage.LocalStorage;
import org.springframework.stereotype.Service;
import tools.jackson.core.type.TypeReference;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Service
public class View {

    private final LocalStorage storage;

    public View(LocalStorage storage) {
        this.storage = storage;
    }

    public List<Order> getAllOrders() throws Exception {
        // Ensure folder exists
        File file = new File(storage.FILE_PATH);
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            return new ArrayList<>();
        }

        return storage.mapper.readValue(file, new TypeReference<List<Order>>() {});
    }
}
