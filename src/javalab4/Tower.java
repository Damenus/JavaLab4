package javalab4;

import java.util.HashSet;
import java.util.Set;
import javax.xml.bind.annotation.*;

/**
 *
 * @author Damian Darczuk
 */
//@XmlAccessorType(XmlAccessType.FIELD)
//@XmlType(name = "", propOrder = {"book"})
@XmlRootElement//(name = "tower")        
public class Tower {
    
    @XmlElement(required = true, name = "book")
    private Set<Book> books = new HashSet<>();

    public Tower() {
        
    }
    public Tower(Set<Book> book) {
        this.books = book;
    }
    
    public Set<Book> getBook() {
        return books;
    }

    public void setBooks(Set<Book> book) {
        this.books = book;
    }
    
}
