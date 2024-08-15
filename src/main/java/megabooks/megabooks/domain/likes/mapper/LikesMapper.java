package megabooks.megabooks.domain.likes.mapper;

import megabooks.megabooks.domain.book.entity.Book;
import megabooks.megabooks.domain.likes.dto.LikesResponseDTO;
import megabooks.megabooks.domain.likes.entity.Likes;
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

    public LikesResponseDTO.LikesCheckDTO toLikesCheckDTO(boolean check) {
        return LikesResponseDTO.LikesCheckDTO.builder()
                .check(check)
                .build();
    }
}
