package megabooks.megabooks.domain.Image.entity;

import jakarta.persistence.*;
import lombok.*;
import megabooks.megabooks.domain.book.entity.Book;
import megabooks.megabooks.global.entity.BaseEntity;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Image extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "image_id")
    private Long imageId;
    private String imageUrl;
    private String imagePath;
    private String imageName;

    @ManyToOne
    @JoinColumn(name="book_id")
    private Book book;
}
