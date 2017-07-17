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
    
    @XmlElement(required = true, name = "shop")
    private Set<Shop> books = new HashSet<>();
    private Set<Products> products = new HashSet<>();

    public Tower() {
        
    }
    public Tower(Set<Shop> book) {
        this.books = book;
    }
    
    public Set<Shop> getBook() {
        return books;
    }

    public void setBooks(Set<Shop> book) {
        this.books = book;
    }
    
}
