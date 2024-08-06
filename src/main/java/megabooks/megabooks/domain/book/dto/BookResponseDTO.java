package megabooks.megabooks.domain.book.dto;

import lombok.*;
import megabooks.megabooks.domain.book.entity.Book;
import megabooks.megabooks.domain.book.entity.BookGenre;

import java.util.List;

public class BookResponseDTO {
    @Data
    @AllArgsConstructor
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @Builder
    public static class BookFindOneDTO {
        private Long bookId;
        private String bookTitle;
        private String bookAuthor;
        private String bookPublisher;
        private String bookImgUrl;
        private BookGenre bookGenre;
        private double stars;
    }
}
