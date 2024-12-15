package com.xinwen.leaf.common;


import com.xinwen.leaf.common.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author shenlx
 * @description
 * @date 2024/5/9 14:48
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Result {

    private long id;

    private Status status;

    @Override
    public String toString() {
        return "Result{" + "id=" + id +
                ", status=" + status +
                '}';
    }
}
