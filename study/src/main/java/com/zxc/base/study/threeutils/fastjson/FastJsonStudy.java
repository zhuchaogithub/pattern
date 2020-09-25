package com.zxc.base.study.threeutils.fastjson;

import com.alibaba.fastjson.JSON;

import java.util.Map;

/**
 * @author zxc
 * @date 2020/9/25 15:57
 */
public class FastJsonStudy {

    public static void main(String[] args) {
        String jsonString = "{name:'Antony',age:'12',sex:'male',telephone:'88888'}";
        Map<String, Object> maps = JSON.parseObject(jsonString, Map.class);
        for (Map.Entry<String,Object> map : maps.entrySet()) {
            System.out.print(" key:" + map.getKey() + " value:" + map.getValue());
            // key:sex value:male key:name value:Antony key:telephone value:88888 key:age value:12
        }
    }


}
