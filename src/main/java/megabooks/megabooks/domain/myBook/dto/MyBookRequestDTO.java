package megabooks.megabooks.domain.myBook.dto;


import lombok.Data;

public class MyBookRequestDTO {
    @Data
    public static class MyBookProcessDTO {
        private Long myBookId;
        private int nowPage;
        private int totalPage;
    }
}
