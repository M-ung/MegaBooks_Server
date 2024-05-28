package megabooks.megabooks.domain.book.dto;

import lombok.Data;
import megabooks.megabooks.domain.book.entity.Book;
import megabooks.megabooks.domain.book.entity.Genre;

import java.util.List;

@Data
public class BookResponseDTO {
    @Data
    public static class BookUploadDTO {
        private Long id;
        private String bookTitle;
        private String bookAuthor;
        private String bookPublisher;
        private int bookPrice;
        private double bookRate;
        private Genre bookGenre;
        private List<String> bookUrlList;

        public BookUploadDTO(Book book, List<String> bookUrlList) {
            this.id = book.getId();
            this.bookTitle = book.getBookTitle();
            this.bookAuthor = book.getBookAuthor();
            this.bookPublisher = book.getBookPublisher();
            this.bookPrice = book.getBookPrice();
            this.bookRate = book.getBookRate();
            this.bookGenre = book.getBookGenre();
            this.bookUrlList = bookUrlList;
        }
    }
    @Data
    public static class BookFindOneDTO {
        private Long id;
        private String bookTitle;
        private String bookAuthor;
        private String bookPublisher;
        private int bookPrice;
        private double bookRate;
        private Genre bookGenre;
        private List<String> bookUrlList;

        public BookFindOneDTO(Long id, String bookTitle, String bookAuthor, String bookPublisher, int bookPrice, double bookRate, Genre bookGenre) {
            this.id = id;
            this.bookTitle = bookTitle;
            this.bookAuthor = bookAuthor;
            this.bookPublisher = bookPublisher;
            this.bookPrice = bookPrice;
            this.bookRate = bookRate;
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
