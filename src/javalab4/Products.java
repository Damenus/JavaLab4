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
@XmlType(name = "products", propOrder = {"name", "ilosc", "priceNetto"})
public class Products {
    
    private StringProperty name = new SimpleStringProperty();
    private IntegerProperty ilosc = new SimpleIntegerProperty();
    private IntegerProperty priceNetto = new SimpleIntegerProperty();
    private IntegerProperty priceBrutto = new SimpleIntegerProperty();
            
    public Products() {
        name = new SimpleStringProperty("");
        ilosc = new SimpleIntegerProperty();
        priceNetto = new SimpleIntegerProperty();
        priceBrutto = new SimpleIntegerProperty();
    }
    
    public Products(String name, Integer ilosc, Integer priceNetto,Integer priceBrutto) {
        this.name.set(name);
        this.ilosc.set(ilosc);
        this.priceNetto.set(priceNetto);
        this.priceBrutto.set(priceBrutto);
    }
    
    public Products(String name, String ilosc, String priceNetto,String priceBrutto) {
        this.name.set(name);  
        
        IntegerStringConverter conv = new IntegerStringConverter();
        int i = conv.fromString(ilosc);
        this.ilosc.set(i);
        int j = conv.fromString(priceNetto);
        this.priceNetto.set(j);
        int k = conv.fromString(priceBrutto);
        this.priceBrutto.set(k);
    }
    
    @XmlAttribute
    public String getName(){
        return this.name.getValue();
    }
    
    @XmlAttribute
    public Integer getIlosc() {
        return this.ilosc.get();
    }
    
    @XmlAttribute
    public Integer getPriceNetto(){
        return this.priceNetto.getValue();
    }
    
    @XmlAttribute
    public Integer getPriceBrutto() {
        return this.priceBrutto.get();
    }
    
    public void setName(String title) {
        this.name.set(title);
    }
    
    public void setIlosc(Integer pages) {
        this.ilosc.set(pages);
    }
    
     public void setPriceBrutto(String title) {
        this.name.set(title);
    }
    
    public void setAddress(Integer pages) {
        this.ilosc.set(pages);
    }
    
}
