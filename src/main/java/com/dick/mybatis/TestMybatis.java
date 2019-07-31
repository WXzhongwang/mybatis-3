package com.dick.mybatis;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Administrator
 */
public class TestMybatis {

  public static void main(String[] args) {
    String resource = "mybatis-config.xml";
    try {
      InputStream inputStream = Resources.getResourceAsStream(resource);
      SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
      try (SqlSession session = sqlSessionFactory.openSession()) {
        User user = (User) session.selectOne("UserMapper.selectUser", 1);
        System.out.println(user.getUsername());
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
