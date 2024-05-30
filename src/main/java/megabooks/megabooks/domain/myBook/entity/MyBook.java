package megabooks.megabooks.domain.myBook.entity;

import jakarta.persistence.*;
import lombok.Getter;
import megabooks.megabooks.domain.book.entity.Book;
import megabooks.megabooks.domain.user.entity.User;
import megabooks.megabooks.global.common.BaseEntity;
@Entity
@Getter
@Table(name = "my_book")
public class MyBook extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "my_book_id")
    private Long id;

    @Enumerated(value = EnumType.STRING)
    private MyBookStatus myBookStatus; // 열람 상태 확인

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private Book book;

    protected MyBook() {}

    public MyBook(User user, Book book) {
        this.user = user;
        this.book = book;
    }
}
