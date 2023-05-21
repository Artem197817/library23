package library;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class PuskGUI extends JFrame implements ActionListener {

    private Window targetFrame;

    public PuskGUI(){
       JFrame jFrame = new JFrame("Library");
       jFrame.setLayout(new GridLayout(2,3,20,20));
       jFrame.setSize(600,200);
       jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

       JButton newBook = new JButton("Найти книгу");
       JButton newPerson = new JButton("Сохранить и выйти");
       JButton issueBook = new JButton("Выдать книгу");
       JButton returnBook = new JButton("Вернуть книгу");
       JButton catalog = new JButton("Каталог");
       JButton person = new JButton("Читатели");

       newBook.addActionListener(this);
       newPerson.addActionListener(this);
       issueBook.addActionListener(this);
       returnBook.addActionListener(this);
       catalog.addActionListener(this);
       person.addActionListener(this);

       jFrame.add(catalog);
       jFrame.add(person);
       jFrame.add(issueBook);
       jFrame.add(returnBook);
       jFrame.add(newBook);
       jFrame.add(newPerson);

       jFrame.setVisible(true);

   }


    @Override
    public void actionPerformed(ActionEvent e) {
       if (e.getActionCommand().equals("Найти книгу"))
          Decor.messagePane(String.valueOf(Book.nameBook()));
       if (e.getActionCommand().equals("Сохранить и выйти")) {
           try {
               Save.save();
           } catch (IOException ex) {
               throw new RuntimeException(ex);
           }
           Save.writerBooks();
           Books.printBooks();
           System.exit(1);
        }
       if (e.getActionCommand().equals("Выдать книгу"))
           ActionLibrary.bookIssue();
       if (e.getActionCommand().equals("Вернуть книгу"))
           ActionLibrary.bookReturn();
       if (e.getActionCommand().equals("Каталог"))
            Books.printBooks();
       if (e.getActionCommand().equals("Читатели"))
           Person.getPeople().forEach(System.out::println);



        }


    }

