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

public class Book implements Serializable, Edit {
    private String title;
    private Author author;
    private double page_length;
    private double pages_read;
    
    public Book(Book book) {
        this.title = book.title;
        this.author = book.author;
        this.page_length = book.page_length;
        this.pages_read = book.pages_read;
    }
    
    public Book(String title, Author author, double page_length, double pages_read) {
        this.title = title;
        this.author = author;
        this.page_length = page_length;
        this.pages_read = pages_read;
    }
    
    public String getTitle() {
        return(title);
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public void setProgress(double pages) {
        this.pages_read = pages;
    }
    
    public String getPageLength() {
        Double pages = page_length;
        return(String.format("%.0f", pages));
    }
    
    public String getPagesRead() {
        Double pages = pages_read;
        return(String.format("%.0f", pages));
    }
    
    public String showProgressBar() {
        double read = this.pages_read;
        double togo = this.page_length - this.pages_read;
        int barlength = 20;
        StringBuilder progressbar = new StringBuilder();
        progressbar.append('[');
        for(int i=0; i < (read/barlength); i++) {
            progressbar.append("#");
        }
        for(int i=0;i<(togo/barlength);i++) {
            progressbar.append("-");
        }
        progressbar.append(']');
        return(progressbar.toString());
    }
    
    public double getPercentageProgress() {
        double progress = this.pages_read / this.page_length;
        return progress * 100;
    }
    
    public void printInfo() {
        System.out.println(this.getTitle()+" by "+this.author.getName());
        System.out.print("You've read "+this.getPagesRead()+" out of "+this.getPageLength()+" pages.\n");
        System.out.print("(");
        System.out.printf("%.0f", this.getPercentageProgress());
        System.out.print("%) "+this.showProgressBar()+"\n\n");
    }
}
