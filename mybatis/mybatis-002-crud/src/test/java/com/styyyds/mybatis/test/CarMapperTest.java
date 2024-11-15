package com.styyyds.mybatis.test;

import com.styyyds.mybatis.pojo.Car;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import utils.SqlSessionUtil;

import java.util.List;

public class CarMapperTest {
    @Test
    public void testInsertCar(){
        Car car = new Car();
        car.setCarNum("103");
        car.setBrand("奔驰C200");
        car.setGuidePrice(33.23);
        car.setProduceTime("2020-10-11");
        car.setCarType("燃油车");
        SqlSession sqlSession = SqlSessionUtil.openSession();
        int count = sqlSession.insert("insertCarByPoJo",car);
        System.out.println("插入了几条记录：" + count);
    }
    @Test
    public void testDeleteCarByCarNum(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        int count = sqlSession.delete("deleteCarByCarNum", "103");
        System.out.println("删除了几条数据：" + count);
    }
    @Test
    public void testUpdateCarById(){
        Car car = new Car();
        car.setId(10L);
        car.setCarNum("102");
        car.setBrand("比亚迪汉");
        car.setGuidePrice(30.23);
        car.setProduceTime("2018-09-10");
        car.setCarType("电车");
        // 获取SqlSession对象
        SqlSession sqlSession = SqlSessionUtil.openSession();
        // 执行SQL语句
        int count = sqlSession.update("updateCarById", car);
        System.out.println("更新了几条记录：" + count);
    }
    @Test
    public void testSelectCarById(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        Object selectCarById = sqlSession.selectOne("selectCarById", 3);
        System.out.println(selectCarById);
    }
    @Test
    public void testSelectAllCar(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        List<Object> selectAllCar = sqlSession.selectList("selectAllCar");
        selectAllCar.forEach(System.out::println);
    }
}
