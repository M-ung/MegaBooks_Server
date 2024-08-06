package megabooks.megabooks.domain.book.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import megabooks.megabooks.domain.Image.entity.Image;
import megabooks.megabooks.domain.Image.repository.ImageRepository;
import megabooks.megabooks.domain.book.dto.BookRequestDTO;
import megabooks.megabooks.domain.book.dto.BookResponseDTO;
import megabooks.megabooks.domain.book.entity.Book;
import megabooks.megabooks.domain.book.repository.BookRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Slf4j
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    @Override
    public Page<BookResponseDTO.BookFindOneDTO> findAllByMonthlyBest(Pageable pageable) {
        return bookRepository.findAllByMonthlyBestWithPageable(pageable);
    }

    @Override
    public Page<BookResponseDTO.BookFindOneDTO> findAllByWeeklyBest(Pageable pageable) {
        return bookRepository.findAllByWeeklyBestWithPageable(pageable);
    }

    @Override
    public BookResponseDTO.BookFindDetailDTO findDetailByBookId(Long bookId) {
        return bookRepository.findDetailByBookId(bookId);
    }
}