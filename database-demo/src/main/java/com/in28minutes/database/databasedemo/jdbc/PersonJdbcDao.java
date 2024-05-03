package com.in28minutes.database.databasedemo.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.in28minutes.database.databasedemo.entity.Person;

@Repository
public class PersonJdbcDao {
	@Autowired
	JdbcTemplate jdbcTemplate;
	class PersonRowMapper implements RowMapper<Person>
	{

		@Override
		public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			Person person = new Person();
			person.setId(rs.getInt("id"));
			person.setName(rs.getString("name"));
			person.setLocation(rs.getString("location"));
			   person.setLocation(rs.getString("location"));

			    // Convert the Timestamp to String
			    Timestamp timestamp = rs.getTimestamp("birth_date");
			    if (timestamp != null) {
			        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			        String birthDateString = dateFormat.format(timestamp);
			        person.setBirthDate(birthDateString);
			    } else {
			        person.setBirthDate(null); // or handle null case according to your logic
			    }
			
			
			return person;
		}
		
	}
	public List<Person> findAll(){
		return jdbcTemplate.query("Select *from Person",
				new  BeanPropertyRowMapper<Person>(Person.class));
	}
	public Person findName(String name){
		return jdbcTemplate.queryForObject("Select *from Person where name=?",new Object[] {name},
				new  BeanPropertyRowMapper<Person>(Person.class));
	}
	public Person findLocation(String location){
		return jdbcTemplate.queryForObject("Select *from Person where location=?",new Object[] {location},
				new  BeanPropertyRowMapper<Person>(Person.class));
	}
   public int deleteById(int id) {
	   return jdbcTemplate.update("delete from Person where id =?",id);
   }
   public int InsertBy(Person person) {
	    return jdbcTemplate.update("INSERT INTO person (id, name, location, birth_date) VALUES (?, ?, ?, ?)",
	            new Object[] {person.getId(), person.getName(), person.getLocation(), person.getBirthDate()});
	}

   public int updateBy(Person person) {
	    return jdbcTemplate.update("update person set location=? where id =?",
	            new Object[] {person.getLocation(), person.getId()});
	}
   
}
