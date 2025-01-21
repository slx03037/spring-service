package spring.boot.algorithm.node02.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.boot.algorithm.node02.entity.Rating;

import java.util.List;

/**
 * @author shenlx
 * @description
 * @date 2025/2/13 16:39
 */
public interface RatingRepository extends JpaRepository<Rating, Long> {
    List<Rating> findByUserId(Long userId);
    List<Rating> findByItemId(Long itemId);
}
