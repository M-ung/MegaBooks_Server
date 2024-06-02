package megabooks.megabooks.domain.myBook.dto;

import lombok.Data;
import megabooks.megabooks.domain.book.entity.Genre;
import megabooks.megabooks.domain.myBook.entity.MyBookStatus;

import java.util.List;

@Data
public class MyBookResponseDTO {
    @Data
    public static class MyBookFindAll {
        private String bookTitle;
        private String bookAuthor;
        private String bookPublisher;
        private double bookRate;
        private Genre bookGenre;
        private MyBookStatus myBookStatus;
        private List<String> bookUrlList;
    }
}
