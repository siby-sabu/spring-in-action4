@Grab("h2")
import java.sql.ResultSet
import java.sql.SQLException


class ContactRepository {
	
	@Autowired
	private JdbcTemplate template;
	
	
	List<Contact> findAll(){
		 template.query("select id, firstname, lastname, phone, email from contacts order by firstname",
			new RowMapper<Contact>() {

				@Override
				public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
					Contact contact = new Contact();
					contact.setId(rs.getLong(1));
					contact.setFirstName(rs.getString(2));
					contact.setLastName(rs.getString(3));
					contact.setPhoneNumber(rs.getString(4));
					contact.setEmailAddress(rs.getString(5));

					contact;
				}
			});
		
	}
	void save(Contact contact) {
		template.update("insert into contacts (firstname, lastname, phone, email) values(?,?,?,?)",
			contact.getFirstName(), contact.getLastName(), contact.getPhoneNumber(), contact.getEmailAddress());
	}
}