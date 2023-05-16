/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bookshelf_app;

/**
 *
 * @author kurt
 */
import java.io.Serializable;
import java.util.*;

public class BookCollection implements Serializable {
    private String name;
    public ArrayList<Book> bookcollection = new ArrayList<>();
    
    public BookCollection(String name, Book...books) {
        this.name = name;
        for (Book book : books) {
            bookcollection.add(book);
        }
    }
    
    public BookCollection(String name, ArrayList<Book> books) {
        this.name = name;
        for (Book book : books) {
            bookcollection.add(book);
        }
    }
    
    public String getName() {
        return this.name;
    }
    
    public void printCollection() {
        System.out.println(this.name+":\n");
        for (Book book : bookcollection) {
            book.printInfo();
        }
    }
    
    public void addBook(Book book) {
        this.bookcollection.add(book);
    }
    
    public void deleteBook(Book book) {
        this.bookcollection.remove(book);
    }
}
