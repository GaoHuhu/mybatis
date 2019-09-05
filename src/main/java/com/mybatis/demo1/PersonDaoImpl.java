package com.mybatis.demo1;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class PersonDaoImpl implements PersonDao {
    private SqlSessionFactory sqlSessionFactory;

    public PersonDaoImpl(SqlSessionFactory sqlSessionFactory){
        this.sqlSessionFactory=sqlSessionFactory;
    }

    @Override
    public boolean insertPerson(Person person) throws Exception {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        int result=sqlSession.insert("test.insertPerson",person);
        sqlSession.commit();
        if(result>0)
            return true;

        return false;
    }

    /**
     * delete person
     *
     * @param person
     * @return
     */
    @Override
    public boolean deletePerson(Person person) {
        return false;
    }

    /**
     * update person
     *
     * @param person
     * @return
     */
    @Override
    public boolean updatePerson(Person person) {
        return false;
    }

    /**
     * get persons
     *
     * @param name
     * @return
     */
    @Override
    public List<Person> getPersons(String name) {
        return null;
    }

    /**
     * get person by id
     *
     * @param id
     * @return
     */
    @Override
    public Person getPersonById(int id) {
        SqlSession sqlSession=sqlSessionFactory.openSession();

        try {
            Person person = sqlSession.selectOne("test.getPersonById",id);
            return person;
        }catch (Exception ex){
            sqlSession.close();
        }

        return null;
    }
}
