package megabooks.megabooks.domain.myBook.mapper;

import megabooks.megabooks.domain.book.entity.Book;
import megabooks.megabooks.domain.myBook.entity.MyBook;
import megabooks.megabooks.domain.user.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class MyBookMapper {
    private static final ModelMapper modelMapper = new ModelMapper();
    public MyBook toMyBookEntity(User user, Book book) {
        return MyBook.builder()
                .myBookProcess(0)
                .user(user)
                .book(book)
                .build();
    }
}
