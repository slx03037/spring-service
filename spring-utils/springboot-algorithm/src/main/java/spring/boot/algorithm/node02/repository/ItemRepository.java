package spring.boot.algorithm.node02.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.boot.algorithm.node02.entity.Item;

/**
 * @author shenlx
 * @description
 * @date 2025/2/13 16:39
 */
public interface ItemRepository  extends JpaRepository<Item, Long> {
}
