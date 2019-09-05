package com.mybatis.demo1;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.rmi.server.ExportException;

import static junit.framework.TestCase.assertTrue;

public class PersonTest {
    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void setPerson() throws IOException {
        SqlSessionFactoryBuilder sessionFactoryBuilder = new SqlSessionFactoryBuilder();
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        sqlSessionFactory = sessionFactoryBuilder.build(inputStream);
    }

    @Test
    public void personNameTest() {
        try {
            PersonDao personDao = new PersonDaoImpl(sqlSessionFactory);
            /*Person person=personDao.getPerson();
            System.out.println(person.getName().length());*/

            Person person=personDao.getPersonById(1);
            System.out.println(person.getName());

//            Person newPerson=new Person();
//            newPerson.setSex("nan");
//            newPerson.setId(5);
//            newPerson.setName("HHHHHHHH");
//
//            boolean result=personDao.insertPerson(newPerson);
//
//            System.out.println(result);
        }catch (Exception ex){
            System.out.println(ex);
        }
    }

    @After
    public void emptyPerson() {

    }
}
