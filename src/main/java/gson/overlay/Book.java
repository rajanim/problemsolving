package gson.overlay;

import java.util.Arrays;

/**
 * Created by rajani.maski on 7/18/17.
 */
public class Book {


    private String[] authors;
    private String isbn10;
    private String isbn13;
    private String title;

    public String toString() {
        return " title: " + title + " isbn10: " + isbn10
                + " isbn13: " + isbn13 + "  authors: " + Arrays.toString(authors);
    }

    public String[] getAuthors() {
        return authors;
    }

    public void setAuthors(String[] authors) {
        this.authors = authors;
    }

    public String getIsbn10() {
        return isbn10;
    }

    public void setIsbn10(String isbn10) {
        this.isbn10 = isbn10;
    }

    public String getIsbn13() {
        return isbn13;
    }

    public void setIsbn13(String isbn13) {
        this.isbn13 = isbn13;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
