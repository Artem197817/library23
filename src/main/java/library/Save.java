package library;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public abstract class Save {
    //private static final long serialVersionUID = 1L;
    public static void save() throws IOException {
        List<Books> books = Books.getCatalog();
        List<Person> people = Person.getPeople();
        HashMap<Books, Person> issue = ActionLibrary.getIssue();
        FileOutputStream fos = new FileOutputStream("people.bin");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(people);
        oos.flush();
        oos.close();
        FileOutputStream fos1 = new FileOutputStream("book.bin");
        ObjectOutputStream oos1 = new ObjectOutputStream(fos1);
        oos1.writeObject(books);
        oos1.flush();
        oos1.close();
        FileOutputStream fos2 = new FileOutputStream("issue.bin");
        ObjectOutputStream oos2 = new ObjectOutputStream(fos2);
        oos2.writeInt(issue.size());
        for (Map.Entry<Books, Person> entry : issue.entrySet()) {
            oos2.writeObject(entry.getKey());
            oos2.writeObject(entry.getValue());
        }
        oos2.flush();
        oos2.close();

    }

    public static void read() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("book.bin");
        ObjectInputStream ois = new ObjectInputStream(fis);
        ArrayList<?> catal = (ArrayList<?>) ois.readObject();
        ois.close();
        Books.setCatal((List<Books>) catal);
        FileInputStream fis1 = new FileInputStream("people.bin");
        ObjectInputStream ois1 = new ObjectInputStream(fis1);
        ArrayList<?> people = (ArrayList<?>) ois1.readObject();
        ois1.close();
        Person.setPeople((ArrayList<Person>) people);
        HashMap<Books, Person> issue = new HashMap<>();
        FileInputStream fis2 = new FileInputStream("issue.bin");
        ObjectInputStream ois2 = new ObjectInputStream(fis2);
        int mapSize = ois2.readInt();
        for (int i = 0; i < mapSize; i++) {
            Books key = (Books) ois2.readObject();
            Person value = (Person) ois2.readObject();
            issue.put(key, value);
        }
        ois2.close();
        ActionLibrary.setIssue(issue);
    }

    public static void writerBooks() {
        StringBuilder book = new StringBuilder();
        try (PrintWriter prw = new PrintWriter("books.txt")) {
            for (Books b : Books.getCatalog()) {
                if (b.getClass() == Book.class)
                    book.append("b").append(",").append(b.getName()).append(",").append(b.getAuthor()).append(",")
                            .append(b.getNumberOfPage()).append(",").append(b.getYearOfPublication()).append(",")
                            .append(b.getGenre());
                if (b.getClass() == Journal.class)
                    book.append("j").append(",").append(b.getName()).append(",").append(b.getNumberOfPage()).append(",")
                            .append(b.getYearOfPublication()).append(",").append(b.getNumber());
                prw.println(book);
                book.replace(0, book.length(), "");
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void inputBook() {
        Path path = Paths.get("books.txt");
        File file = new File(path.toUri());
      try  (Scanner sc = new Scanner(file)){
        while (sc.hasNext()) {
            String[] book = sc.nextLine().split(",");
            if (book[0].equals("b")) {
                Genre genre = Genre.valueOf(book[5]);
                Books b = new Book(book[1], book[2], Integer.parseInt(book[3]),
                        Integer.parseInt(book[4]),genre );
                Books.setCatalog(b);
            }
            if (book[0].equals("j")) {
                Journal j = new Journal(book[1], Integer.parseInt(book[2]),
                        Integer.parseInt(book[3]), Integer.parseInt(book[4]));
                Books.setCatalog(j);
            }
            }
        } catch (FileNotFoundException e) {
          throw new RuntimeException(e);
      }
    }
}
