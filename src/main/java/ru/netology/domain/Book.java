package ru.netology.domain;

import java.security.PublicKey;
public class Book extends Product {
    private String authorName;

    public Book(int id, String name, int cost, String authorName) {
        super(id, name, cost);
        this.authorName = authorName;
    }
}
