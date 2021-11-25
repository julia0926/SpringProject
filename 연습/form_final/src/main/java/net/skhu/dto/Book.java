package net.skhu.dto;

import lombok.Data;

@Data
public class Book {
    int id;
    String title;
    String author;
    String price;
    String publisher;
    Integer categoryId;
}

