package com.zxc.base.study.basicknowledge.newfeatures;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zxc
 * @date 2020/9/18 17:03
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private String name;
    private Integer age;
    private String gender;
}
