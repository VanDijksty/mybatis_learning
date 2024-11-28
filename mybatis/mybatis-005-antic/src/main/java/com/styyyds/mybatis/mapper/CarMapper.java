package com.styyyds.mybatis.mapper;

import com.styyyds.mybatis.pojo.Car;

import java.util.List;

/**
 * Car的sql映射对象
 * @auther sty
 * @version 1.0
 * @since 1.0
 */
public interface CarMapper {
    /**
     * 根据car_type获取Car
     * @param carType
     * @return
     */
    List<Car> selectByCarType(String carType);
    List<Car> selectAll(String ascOrDesc);
    int deleteByCarId(String ids);
    List<Car> selectLikeByBrand(String brand);
    void insertUseGeneratedKeys(Car car);
    void insert(Car car);
}
