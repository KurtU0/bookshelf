/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bookshelf_app;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author kurt
 */
public class Shelf extends User implements Serializable {
    private String name;
    private ArrayList<BookCollection> shelf;
    
    public Shelf(String name, ArrayList<BookCollection> shelf) {
        this.name = name;
        this.shelf = shelf;
    }
    
    public Shelf(String name) {
        this.name = name;
        this.shelf = new ArrayList<>();
    }
    
    public String getName() {
        return this.name;
    }
    
    public ArrayList<BookCollection> getShelf() {
        return this.shelf;
    }
}
