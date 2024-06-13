package megabooks.megabooks.domain.myBook.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import megabooks.megabooks.domain.myBook.dto.MyBookResponseDTO;
import megabooks.megabooks.domain.myBook.repository.MyBookRepository;
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
}
