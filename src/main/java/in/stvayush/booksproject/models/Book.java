package in.stvayush.booksproject.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import org.springframework.util.CollectionUtils;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name = "author_books",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private Set<Author> authors = new HashSet<>();

    private String authorNames = null;

    @ManyToOne
    @JoinTable(
            name = "publisher_book",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "publisher_id")
    )
    private Publisher publisher;

    private String name;
    private String isbn;

    public Book() {
    }

    public Book(Long id, Set<Author> authors, String isbn) {
        this.id = id;
        this.authors = authors;
        this.isbn = isbn;
    }

    public Book(String name, Set<Author> authors, String isbn) {
        this.name = name;
        this.authors = authors;
        this.isbn = isbn;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }
    public void addAuthor(Author author) {
        if (author != null) {
            this.authorNames = (this.authorNames != null ? this.authorNames + ", " : "") + author.getName();
            this.authors.add(author);
            author.getBooks().add(this);
        }
    }

    public void removeAuthor(Author author) {
        this.authors.remove(author);
        author.getBooks().remove(this);
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public String getAuthorNames() {
        return this.authorNames;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name=" + name +
                ", publisher=" + publisher +
                ", isbn='" + isbn + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
