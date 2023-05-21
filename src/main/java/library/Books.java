package library;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class Books implements Abonement, Serializable {


    private static final long serialVersionUID = 2483186420753560016L;
    @Override
    public void setDateReturn(String dateReturn) {
    }
    @Override
    public void setIssued (boolean issued) {
    }
    public static void setCatal(List<Books> c){
        catalog = c;
    }
    public static void setCatalog(Books b) {
        catalog.add(b);
    }
    private static List<Books> catalog = new ArrayList<>();
    public static List<Books> getCatalog(){
        return catalog;
    }
    public static void printBooks (){
        System.out.println("Каталог");
        catalog.forEach(System.out::println);
        System.out.println();
    }
    public static void deleteBook(){
      Books b =  Book.nameBook();
        if (Decor.confirmPane("Удалить?"+"\n"+b))
            Books.getCatalog().remove(b);
    }

}
