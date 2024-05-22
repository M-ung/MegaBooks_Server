package megabooks.megabooks.domain.book.dto;

import lombok.Data;
import megabooks.megabooks.domain.book.entity.Book;
import megabooks.megabooks.domain.book.entity.Genre;
import org.springframework.web.multipart.MultipartFile;

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
    public static class BookDetailDTO {
        private Long id;
        private String bookTitle;
        private String bookAuthor;
        private String bookPublisher;
        private int bookPrice;
        private double bookRate;
        private Genre bookGenre;

        public BookDetailDTO(Book book) {
            this.id = book.getId();
            this.bookTitle = book.getBookTitle();
            this.bookAuthor = book.getBookAuthor();
            this.bookPublisher = book.getBookPublisher();
            this.bookPrice = book.getBookPrice();
            this.bookRate = book.getBookRate();
            this.bookGenre = book.getBookGenre();
        }
    }
    @Data
    public static class BookFindOneDTO {
        private BookResponseDTO.BookDetailDTO bookDetailDTO;
        private List<String> bookUrlList;

        public BookFindOneDTO(BookResponseDTO.BookDetailDTO bookDetailDTO, List<String> imageUrlList) {
            this.bookDetailDTO = bookDetailDTO;
            this.bookUrlList = imageUrlList;
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
