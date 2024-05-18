package megabooks.megabooks.domain.book.dto;

import lombok.Data;
import megabooks.megabooks.domain.book.entity.Book;
import megabooks.megabooks.domain.book.entity.Genre;
import megabooks.megabooks.domain.user.entity.User;

import java.util.List;

@Data
public class BookResponseDTO {
    @Data
    public static class BookFindOneDTO {
        private Long id;
        private String bookTitle;
        private String bookAuthor;
        private String bookPublisher;
        private int bookPrice;
        private String bookImg;
        private Genre bookGenre;

        public BookFindOneDTO(Long id, String bookTitle, String bookAuthor, String bookPublisher, int bookPrice, String bookImg, Genre bookGenre) {
            this.id = id;
            this.bookTitle = bookTitle;
            this.bookAuthor = bookAuthor;
            this.bookPublisher = bookPublisher;
            this.bookPrice = bookPrice;
            this.bookImg = bookImg;
            this.bookGenre = bookGenre;
        }
    }
    @Data
    public static class BookFindAllDTO {
        private List<BookFindOneDTO> bookList;

        public BookFindAllDTO(List<BookFindOneDTO> bookList) {
            this.bookList = bookList;
        }
    }
}
