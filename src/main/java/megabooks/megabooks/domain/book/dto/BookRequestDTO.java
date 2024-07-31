package megabooks.megabooks.domain.book.dto;

import lombok.Data;
import megabooks.megabooks.domain.book.entity.BookGenre;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

@Data
public class BookRequestDTO {
    @Data
    public static class BookUploadDTO {
        private String bookTitle;
        private String bookAuthor;
        private String bookPublisher;
        private int bookPrice;
        private List<MultipartFile> bookImgList;
        private double bookRate;
        private BookGenre bookGenre;
//        public Book toEntity() {
//            return new Book(this.bookTitle, this.bookAuthor, this.bookPublisher, this.bookPrice, this.bookRate, this.bookGenre);
//        }
    }
}
