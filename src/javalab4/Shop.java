package javalab4;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.util.converter.IntegerStringConverter;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Damian Darczuk
 */
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "book", propOrder = {"title", "address"})
public class Shop {
    
    private StringProperty title = new SimpleStringProperty();
    private StringProperty address = new SimpleStringProperty();
            
    public Shop() {
        title = new SimpleStringProperty("");
        address = new SimpleStringProperty("");
    }
    
    public Shop(String title, String pages) {
        this.title.set(title);
        this.address.set(pages);
    }
    
 //   public Shop(String title, String pages) {
 //       this.title.set(title);        
 //       IntegerStringConverter conv = new IntegerStringConverter();
 //       int page = conv.fromString(pages);
 //       this.pages.set(page);
 //   }
    
    @XmlAttribute
    public String getTitle(){
        return this.title.getValue();
    }
    
    @XmlAttribute
    public String getAddress() {
        return this.address.get();
    }
    
    public void setTitle(String title) {
        this.title.set(title);
    }
    
    public void setAddress(String pages) {
        this.address.set(pages);
    }
    
}
