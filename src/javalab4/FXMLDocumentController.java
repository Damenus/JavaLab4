package javalab4;

import java.io.File;
import java.net.URL;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.FileChooser;
import javafx.util.converter.IntegerStringConverter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author Damian Darczuk
 */
public class FXMLDocumentController implements Initializable {
    
    ObservableList<Book> books = FXCollections.observableArrayList();
    
    @FXML
    TableView<Book> bookTableView;
    
    @FXML
    TableColumn<Book,String> titleColumn;
    @FXML
    TableColumn<Book,Integer> pageColumn;
    @FXML
    TextField titleField;
    @FXML
    TextField pagesField;
    
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        titleColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("title"));
        pageColumn.setCellValueFactory(new PropertyValueFactory<Book, Integer>("pages"));
        
        bookTableView.setItems(books);
        bookTableView.setEditable(true);
                     
        titleColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        titleColumn.setOnEditCommit(new EventHandler<CellEditEvent<Book, String>>() {
            @Override
            public void handle(CellEditEvent<Book, String> event) {
                Book book = event.getRowValue();
                String newTitle = event.getNewValue();
                book.setTitle(newTitle);
            }
            
        });
        
        
        IntegerStringConverter conv = new IntegerStringConverter();
        pageColumn.setCellFactory(TextFieldTableCell.forTableColumn(conv));
        pageColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Book, Integer>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Book, Integer> event) {
                Book book = event.getRowValue();
                int newPages = event.getNewValue();
                book.setPages(newPages);
            }
        });
        
    }    
    
    @FXML
    private void loadBooksActions(ActionEvent event) {
        
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(null);
        if (file != null) {        
            try {
                JAXBContext context = JAXBContext.newInstance(ObjectFactory.class.getPackage().getName());
                Unmarshaller unmarshaller = context.createUnmarshaller();
                Tower tower = (Tower) unmarshaller.unmarshal(file);
                books.clear();
                books.addAll(tower.getBook());

            } catch (JAXBException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    @FXML
    private void removeBookAction(ActionEvent event) {        
        books.remove(bookTableView.getSelectionModel().getSelectedItem());
    }
    
    @FXML
    private void saveBooksAction(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showSaveDialog(null);
        if (file != null) {
            try {
                JAXBContext context = JAXBContext.newInstance(ObjectFactory.class.getPackage().getName());
                Marshaller marshaller = context.createMarshaller();                
                marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);                
                Tower tower = new Tower();
                tower.setBooks(new HashSet<>(books));
                marshaller.marshal(tower, file);
                marshaller.marshal(tower, System.out);
            } catch (JAXBException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
    }
    
    @FXML
    private void addBookActions(ActionEvent event) {
        String title = titleField.textProperty().getValue();
        String pages = pagesField.textProperty().getValue();
        Book book = new Book(title, pages);
        books.add(book);
        titleField.clear();
        pagesField.clear();
    }
}
