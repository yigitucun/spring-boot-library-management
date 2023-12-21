package com.ali.library.forms;


import com.ali.library.entities.concretes.Book;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public class BookForm {
    @NotBlank(message = "Zorunlu alan")
    private String author;
    @NotBlank(message = "Zorunlu alan")
    @Length(min = 3,max=500,message = "Minimum 3 maximum 500 karakter olmalıdır.")
    private String description;
    @NotBlank(message = "Zorunlu alan")
    private String bookName;

    public Book toEntity(BookForm form){
        Book book = new Book();
        book.setAuthor(form.getAuthor());
        book.setBookName(form.getBookName());
        book.setDescription(form.getDescription());
        return book;
    }
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
}
