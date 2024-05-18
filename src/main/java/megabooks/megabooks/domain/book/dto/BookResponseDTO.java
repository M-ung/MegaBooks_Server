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
        public BookFindOneDTO(Book book) {
            this.id = book.getId();
            this.bookTitle = book.getBookTitle();
            this.bookAuthor = book.getBookAuthor();
            this.bookPublisher = book.getBookPublisher();
            this.bookPrice = book.getBookPrice();
            this.bookImg = book.getBookImg();
            this.bookGenre = book.getBookGenre();
        }
    }
    @Data
    public static class BookFindAllDTO {
        private List<BookFindOneDTO> bookList;
    }
}
