package com.example.project.storage;

import org.springframework.stereotype.Component;
import tools.jackson.databind.ObjectMapper;

@Component
public class LocalStorage {
    public final String FILE_PATH = "local-storage/orders.json";
    public final ObjectMapper mapper = new ObjectMapper();
}
