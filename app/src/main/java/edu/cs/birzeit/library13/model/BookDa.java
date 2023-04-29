package edu.cs.birzeit.library13.model;

import java.util.ArrayList;
import java.util.List;

public class BookDa {
    private List<Book> books;

    public BookDa(){
        books = new ArrayList<Book>();
        books.add(new Book("Core Java", "Programming",
                350));
        books.add(new Book("Database Systems", "Database",
                450));
        books.add(new Book("The Art of Software Testing", "Testing",
                350));
    }
    public List<Book> getBooksByType(String type){
        List<Book> lstBooks = new ArrayList<>();

        for(Book b:books){
            if(b.getType().equals(type)){
                lstBooks.add(b);
            }
        }
        return lstBooks;

    }
    public String[] getBookTypes(){
        String[] types = {"Programming", "Database", "Testing"};
        return types;
        //TODO: add ......remove....
    }
}
