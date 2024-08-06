package megabooks.megabooks.domain.book.dto;

import lombok.*;
import megabooks.megabooks.domain.book.entity.Book;
import megabooks.megabooks.domain.book.entity.BookGenre;
import megabooks.megabooks.domain.book.entity.BookStatus;

import java.time.LocalDate;
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
    @Data
    @AllArgsConstructor
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @Builder
    public static class BookFindDetailDTO {
        private Long bookId;
        private String bookTitle;
        private String bookSummary;
        private BookStatus bookStatus;
        private String bookAuthor;
        private String bookPublisher;
        private String bookImgUrl;
        private BookGenre bookGenre;
        private LocalDate bookDate;
        private double stars;
        private int downloads;
    }
}
