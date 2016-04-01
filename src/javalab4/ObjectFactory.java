package javalab4;

import javax.xml.bind.annotation.XmlRegistry;

/**
 *
 * @author Damian Darczuk
 */
@XmlRegistry
public class ObjectFactory {
    
    public ObjectFactory() {
        
    }
    public Tower createTower() {
        return new Tower();
    }
    
    public Book creatBook() {
        return new Book();
    }
    
}
