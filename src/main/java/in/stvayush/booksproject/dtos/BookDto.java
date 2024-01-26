package in.stvayush.booksproject.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(SnakeCaseStrategy.class)
@JsonInclude(Include.NON_NULL)
public class BookDto {
    private Long id;
    private String bookName;
    private String authors;
    private String isbn;

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getIsbn() {
        return isbn;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthors() {
        return authors;
    }

    public String getBookName() {
        return bookName;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
}
