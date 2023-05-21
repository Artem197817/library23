package library;

import java.io.IOException;
import javafx.fxml.FXML;

public class SecondaryController {

    @FXML
    private void switchToPrimary() throws IOException {
       // App.setRoot("primary");
    }
    public void buttonCatalog(){
        Books.printBooks();
    }
    public void buttonSearch(){
        Decor.messagePane("В разработке");
    }
    public void buttonIssue(){
        ActionLibrary.bookIssue();
    }
}