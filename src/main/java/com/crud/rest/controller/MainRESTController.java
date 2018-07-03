package com.crud.rest.controller;

import java.util.List;

import com.crud.rest.dao.PersonDAO;
import com.crud.rest.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
 
@RestController
public class MainRESTController {
 
    @Autowired
    private PersonDAO personDAO;
    
    private static final String SUCCESS_STATUS = "success";
	private static final String ERROR_STATUS = "error";
	private static final int CODE_SUCCESS = 100;
	private static final int UNPROCESSABLE_ENTITY = 422;
 
    @RequestMapping("/")
    @ResponseBody
    public String welcome() {
        return "Welcome to RestTemplate Example.";
    }
 
    /**
     * Endpoint to return list of people in DB.
     * @return List<Person>
     */
    // URI:
    // http://localhost:8080/SpringMVCRESTful/people
    // http://localhost:8080/SpringMVCRESTful/people.xml
    // http://localhost:8080/SpringMVCRESTful/people.json
    @RequestMapping(value = "/people", //
            method = RequestMethod.GET, //
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public List<Person> getPersons() {
        List<Person> list = personDAO.getAllPerson();
        return list;
    }
 
    
    /**
     * Endpoint to return add a person in DB.
     * @param person
     * @return Person
     */
    // URI:
    // http://localhost:8080/SpringMVCRESTful/people
    // http://localhost:8080/SpringMVCRESTful/people.xml
    // http://localhost:8080/SpringMVCRESTful/people.json
    @RequestMapping(value = "/people", //
            method = RequestMethod.POST, //
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public Person addPerson(@RequestBody Person person) {
 
        return personDAO.addPerson(person);
 
    }
 
    
    /**
     *  Endpoint to retrieve Person detail based on name.
     * @param personName
     * @return Person
     */
    // URI:
    // http://localhost:8080/SpringMVCRESTful/people/{personName}
    // http://localhost:8080/SpringMVCRESTful/people/{personName}.xml
    // http://localhost:8080/SpringMVCRESTful/people/{personName}.json
    @RequestMapping(value = "/people/{personName}", //
            method = RequestMethod.GET, //
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public Person getPerson(@PathVariable("personName") String personName) {
        return personDAO.getPerson(personName);
    }
    
    
    
    /**
     * Endpoint to update a person in DB.
     * @param person
     * @return Person
     */
    // URI:
    // http://localhost:8080/SpringMVCRESTful/people
    // http://localhost:8080/SpringMVCRESTful/people.xml
    // http://localhost:8080/SpringMVCRESTful/people.json
    @RequestMapping(value = "/people", //
            method = RequestMethod.PUT, //
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public Person updatePerson(@RequestBody Person person) {
 
        return personDAO.updatePerson(person);
    }
 
    /**
     * Endpoint to delete a person data from DB based on name.
     * 	
     * @param personName
     */
    // URI:
    // http://localhost:8080/SpringMVCRESTful/people/{personName}
    @RequestMapping(value = "/people/{personName}", //
            method = RequestMethod.DELETE, //
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public void deletePerson(@PathVariable("personName") String personName) {
        personDAO.deletePerson(personName);
    }
 
}
