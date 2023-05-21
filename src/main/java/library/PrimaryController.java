package library;

import java.io.IOException;
import javafx.fxml.FXML;

public class PrimaryController {

    @FXML
    private void switchToSecondary() throws IOException {
       // App.setRoot("secondary");
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
