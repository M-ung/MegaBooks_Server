package megabooks.megabooks.domain.myBook.dto;

import lombok.*;
import megabooks.megabooks.domain.book.entity.BookGenre;

public class MyBookResponseDTO {
    @Data
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @Builder
    @AllArgsConstructor
    public static class MyBookFindOneDTO {
        private Long bookId;
        private Long myBookId;
        private String bookTitle;
        private String bookAuthor;
        private String bookPublisher;
        private double myBookProcess;
        private String bookImgUrl;
        private BookGenre bookGenre;
        private double stars;
    }
}
