package library;

import javafx.stage.Stage;

import java.io.IOException;

public class Main  {
    public static void main(String[] args) throws IOException {
   
       Person p3 = new Person("Сергей",17);
       Person.personList(p3);
       Person p1 = new Person("Полина",25);
       Person.personList(p1);
       Person p2 = new Person("Борис",38);
       Person.personList(p2);
       Person p5 = new Person("Алексей",55);
       Person.personList(p5);
       Person.personList(Person.personNew());
       Save.inputBook();
       Books.printBooks();
       Person p4 = new Person("Виола",25);
       Person.personList(p4);
       Save.save();

    }

    }