package com.example.backendMongo.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Location {
    private List<String> list;


    public Location() {
        this.list = new ArrayList<>();
    }

    public void add(String element) {
        if (list != null)
            list.add(element);
    }
}
