package library;

import java.io.IOException;
import java.text.ParseException;

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
    public void buttonReturn(){
        ActionLibrary.bookReturn();
    }
    public void buttonNewBook (){
        Book.newBook();
    }
    public void buttonNewJournal(){
        Journal.newJournal();
    }
    public void buttonDelete(){
        Book.deleteBook();
    }
    public void buttonPerson(){
        ActionLibrary.personIssued();
    }
    public void buttonNewPerson(){
        Person.personNew();
    }
    public void buttonDelPerson(){
        Person.deletePerson();
    }
    public void buttonRefund() throws ParseException {
        ActionLibrary.overdueRefundList();
    }
}
