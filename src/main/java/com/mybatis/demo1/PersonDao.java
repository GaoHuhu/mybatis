package com.mybatis.demo1;

import java.util.List;

public interface PersonDao {
    /**
     * insert person
     * @param person
     * @return
     */
    public boolean insertPerson(Person person) throws Exception;

    /**
     * delete person
     * @param person
     * @return
     */
    public boolean deletePerson(Person person) throws Exception;

    /**
     * update person
     * @param person
     * @return
     */
    public boolean updatePerson(Person person) throws Exception;

    /**
     * get persons
     * @param name
     * @return
     */
    public List<Person> getPersons(String name) throws Exception;

    /**
     * get person by id
     * @param id
     * @return
     */
    public Person getPersonById(int id) throws Exception;
}
