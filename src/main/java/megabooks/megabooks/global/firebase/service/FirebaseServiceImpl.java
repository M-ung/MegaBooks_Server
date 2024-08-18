package megabooks.megabooks.global.firebase.service;

import com.google.firebase.database.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import megabooks.megabooks.global.firebase.dto.FirebaseResponseDTO;
import megabooks.megabooks.global.firebase.mapper.FirebaseMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
@Transactional(readOnly = true)
@Slf4j
@RequiredArgsConstructor
public class FirebaseServiceImpl implements FirebaseService {
    private final DatabaseReference databaseReference;
    private final FirebaseMapper firebaseMapper;
    @Override
    @Transactional
    public FirebaseResponseDTO.FirebaseFindSummaryDetailDTO findDetailSummary(String bookTitle, String summary) {
        CompletableFuture<FirebaseResponseDTO.FirebaseFindSummaryDetailDTO> future = new CompletableFuture<>();
        DatabaseReference summariesRef = databaseReference.child("summaries").child(bookTitle);
        Query query = summariesRef.orderByChild("summary").equalTo(summary);

        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    for (DataSnapshot childSnapshot : dataSnapshot.getChildren()) {
                        String summaryImgUrl = childSnapshot.child("image_url").getValue(String.class);
                        String summaryAudioUrl = childSnapshot.child("audio_url").getValue(String.class);

                        FirebaseResponseDTO.FirebaseFindSummaryDetailDTO result = firebaseMapper.toFirebaseFindSummaryDetailDTO(summaryImgUrl, summaryAudioUrl);

                        future.complete(result);
                        break;
                    }
                } else {
                    future.completeExceptionally(new Exception("Summary not found"));
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
