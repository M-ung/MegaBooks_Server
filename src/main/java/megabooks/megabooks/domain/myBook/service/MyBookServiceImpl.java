package megabooks.megabooks.domain.myBook.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import megabooks.megabooks.domain.myBook.repository.MyBookRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Slf4j
public class MyBookServiceImpl implements MyBookService {
    private final MyBookRepository myBookRepository;
//    @Override
//    public MyBookResponseDTO.MyBookFindAll findAll(String userEmail) {
//        return myBookRepository.findAll(userEmail);
//    }
//
//    @Override
//    @Transactional
//    public MyBookResponseDTO.MyBookConfirmed confirmed(String userEmail, Long myBookId) {
//        MyBook findMyBook = commonMethod.getMyBook_Id(myBookId);
//        User findUser = commonMethod.getUser("email", userEmail);
//
//        if (!findUser.getUserEmail().equals(userEmail)) {
//            throw new CustomException(ErrorCode.USER_DENIED);
//        }
//
//        findMyBook.updateMyBook(MyBookStatus.OPEN);
//        return new MyBookResponseDTO.MyBookConfirmed(findMyBook);
//    }
}
