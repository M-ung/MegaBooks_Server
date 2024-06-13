package megabooks.megabooks.domain.myBook.dto;

import lombok.Data;
import megabooks.megabooks.domain.book.entity.Genre;
import megabooks.megabooks.domain.myBook.entity.MyBookStatus;

import java.util.List;

@Data
public class MyBookResponseDTO {
    @Data
    public static class MyBookFindOne {
        private Long bookId;
        private String bookTitle;
        private String bookAuthor;
        private String bookPublisher;
        private double bookRate;
        private Genre bookGenre;
        private MyBookStatus myBookStatus;
        private List<String> bookUrlList;
        public MyBookFindOne(Long bookId, String bookTitle, String bookAuthor, String bookPublisher, double bookRate, Genre bookGenre, MyBookStatus myBookStatus) {
            this.bookId = bookId;
            this.bookTitle = bookTitle;
            this.bookAuthor = bookAuthor;
            this.bookPublisher = bookPublisher;
            this.bookRate = bookRate;
            this.bookGenre = bookGenre;
            this.myBookStatus = myBookStatus;
        }
    }
    @Data
    public static class MyBookFindAll {
        private String userEmail;
        private List<MyBookResponseDTO.MyBookFindOne> myBookList;

        public MyBookFindAll(String userEmail, List<MyBookResponseDTO.MyBookFindOne> myBookList) {
            this.userEmail = userEmail;
            this.myBookList = myBookList;
        }
    }
}
