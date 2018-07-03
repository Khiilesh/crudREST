/**
 * 
 */
package com.crud.rest.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Parameterized.Parameters;

import com.crud.rest.model.Person;

/**
 * @author kabhi5
 *
 */
public class MainRESTControllerTest {

	
	MainRESTController mainRESTControllerTest = new MainRESTController();
	
	Person person;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * Test method for {@link com.crud.rest.controller.MainRESTController#welcome()}.
	 */
	@Test
	public final void testWelcome() {
		assertEquals("testWelcome", "Welcome to RestTemplate Example.", mainRESTControllerTest.welcome());
	}

	/**
	 * Test method for {@link com.crud.rest.controller.MainRESTController#getPersons()}.
	 */
	@Test
	public final void testGetPersons() {
		assertEquals("testGetPersons", "[{\"name\":\"Name3\",\"age\":60,\"dob\":\"2018-07-02T17:51:38.639Z\",\"emailID\":\"person2@name2.com\"}]", mainRESTControllerTest.getPersons());
	}

	/**
	 * Test method for {@link com.crud.rest.controller.MainRESTController#addPerson(com.crud.rest.model.Person)}.
	 */
	@Test
	public final void testAddPerson() {
		assertEquals("testAddPerson", "[{\"name\":\"Name3\",\"age\":60,\"dob\":\"2018-07-02T17:51:38.639Z\",\"emailID\":\"person2@name2.com\"}]", mainRESTControllerTest.addPerson(person));
				
	}

	/**s
	 * Test method for {@link com.crud.rest.controller.MainRESTController#getPerson(java.lang.String)}.
	 */
	@Test
	public final void testGetPerson() {
		assertEquals("testGetPerson", "[{\"name\":\"Name3\"}]", mainRESTControllerTest.getPerson(person.getName()));
			
	}

	/**
	 * Test method for {@link com.crud.rest.controller.MainRESTController#updatePerson(com.crud.rest.model.Person)}.
	 */
	@Test
	public final void testUpdatePerson() {
		assertEquals("testUpdatePerson", "[{\"name\":\"Name3\",\"age\":60,\"dob\":\"2018-07-02T17:51:38.639Z\",\"emailID\":\"person2@name2.com\"}]", mainRESTControllerTest.updatePerson(person));
				
	}

	/**
	 * Test method for {@link com.crud.rest.controller.MainRESTController#deletePerson(java.lang.String)}.
	 */
	//@Test
	public final void testDeletePerson() {
		//assertEquals("testDeletePerson", "[{\"name\":\"Name3\"}]", mainRESTControllerTest.deletePerson(person.getName()));
				
	}

}
