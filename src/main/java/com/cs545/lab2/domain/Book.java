package com.cs545.lab2.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Book {

    private int id;
    private String title;
    private String isbn;
    private double price;

}
