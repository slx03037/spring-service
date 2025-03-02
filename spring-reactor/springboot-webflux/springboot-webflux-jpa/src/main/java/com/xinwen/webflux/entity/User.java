package com.xinwen.webflux.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serializable;

/**
 * @author shenlx
 * @description
 * @date 2025/3/1 21:49
 */
@Table("orguser")
@Data
public class User implements Serializable {
    @Id
    private String id;
    @Column("userno")
    private String userNo;
    @Column("userid")
    private String userId;
    @Column("username")
    private String userName;
    @Column("password")
    private String passWord;
    @Column("mobile")
    private String mobile;
}
