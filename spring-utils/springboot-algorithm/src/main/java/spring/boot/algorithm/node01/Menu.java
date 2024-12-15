package spring.boot.algorithm.node01;

import lombok.Data;

import java.util.List;

/**
 * @author shenlx
 * @description
 * @date 2024/12/12 16:11
 */
@Data
public class Menu {
    /**
     * id
     */
    public Integer id;
    /**
     * 名称
     */
    public String name;
    /**
     * 父id ，根节点为0
     */
    public Integer parentId;
    /**
     * 子节点信息
     */
    public List<Menu> childList;


    public Menu(Integer id, String name, Integer parentId) {
        this.id = id;
        this.name = name;
        this.parentId = parentId;
    }

    public Menu(Integer id, String name, Integer parentId, List<Menu> childList) {
        this.id = id;
        this.name = name;
        this.parentId = parentId;
        this.childList = childList;
    }

    public Menu setId(Integer id) {
        this.id = id;
        return this;
    }

    public Menu setName(String name) {
        this.name = name;
        return this;
    }

    public Menu setParentId(Integer parentId) {
        this.parentId = parentId;
        return this;
    }

    public Menu setChildList(List<Menu> childList) {
        this.childList = childList;
        return this;
    }
}
