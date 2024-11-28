package com.styyyds.mybatis.test;

import com.styyyds.mybatis.mapper.CarMapper;
import com.styyyds.mybatis.pojo.Car;
import com.styyyds.mybatis.utils.SqlSessionUtil;
import org.junit.Test;

import java.util.List;

/**
 * CarMapper测试类
 * @author sty
 * @version 1.0
 * @since 1.0
 */
public class CarMapperTest {
    @Test
    public void testInsert(){
        CarMapper mapper = SqlSessionUtil.openSession().getMapper(CarMapper.class);
        Car car = new Car();
        car.setCarNum("5262");
        car.setBrand("BYD唐");
        car.setGuidePrice(30.3);
        car.setProduceTime("2020-10-11");
        car.setCarType("燃油车");
        mapper.insertUseGeneratedKeys(car);
        SqlSessionUtil.openSession().commit();
        System.out.println(car.getId());
    }
    @Test
    public void testInsertUseGeneratedKeys(){
        CarMapper mapper = SqlSessionUtil.openSession().getMapper(CarMapper.class);
        Car car = new Car();
        car.setCarNum("5262");
        car.setBrand("BYD汉");
        car.setGuidePrice(30.3);
        car.setProduceTime("2020-10-11");
        car.setCarType("新能源");
        mapper.insertUseGeneratedKeys(car);
        SqlSessionUtil.openSession().commit();
        System.out.println(car.getId());
    }
    @Test
    public void testSelectByCarType(){
        CarMapper mapper = (CarMapper) SqlSessionUtil.openSession().getMapper(CarMapper.class);
        List<Car> cars = mapper.selectByCarType("燃油车");
        cars.forEach(System.out::println);;
    }
    @Test
    public void testSelectAll(){
        CarMapper mapper = (CarMapper) SqlSessionUtil.openSession().getMapper(CarMapper.class);
        List<Car> cars = mapper.selectAll("desc");
        cars.forEach(System.out::println);
    }
    @Test
    public void testDeleteByCarId(){
        CarMapper mapper = (CarMapper) SqlSessionUtil.openSession().getMapper(CarMapper.class);
        int count = mapper.deleteByCarId("1,3,4");
        System.out.println("删除了几条记录"+count);
        SqlSessionUtil.openSession().commit();
    }
    @Test
    public void testSelectLikeByBrand(){
        CarMapper mapper = (CarMapper) SqlSessionUtil.openSession().getMapper(CarMapper.class);
        List<Car> cars = mapper.selectLikeByBrand("比亚迪");
        cars.forEach(System.out::println);
    }

}
