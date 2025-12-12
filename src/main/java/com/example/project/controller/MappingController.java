package com.example.project.controller;

import com.example.project.model.Order;
import com.example.project.operations.Create;
import com.example.project.operations.View;
import com.example.project.operations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class MappingController {

    // Inject operations
    @Autowired
    private Create createOp;

    @Autowired
    private View viewOp;

    @Autowired
    private Delete deleteOp;

    //HTML Mapping
    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    // Local Storage Mapping
    @PostMapping("/api/orders")
    @ResponseBody
    public String saveOrder(@RequestBody Order order) throws Exception {
        createOp.saveOrder(order);
        return "OK";
    }

    @GetMapping("/api/orders")
    @ResponseBody
    public List<Order> getOrders() throws Exception {
        return viewOp.getAllOrders();
    }


    @DeleteMapping("/api/orders")
    @ResponseBody
    public String clearOrders() throws Exception {
        deleteOp.clear();
        return "CLEARED";
    }
}
