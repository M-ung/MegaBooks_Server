package megabooks.megabooks.domain.like;

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
public class Likes extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "likes_id")
    private Long likesId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private Book book;
}
