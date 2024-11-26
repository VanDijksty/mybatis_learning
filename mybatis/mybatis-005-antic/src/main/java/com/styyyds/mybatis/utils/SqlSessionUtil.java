package com.styyyds.mybatis.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * MyBatis工具类
 *
 * @author sty
 * @version 1.0
 * @since 1.0
 */
public class SqlSessionUtil {
    /**
     * 工具类中的静态方法可以让程序员通过类名.方法名的方式调用
     */
    private static SqlSessionFactory sqlSessionFactory;

    /**
     * 类加载时初始化sqlSessionFactory对象
     * 静态代码块中初始化SqlSessionFactoryBuilder对象，保证了这个对象只会被创建一次，合理地利用了资源
     */
    static{
        try {
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            sqlSessionFactory = sqlSessionFactoryBuilder.build(Resources.getResourceAsStream("mybatis-config.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static ThreadLocal<SqlSession> local = new ThreadLocal<>();
    /**
     * 每调用一次openSession()可获取一个新的会话，该会话支持自动提交
     *
     * @return 新的会话对象
     */
    public static SqlSession openSession(){
        SqlSession sqlSession = local.get();//首先从local中获取SqlSession对象，如果没有，则创建一个SqlSession对象
        if(sqlSession == null){//只有当sqlSession为null时，才会创建一个新的SqlSession对象
            sqlSession = sqlSessionFactory.openSession();
            local.set(sqlSession);//将sqlSession对象绑定到ThreadLocal中
        }
        return sqlSession;
    }

    /**
     * 关闭SqlSession对象
     * @param sqlSession
     */

    public static void close(SqlSession sqlSession){
        if(sqlSession != null){
            sqlSession.close();
        }
        local.remove();//将这个SqlSession对象从ThreadLocal中移除
    }
}
