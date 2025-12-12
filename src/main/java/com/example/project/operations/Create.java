package com.example.project.operations;

import com.example.project.model.Order;
import com.example.project.storage.LocalStorage;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

@Service
public class Create {

    private final View view;
    private final LocalStorage storage;

    public Create(View view, LocalStorage storage) {
        this.view = view;
        this.storage = storage;
        new File("local-storage").mkdirs();
    }

    public void saveOrder(Order order) throws Exception {
        List<Order> orders = view.getAllOrders();
        orders.add(order);

        storage.mapper.writeValue(new File(storage.FILE_PATH), orders);
    }
}
