package megabooks.megabooks.domain.book.entity;

import jakarta.persistence.*;
import lombok.*;
import megabooks.megabooks.global.entity.BaseEntity;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Book extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "book_id")
    private Long bookId;
    private String bookTitle;
    private String bookAuthor;
    private String bookPublisher;
    private String bookContent;
    private int bookPrice;
    private int totalPage;
    private String bookImgUrl;
    private BookStatus bookStatus;

    @Enumerated(value = EnumType.STRING)
    private BookGenre bookGenre;
    private double stars;
    private int likes;
    private int bookSales; // 판매량

    public void increaseBookSales() {
        this.bookSales += 1;
    }
}
