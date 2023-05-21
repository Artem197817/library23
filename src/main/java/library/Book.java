package library;

import javax.swing.*;
import java.util.Calendar;
import java.util.EnumSet;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Book extends Books implements Abonement {
    private final String name;
    private final int numberOfPage;
    private final int yearOfPublication;
    private String dateReturn = "Книга в библиотеке";
    private boolean isIssued = false;
    private final String author;
    private final Genre genre;

    public static void main(String[] args) {

    }

    @Override
    public boolean isIssued() {
        return isIssued;
    }

    public void setIssued(boolean issued) {
        isIssued = issued;
    }

    public String getAuthor() {
        return author;
    }

    public String getDateReturn() {
        return dateReturn;
    }

    public void setDateReturn(String dateReturn) {
        this.dateReturn = dateReturn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return numberOfPage == book.numberOfPage && yearOfPublication == book.yearOfPublication
                && isIssued == book.isIssued && Objects.equals(name, book.name)
                && Objects.equals(dateReturn, book.dateReturn) && Objects.equals(author, book.author)
                && genre == book.genre;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, numberOfPage, yearOfPublication, dateReturn, isIssued, author, genre);
    }

    public String getName() {
        return name;
    }

    public int getNumberOfPage() {
        return numberOfPage;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }

    public Genre getGenre() {
        return genre;
    }

    @Override
    public int getNumber() {
        return 0;
    }

    public Book(String name, String author, int numberOfPage, int yearOfPublication, Genre genre) {
        this.name = name;
        this.numberOfPage = numberOfPage;
        this.yearOfPublication = yearOfPublication;
        this.author = author;
        this.genre = genre;
    }

    @Override
    public String toString() {
        if (isIssued)
            return "Книга {" +
                    "Название " + name + '\'' +
                    ", Автор " + author +
                    ", Количество страниц " + numberOfPage +
                    ", Год издания " + yearOfPublication +
                    ", Жанр " + genre +
                    ", Книга на руках: Дата возврата '" + dateReturn + '\'' +
                    '}';
        else
            return "Книга {" +
                    "Название " + name + '\'' +
                    ", Автор " + author +
                    ", Количество страниц " + numberOfPage +
                    ", Год издания " + yearOfPublication +
                    ", Жанр " + genre +
                    ", Книга в библиотеке" + '}';
    }

    public static void catalog() {
        Books.setCatalog(new Book("Хождение за три моря", "Афанасий Никитин", 456, 1900, Genre.HISTORICAL));
        Books.setCatalog(new Book("Лабиринт отражений", "Сергей Лукьяненко", 357, 1990, Genre.FANTASTIC));
        Books.setCatalog(new Book("Жизнь замечательных людей", "Жорж Великолепный", 479, 1986, Genre.HISTORICAL));
        Books.setCatalog(new Book("Ночной дозор", "Сергей Лукьяненко", 415, 2002, Genre.FANTASTIC));
        Books.setCatalog(new Book("Властелин колец", "Джон Рональд Руэл Толкиен", 1235, 2006, Genre.FANTASY));
        Books.setCatalog(new Book("Ищите ведьму", "Ольга Паншина", 327, 2022, Genre.LOVE));
        Books.setCatalog(new Book("На дне", "Максим Горький", 275, 1970, Genre.PROSE));
        Books.setCatalog(new Book("Война и мир", "Лев Толстой", 1500, 1961, Genre.PROSE));
        Books.setCatalog(new Book("Джон Леннон", "Макс Любимов", 357, 2015, Genre.BIOGRAPHY));
        Books.setCatalog(new Book("Оптика", "Евгений Физиков", 523, 1991, Genre.SCIENTIFIC));
        Books.setCatalog(new Book("Ведьма и лорд", "Ольга Паншина", 357, 2021, Genre.LOVE));
        Books.setCatalog(new Book("Теоретическая механика", "Сергей Лучезарный", 359, 1996, Genre.SCIENTIFIC));
        Books.setCatalog(new Book("Черчиль", "Сергей Драгунский", 369, 1976, Genre.BIOGRAPHY));
    }

    public static Books nameBook() {
        String nameBook = Decor.inputPane("Имя книги?");
        if (nameBook == null) return null;
        List<Books> b = Books.getCatalog().stream()
                .filter(w -> w.getName().toLowerCase().contains(nameBook.toLowerCase()))
                .collect(Collectors.toList());
        if (b.isEmpty()) return null;
        if (b.size() == 1)
            return b.get(0);
        for (int i = 0; i < b.size(); i++)
            System.out.println("id = " + (i + 1) + "  " + b.get(i));
        System.out.println("Уточните книгу указав id");
        int n = ActionLibrary.checkId(b.size());
        return b.get(n - 1);
    }

    public static int inputYearOfPublication() {
        Calendar calendar = Calendar.getInstance();
        int yearCurrent = Integer.parseInt(String.valueOf(calendar.get(Calendar.YEAR)));
        String year;
        while (true) {
            year = Decor.inputPane(" Введите год публикации");
            if (year != null)
                if (year.matches("[0-9]*"))
                    if (Integer.parseInt(year) <= yearCurrent & Integer.parseInt(year) > 1000)
                        break;
        }
        return Integer.parseInt(year);
    }

    public static String inputName() {
        String name = Decor.inputPane("Введите название");
        if (name == null)
            return "Xrenas2";
        return name;
    }

    public static String inputAuthor() {
        String author = Decor.inputPane("Введите автора");
        if (author == null)
            return "Xrenas2";
        return author;
    }

    public static int inputNumberPage() {
        String numberPage;
        while (true) {
            numberPage = Decor.inputPane(" Введите количество страниц");
            if (numberPage != null)
                if (numberPage.matches("[0-9]*"))
                    break;
        }
        return Integer.parseInt(numberPage);
    }

    public static Genre inputGenre() {
        EnumSet<Genre> genres = EnumSet.allOf(Genre.class);
        Genre[] genres1 = genres.toArray(Genre[]::new);
        return (Genre) JOptionPane.showInputDialog(
                null,
                "Введите жанр",
                "Ввод",
                JOptionPane.PLAIN_MESSAGE, null,
                genres1,
                "FANTASTIC");

    }

    public static void newBook() {
        Books b = new Book(Book.inputName(), Book.inputAuthor(), Book.inputNumberPage(),
                Book.inputYearOfPublication(), Book.inputGenre());
        if (b.getName().equals("Xrenas2") || b.getAuthor().equals("Xrenas2")) {
            Decor.messagePane("Некорректные данные");
            return;
        }
        if (Decor.confirmPane("Записать?"+"\n"+b))
             Books.setCatalog(b);
    }
}
