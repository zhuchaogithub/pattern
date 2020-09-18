package com.zxc.base.study.basicknowledge.stream;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author zxc
 * @date 2020/9/18 11:50
 */
@AllArgsConstructor
@Data
public class Employee {
    private String name;
    private Integer age;
    private Double salary;
    private Status status;

    public enum Status{
        FREE,
        BUSY,
        VOCATION;
    }
}
