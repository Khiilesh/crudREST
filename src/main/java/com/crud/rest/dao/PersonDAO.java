package com.crud.rest.dao;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 
import com.crud.rest.model.Person;
import com.crud.rest.util.QueryExecutor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
 
/**
 * @author kabhi5
 *
 */
@Repository
public class PersonDAO {
	
	 @Autowired
	    private QueryExecutor queryExecutor;
 
    private static final Map<String, Person> personMap = new HashMap<String, Person>();
 
    static {
        initPersons();
    }
 
    static LocalDateTime localDateTime = LocalDateTime.now();
    
    /**
     * Initialize Person
     */
    private static void initPersons() {
        Person person1 = new Person("Name1", 26, localDateTime, "person1@name1.com");
        Person person2 = new Person("Name2", 52, localDateTime, "person2@name2.com");
        Person person3 = new Person("Name3", 60, localDateTime, "person2@name2.com");
 
        personMap.put(person1.getName(), person1);
        personMap.put(person1.getName(), person2);
        personMap.put(person1.getName(), person3);
    }
 
    /**
     *  To retrieve a person record from DB
     * @param personName
     * @return
     */
    public Person getPerson(String personName) {
    	queryExecutor.select(personName);
        return personMap.get(personName);
    }
 
    /**
     * To add a person record in DB
     * @param person
     * @return
     */
    
    public Person addPerson(Person person) {
    	queryExecutor.insertPerson(person);
    	//personMap.put(person.getName(), person);
        return person;
    }
    
    /**
     * To update a person data in DB
     * @param person
     * @return Person
     */
 
    public Person updatePerson(Person person) {
    	queryExecutor.updatePerson(person);
    	
    	//personMap.put(person.getName(), person);
        return person;
    }
    
    /**
     * TO delete a person data from DB
     * @param personName
     */
 
    public void deletePerson(String personName) {
    	queryExecutor.delete(personName);
    	//personMap.remove(personName);
    }
 
    /**
     * To get list of all person in DB.
     * @return List<Person>
     */
    public List<Person> getAllPerson() {
    	
        //Collection<Person> c = personMap.values();
        List<Person> list = new ArrayList<Person>();
        //list.addAll(c);*/
        list = queryExecutor.selectAll();
        return list;
    }
 
}