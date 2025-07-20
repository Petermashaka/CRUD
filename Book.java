package com.example.book.model;

public class Book {

    private String title;
    private String author;
    private double price;
    private int quantity;
    public Book(){}
    public Book(String title, String author, double price, int quantity) {
        this.title = title;
        this.author = author;
        this.price = price;

    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
}
