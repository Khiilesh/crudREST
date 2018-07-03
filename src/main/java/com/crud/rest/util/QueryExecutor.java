package com.crud.rest.util;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.crud.rest.model.Person;

public class QueryExecutor {

	private DataSource dataSource;

	public void setDataSource(DataSource ds) {
		dataSource = ds;
	}

	/**
	 * Execute query to select all person records.
	 * @return
	 */
	
	@SuppressWarnings("unchecked")
	public List<Person> selectAll() {
		JdbcTemplate select = new JdbcTemplate(dataSource);
		return select.query("SELECTs NAME, AGE, DOB, EMAILID FROM PERSON", new PersonRowMapper());
	}
	
	/**
	 * Execute query to insert a person record
	 * @param person
	 * @return
	 */

	public int insertPerson(Person person) {

		JdbcTemplate insert = new JdbcTemplate(dataSource);

		String personName = person.getName();
		int age = person.getAge();
		LocalDateTime dob = person.getDob();
		String emailID = person.getEmailID();

		return insert.update("INSERT INTO PERSON (NAME, AGE, DOB, EMAILID) VALUES(?,?,?,?)",
				new Object[] { personName, age, dob, emailID });

	}
	
	/**
	 * Execute Query to select a person by name
	 * @param name
	 * @return
	 */

	@SuppressWarnings("unchecked")
	public List<Person> select(String name) {
		JdbcTemplate select = new JdbcTemplate(dataSource);
		return select.query("SELECT  NAME, AGE, DOB, EMAILID FROM PERSON WHERE NAME = ? ", new Object[] { name },
				new PersonRowMapper());
	}
	
	/**
	 * Execute query to update person record
	 * @param person
	 * @return
	 */

	public int updatePerson(Person person) {

		JdbcTemplate insert = new JdbcTemplate(dataSource);

		int age = person.getAge();
		LocalDateTime dob = person.getDob();		
		String emailID = person.getEmailID();

		return insert.update("INSERT INTO PERSON ( AGE, DOB, EMAILID) VALUES(?,?,?)",
				new Object[] { age, dob, emailID });

	}

	/**
	 * Execute query to delete Person data
	 * @param name
	 * @return
	 */
	public int delete(String name) {
		JdbcTemplate delete = new JdbcTemplate(dataSource);
		return delete.update("DELETE from PERSON where NAME= ?", new Object[] { name });
	}

}
