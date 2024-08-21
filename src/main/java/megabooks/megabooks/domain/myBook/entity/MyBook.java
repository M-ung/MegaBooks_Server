package megabooks.megabooks.domain.myBook.entity;

import jakarta.persistence.*;
import lombok.*;
import megabooks.megabooks.domain.book.entity.Book;
import megabooks.megabooks.domain.myBook.dto.MyBookRequestDTO;
import megabooks.megabooks.domain.user.entity.User;
import megabooks.megabooks.global.entity.BaseEntity;
@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MyBook extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "my_book_id")
    private Long myBookId;

    private double myBookProcess; // 현재까지 읽은 진행도

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private Book book;

    public void updateMyBookProcess(MyBookRequestDTO.MyBookProcessDTO myBookProcessDTO) {
        this.myBookProcess = ((double) myBookProcessDTO.getNowPage() / myBookProcessDTO.getTotalPage()) * 100;
    }
}
