package megabooks.megabooks.domain.book.entity;

import jakarta.persistence.*;
import lombok.Getter;
import megabooks.megabooks.global.common.BaseEntity;

@Entity
@Getter
public class Book extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "book_id")
    private Long id;
    private String bookTitle;
    private String bookAuthor;
    private String bookPublisher;
    private int bookPrice;
    private double bookRate = 0;

    @Enumerated(value = EnumType.STRING)
    private Genre bookGenre;
    protected Book() {

    }
    public Book(String bookTitle, String bookAuthor, String bookPublisher, int bookPrice, double bookRate, Genre bookGenre) {
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.bookPublisher = bookPublisher;
        this.bookPrice = bookPrice;
        this.bookRate = bookRate;
        this.bookGenre = bookGenre;
    }
}
