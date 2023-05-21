package library;

public interface Abonement {
    void setIssued(boolean issued);
    void setDateReturn(String dateReturn);
    boolean isIssued();
    String getDateReturn();
    String getName();
    String getAuthor();
    int getNumberOfPage();
    int getYearOfPublication();
    Genre getGenre();
    int getNumber();
}
