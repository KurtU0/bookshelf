/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bookshelf_app;

/**
 *
 * @author kurt
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;
import java.io.Serializable;

public class Bookshelf_App {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     * @throws java.lang.ClassNotFoundException
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        
        Scanner s = new Scanner(System.in);
        
        Shelf inituser = null;
        
        System.out.println("Hello, please enter your name.");
        String name = s.nextLine();
        try {
            FileInputStream fileIn = new FileInputStream("users/"+name+".ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            
            inituser = (Shelf) in.readObject();
            
            in.close();
            fileIn.close();
            
        } catch (IOException | ClassNotFoundException e) {
            inituser = new Shelf(name);
        }
        
        ArrayList<BookCollection> shelf = inituser.getShelf();
        
        Menu menu = new Menu();

        while(true) {
            menu.menuLoop();
            //Integer choice = Integer.valueOf(s.nextLine());
            String choice = s.nextLine();
            

            switch(choice) {
                // Create collection and add book
                case "1":
                    shelf.add(menu.createCollectionBook());
                    break;
                // Add book to a collection
                case "2":
                    menu.printCollectionNames(shelf);
                    menu.addNewBook(menu.collectionSearch(menu.getUserCollectionName(), shelf));
                    break;
                // Update book progress
                case "3":
                    menu.printCollectionNames(shelf);
                    menu.updateBook(menu.bookSearch(menu.collectionSearch(menu.getUserCollectionName(), shelf), menu.getUserBookName()));
                    break;
                // Delete book
                case "4":
                    menu.printCollectionNames(shelf);
                    BookCollection deletion = menu.collectionSearch(menu.getUserCollectionName(), shelf);
                    menu.deleteBook(deletion, menu.bookSearch(deletion, menu.getUserBookName()));
                    break;
                // Display shelf    
                case "5":
                    System.out.println("");
                    for (BookCollection c : shelf) {
                        c.printCollection();
                    }
                    break;
                // save and exit (Serialize shelf)
                case "6":
                    Shelf saved = inituser;
                    
                    FileOutputStream fileOut = new FileOutputStream("users/"+name+".ser");
                    ObjectOutputStream out = new ObjectOutputStream(fileOut);
                    out.writeObject(saved);
                    out.close();
                    fileOut.close();
                    
                    System.out.println("\nShelf saved. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("\nPlease enter a valid choice");
                    break;
            }
        }
    }
}
