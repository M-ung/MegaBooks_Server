package megabooks.megabooks.domain.like.mapper;

import megabooks.megabooks.domain.book.entity.Book;
import megabooks.megabooks.domain.like.entity.Likes;
import megabooks.megabooks.domain.user.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class LikesMapper {
    private static final ModelMapper modelMapper = new ModelMapper();

    public Likes toLikesEntity(User user, Book book) {
        return Likes.builder()
                .book(book)
                .user(user)
                .build();
    }
}
