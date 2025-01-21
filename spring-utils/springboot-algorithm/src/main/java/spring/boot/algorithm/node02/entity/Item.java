package spring.boot.algorithm.node02.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author shenlx
 * @description
 * @date 2025/2/13 16:37
 */
@Entity
@Data
public class Item {
    @Id
    private Long id;
    private String name;
}
