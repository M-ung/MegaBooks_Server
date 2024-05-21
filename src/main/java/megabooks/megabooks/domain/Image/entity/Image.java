package megabooks.megabooks.domain.Image.entity;

import jakarta.persistence.*;
import lombok.Getter;
import megabooks.megabooks.domain.book.entity.Book;

@Entity
@Getter
public class Image {
    @Id
    @GeneratedValue
    @Column(name = "image_id")
    private Long id; // 고유 식별자
    private String imageUrl;
    @ManyToOne
    @JoinColumn(name="book_id")
    private Book book;

    protected Image() {
    }
    public Image(String imgURL, Book book) {
        this.imageUrl = imgURL;
        this.book = book;
    }
}
