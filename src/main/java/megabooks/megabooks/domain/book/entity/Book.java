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
    private String bookImg;

    @Enumerated(value = EnumType.STRING)
    private Genre bookGenre;


}
