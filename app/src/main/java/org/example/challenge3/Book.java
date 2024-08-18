package org.example.challenge3;

public class Book {
    private String title;
    private String author;
    private int publicationYear;
    private String isbn;
    private double price;

    public Book() {
        System.out.println("シナリオ３：既存コードの補完");
    }

    // コンストラクタ
    public Book(String title, String author, int publicationYear, String isbn, double price) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isbn = isbn;
        this.price = price;
    }


}

