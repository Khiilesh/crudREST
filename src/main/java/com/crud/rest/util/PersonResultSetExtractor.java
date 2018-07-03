package com.crud.rest.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.ResultSetExtractor;

import com.crud.rest.model.Person;

public class PersonResultSetExtractor implements ResultSetExtractor {

    public Object extractData(ResultSet rs) throws SQLException {
        Person person = new Person();
        person.setName(rs.getString(1));
        person.setAge(rs.getInt(2));
        //person.setDob(rs.getDate(3));
        person.setEmailID(rs.getString(4));
      
        return person;
    }

}