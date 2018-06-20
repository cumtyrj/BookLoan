package model;

import java.io.Serializable;


public class Book implements Serializable {
    private Integer id;

    private String ISBN;

    private String title;

    private Member loanTo;

    public Book() {
    }

    public Book(Integer id, String ISBN, String title, Member loanTo) {
        this.id = id;
        this.ISBN = ISBN;
        this.title = title;
        this.loanTo = loanTo;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Member getLoanTo() {
        return loanTo;
    }

    public void setLoanTo(Member loanTo) {
        this.loanTo = loanTo;
    }
    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", ISBN='" + ISBN + '\'' +
                ", title='" + title + '\'' +
                ",ΩË‘ƒ»À£∫"+loanTo+
                '}';
    }

}
