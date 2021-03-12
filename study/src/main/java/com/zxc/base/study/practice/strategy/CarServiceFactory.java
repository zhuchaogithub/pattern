package com.zxc.base.study.practice.strategy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zxc
 * @date 2021/3/10 10:23
 */
public class CarServiceFactory {

    //需借助spring容器
//    Map<String, CarService> map = new HashMap<>();
//
//    public CarServiceFactory(List<CarService> carServices){
//        for (CarService carService : carServices){
//            map.put(carService.getType(),carService);
//        }
//    }
//
//    public CarService getCarService(String type){
//        return map.get(type);
//    }

    private CarService carService;
    public CarServiceFactory(String type){
        switch (type) {
            case "BM":
                carService = new BMCarServiceImpl();
                break;
            case "B":
                carService = new ADCarServiceImpl();
                break;
        }
    }

    public CarService getCarService(){
        return carService;
    }
}
