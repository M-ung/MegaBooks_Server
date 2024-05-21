package megabooks.megabooks.domain.Image.repository;

import megabooks.megabooks.domain.Image.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
