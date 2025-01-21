package spring.boot.algorithm.node02.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.boot.algorithm.node02.entity.User;

/**
 * @author shenlx
 * @description
 * @date 2025/2/13 16:38
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
