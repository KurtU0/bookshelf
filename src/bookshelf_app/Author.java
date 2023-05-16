/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bookshelf_app;

import java.io.Serializable;

/**
 *
 * @author kurt
 */
public class Author implements Serializable {
    private String first;
    private String last;
    
    public Author(String name) {
        String[] authorname = name.split(" ", 2);
        if (authorname.length < 2) {
            this.first = authorname[0];
            this.last = "";
        } else {
            this.first = authorname[0];
            this.last = authorname[1];
        }
    }
    
    public String getName() {
        return(this.first+" "+this.last);
    }
    
    public String getABName() {
        return(this.last+", "+this.first);
    }
}
