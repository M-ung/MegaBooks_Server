package megabooks.megabooks.domain.myBook.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import megabooks.megabooks.domain.myBook.dto.MyBookResponseDTO;
import megabooks.megabooks.domain.myBook.entity.MyBook;
import megabooks.megabooks.domain.myBook.entity.MyBookStatus;
import megabooks.megabooks.domain.myBook.repository.MyBookRepository;
import megabooks.megabooks.domain.user.entity.User;
import megabooks.megabooks.global.common.CommonMethod;
import megabooks.megabooks.global.common.exception.CustomException;
import megabooks.megabooks.global.common.reponse.ErrorCode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Slf4j
public class MyBookServiceImpl implements MyBookService {
    private final CommonMethod commonMethod;
    private final MyBookRepository myBookRepository;
    @Override
    public MyBookResponseDTO.MyBookFindAll findAll(String userEmail) {
        try {
            log.info("[MyBookServiceImpl] findAll");
            return myBookRepository.findAll(userEmail);
        } catch (CustomException ce){
            log.info("[CustomException] MyBookServiceImpl findAll");
            throw ce;
        } catch (Exception e) {
            log.info("[Exception500] MyBookServiceImpl findAll");
            throw new CustomException(ErrorCode.SERVER_ERROR, "[Exception500] MyBookServiceImpl findAll : " + e.getMessage());
        }
    }

    @Override
    @Transactional
    public MyBookResponseDTO.MyBookConfirmed confirmed(String userEmail, Long myBookId) {
        try {
            log.info("[MyBookServiceImpl] confirmed");
            MyBook findMyBook = commonMethod.getMyBook_Id(myBookId);
            User findUser = commonMethod.getUser("email", userEmail);

            if (!findUser.getUserEmail().equals(userEmail)) {
                throw new CustomException(ErrorCode.USER_DENIED);
            }

            findMyBook.updateMyBook(MyBookStatus.OPEN);
            return new MyBookResponseDTO.MyBookConfirmed(findMyBook);
        } catch (CustomException ce){
            log.info("[CustomException] MyBookServiceImpl confirmed");
            throw ce;
        } catch (Exception e) {
            log.info("[Exception500] MyBookServiceImpl confirmed");
            throw new CustomException(ErrorCode.SERVER_ERROR, "[Exception500] MyBookServiceImpl confirmed : " + e.getMessage());
        }
    }
}
