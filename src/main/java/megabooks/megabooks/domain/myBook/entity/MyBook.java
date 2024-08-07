package megabooks.megabooks.domain.myBook.entity;

import jakarta.persistence.*;
import lombok.*;
import megabooks.megabooks.domain.book.entity.Book;
import megabooks.megabooks.domain.user.entity.User;
import megabooks.megabooks.global.entity.BaseEntity;
@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MyBook extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "my_book_id")
    private Long myBookId;

    private int myBookProcess;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private Book book;
}
