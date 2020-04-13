package com.contactlist.repo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.contactlist.data.Contact;

@Repository
public class ContactRepository {

	private JdbcTemplate template;

	@Autowired
	public ContactRepository(JdbcTemplate template) {
		this.template = template;
	}

	public List<Contact> findAll() {
		return template.query("select id, firstname, lastname, phone, email from contacts order by firstname",
				new RowMapper<Contact>() {

					@Override
					public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
						Contact contact = new Contact();
						contact.setId(rs.getLong(1));
						contact.setFirstName(rs.getString(2));
						contact.setLastName(rs.getString(3));
						contact.setPhoneNumber(rs.getString(4));
						contact.setEmailAddress(rs.getString(5));

						return contact;
					}
				});

	}

	public void save(Contact contact) {
		template.update("insert into contacts (firstname, lastname, phone, email) values(?,?,?,?)",
				contact.getFirstName(), contact.getLastName(), contact.getPhoneNumber(), contact.getEmailAddress());
	}

}
