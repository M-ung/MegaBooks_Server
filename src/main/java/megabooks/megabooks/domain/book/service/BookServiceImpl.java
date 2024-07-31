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
//    private final BookRepository bookRepository;
//    private final ImageRepository imageRepository;
//    private final AmazonS3 amazonS3;
//
//    @Value("${cloud.aws.s3.bucket}")
//    private String bucket;
//
//    @Value("${cloud.aws.s3.imgFolder}")
//    private String imgFolder;
//    @Override
//    @Transactional
//    public BookResponseDTO.BookUploadDTO upload(BookRequestDTO.BookUploadDTO bookUploadDTO) {
//        Book book = bookUploadDTO.toEntity();
//        bookRepository.save(book);
//        List<MultipartFile> bookImgList = bookUploadDTO.getBookImgList();
//        List<String> bookUrlList = new ArrayList<>();
//        if (bookImgList != null && !bookImgList.isEmpty()) {
//            for (MultipartFile imageFile : bookImgList) {
//                if (imageFile != null && !imageFile.isEmpty()) {
//                    String imgUrl = upload(imageFile);
//                    bookUrlList.add(imgUrl);
////                        Image image = new Image(imgUrl, book);
//                    Image image = Image.builder().imageUrl(imgUrl).book(book).build();
//                    imageRepository.save(image);
//                }
//            }
//        }
//
//        return new BookResponseDTO.BookUploadDTO(book, bookUrlList);
//    }
//
//    private String upload(MultipartFile diaryImg) throws IOException {
//        String originalFilename = diaryImg.getOriginalFilename();
//        String filePath = imgFolder + "/" + originalFilename;
//
//        ObjectMetadata metadata = new ObjectMetadata();
//        metadata.setContentLength(diaryImg.getSize());
//        metadata.setContentType(diaryImg.getContentType());
//
//        amazonS3.putObject(bucket, filePath, diaryImg.getInputStream(), metadata);
//        String imgUrl = amazonS3.getUrl(bucket, filePath).toString();
//        return imgUrl;
//    }
//
//    @Override
//    public BookResponseDTO.BookFindOneDTO findOne(Long bookId) {
//        return bookRepository.findOne(bookId);
//    }
//
//    @Override
//    public BookResponseDTO.BookFindAllDTO findAllBook() {
//        return bookRepository.findAllBook();
//    }
}