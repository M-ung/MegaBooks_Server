package megabooks.megabooks.domain.book.dto;

import lombok.Data;
import megabooks.megabooks.domain.book.entity.Book;
import megabooks.megabooks.domain.book.entity.BookGenre;

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
        private int bookSales;
        private BookGenre bookGenre;
        private List<String> bookUrlList;
    }
    @Data
    public static class BookFindOneDTO {
        private Long id;
        private String bookTitle;
        private String bookAuthor;
        private String bookPublisher;
        private int bookPrice;
        private double bookRate;
        private int bookSales;
        private BookGenre bookGenre;
        private List<String> bookUrlList;

    }
    @Data
    public static class BookFindAllDTO {
        private List<BookFindOneDTO> bookList;

        public BookFindAllDTO(List<BookFindOneDTO> bookList) {
            this.bookList = bookList;
        }
    }
}
