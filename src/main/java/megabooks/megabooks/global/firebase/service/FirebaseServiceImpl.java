package megabooks.megabooks.global.firebase.service;

import com.google.firebase.database.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import megabooks.megabooks.domain.book.entity.Book;
import megabooks.megabooks.domain.book.service.BookService;
import megabooks.megabooks.global.exception.book.BookContentNotFoundException;
import megabooks.megabooks.global.firebase.dto.FirebaseResponseDTO;
import megabooks.megabooks.global.firebase.mapper.FirebaseMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static megabooks.megabooks.global.exception.ErrorCode.NOT_FOUND_BOOK_CONTENT;

@Service
@Transactional(readOnly = true)
@Slf4j
@RequiredArgsConstructor
public class FirebaseServiceImpl implements FirebaseService {
    private final FirebaseMapper firebaseMapper;
    private final BookService bookService;
    @Override
    @Transactional
    public FirebaseResponseDTO.FirebaseFindBookContentDTO findBookContentByBookId(Long bookId) {
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
        Book findBook = bookService.getBook_id(bookId);
        String findBookTitle = findBook.getBookTitle();

        CompletableFuture<FirebaseResponseDTO.FirebaseFindBookContentDTO> future = new CompletableFuture<>();
        DatabaseReference bookContentRef = databaseReference.child("output_data").child(findBookTitle);

        bookContentRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    List<FirebaseResponseDTO.FirebaseFindSentenceDTO> sentenceDTOList = new ArrayList<>();
                    for (DataSnapshot sentenceSnapshot : dataSnapshot.getChildren()) {
                        String sentence = sentenceSnapshot.child("sentence").getValue(String.class);
                        String imageUrl = sentenceSnapshot.child("image_url").getValue(String.class);
                        String audioUrl = sentenceSnapshot.child("audio_url").getValue(String.class);
                        Boolean isAir = sentenceSnapshot.child("is_air").getValue(Boolean.class);

                        sentenceDTOList.add(firebaseMapper.toFirebaseFindSentenceDTO(sentence, imageUrl, audioUrl, isAir));
                    }

                    future.complete(firebaseMapper.toFirebaseFindBookContentDTO(bookId, findBookTitle, sentenceDTOList));
                } else {
                    future.completeExceptionally(new BookContentNotFoundException(NOT_FOUND_BOOK_CONTENT));
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                future.completeExceptionally(databaseError.toException());
            }
        });

        try {
            return future.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            return null;
        }
    }
}
