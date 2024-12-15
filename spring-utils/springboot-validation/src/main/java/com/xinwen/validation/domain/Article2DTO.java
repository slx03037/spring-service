package com.xinwen.validation.domain;


import lombok.Data;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @program: my-spring-all-com.xinwen.mybatis.node01.service
 * @description:
 * @author: shenlx
 * @create: 2023-04-12 17:30
 **/
@Data
public class Article2DTO {
    @NotNull(message = "文章id不能为空",groups = UpdateArticleDTO.class )
    @Min(value = 1,message = "文章ID不能为负数",groups = UpdateArticleDTO.class)
    private Integer id;
    /**
     * 文章内容添加和修改都是必须校验的，groups需要指定两个分组
     */
    @NotBlank(message = "文章内容不能为空",groups = {AddArticleDTO.class,UpdateArticleDTO.class})
    private String content;
    @NotBlank(message = "作者Id不能为空",groups = AddArticleDTO.class)
    private String authorId;
    /**
     * 提交时间是添加和修改都需要校验的，因此指定groups两个
     */
    @Future(message = "提交时间不能为过去时间",groups = {AddArticleDTO.class,UpdateArticleDTO.class})
    private Date submitTime;
    //修改文章的分组
    public interface UpdateArticleDTO{}
    //添加文章的分组
    public interface AddArticleDTO{}

}
