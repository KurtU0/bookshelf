/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bookshelf_app;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author kurt
 */
public class Menu {
    Scanner s = new Scanner(System.in);
    
    public void menuLoop() {
        System.out.println("\n--Bookshelf Main Menu--");
        System.out.println("Enter the number that corresponds with your choice!");
        System.out.println("1: Create a new collection");
        System.out.println("2: Add a book");
        System.out.println("3: Update your progress on a book");
        System.out.println("4: Delete a book");
        System.out.println("5: View your shelf");
        System.out.println("6: Save and exit");
    }
    
    public BookCollection createCollectionBook() {
        ArrayList<Book> templist = new ArrayList<>();

        System.out.println("\nPlease enter the name of the collection.");
        String collectionname = s.nextLine();

        while(true) {
            Book book = new Book(createBook());
            System.out.println("");
            templist.add(book);

            System.out.println("Would you like to add another book? (y/n)");
            String do_again = s.nextLine();
            if (!"y".equals(do_again)) {
                break;
            }
        }

        BookCollection collection = new BookCollection(
            collectionname,
            templist
        );
        
        return collection;
    }
    
    public Book createBook() {
        System.out.println("\nPlease enter the title of the book you would like to add.");
        String title = s.nextLine();
        System.out.println("Next, enter who authored it.");
        Author authorname = new Author(s.nextLine());
        System.out.println("How many pages does it have?");
        Double pagecount = doubleCheck(s.nextLine());
        System.out.println("How many have you read?");
        Double pagesread = doubleCheck(s.nextLine());
        
        Book book = new Book(title, authorname, pagecount, pagesread);
        return book;
    }
    
    public double doubleCheck(String str) {
        try {
            Double pagecount = Double.valueOf(str);
            return pagecount;
        } catch (NumberFormatException e) {
            System.out.println("\nPlease enter a number");
            Double pagecount = 0.0;
            return pagecount;
        }
    }
    
    public void addNewBook(BookCollection collection) {
        if (collection != null) {
            Book book = new Book(createBook());
            collection.addBook(book);
        } else {
            System.out.println("\nCollection not found");
        }
    }
    
    public void updateBook(Book book) {
        if (book != null) {
            System.out.println("\nPlease type your current page number");
            Double newpages = doubleCheck(s.nextLine());
            book.setProgress(newpages);
        } else {
            System.out.println("\nBook not found");
        }
    }
    
    public void deleteBook(BookCollection collection, Book book) {
        if (book != null && collection != null) {
            collection.deleteBook(book);
            System.out.println("\nBook deleted");
        } else {
            System.out.println("\nBook not found");
        }
    }
    
    public void printCollectionNames(ArrayList<BookCollection> shelf) {
        System.out.println("\nCurrent collections:");
        for (BookCollection c : shelf) {
            System.out.println(c.getName());
        }
    }
    
    public String getUserCollectionName() {
        System.out.println("\nPlease type the collection you wish to append");
        String collectionname = s.nextLine();
        return collectionname;
    }
    
    public String getUserBookName() {
        System.out.println("\nPlease type the name of the book you wish to update");
        String collectionname = s.nextLine();
        return collectionname;
    }
    
    public BookCollection collectionSearch(String str, ArrayList<BookCollection> shelf) {
        BookCollection d = null;
        for (BookCollection c : shelf) {
            if (c.getName().strip().toLowerCase().equals(str.strip().toLowerCase())) {
                d = c;
            }
        }
        return d;
    }
    
    public Book bookSearch(BookCollection c, String str) {
        Book book = null;
        if (c != null) {
            for (Book b : c.bookcollection) {
                if (b.getTitle().strip().toLowerCase().equals(str.strip().toLowerCase())) {
                    book = b;
                }
            }
        }
        return book;
    }
    
    public Book bookSearch(String str) {
        Book book = null;
        return book;
    }
    
    
}
