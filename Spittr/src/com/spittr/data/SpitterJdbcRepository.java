package com.spittr.data;

//@Repository
//public class SpitterJdbcRepository implements SpitterRepository {
//
//	private static final String SAVE_SPITTER = "INSERT INTO spitter(firstname, lastname, username,password)values(?,?,?,?)";
//	private static final String GET_SPITTER_BY_USERNAME = "SELECT id,firstname, lastname, username, password from spitter where username=?";
//
//	JdbcOperations jdbcOperations;

//	@Autowired
//	public SpitterJdbcRepository(JdbcOperations jdbcOperations) {
//		this.jdbcOperations = jdbcOperations;
//	}

//	@Override
//	public Spitter save(Spitter spitter) {
//		jdbcOperations.update(SAVE_SPITTER, spitter.getFirstName(), spitter.getLastName(), spitter.getUserName(),
//				spitter.getPassword());
//		return spitter;
//	}
//
//	@Override
//	public Spitter get(String userName) {

		//Using object mapper
		
		// Spitter spitter = null;
		// spitter = jdbcOperations.queryForObject(GET_SPITTER_BY_USERNAME, new
		// SpitterRowMapper(), userName);
		
		
		//Using Lambda expression
		
//		return jdbcOperations.queryForObject(GET_SPITTER_BY_USERNAME, (rs, row) -> {
//			return new Spitter(rs.getLong("id"), rs.getString("firstname"), rs.getString("lastname"),
//					rs.getString("username"), rs.getString("password"));
//		}, userName);

		//return jdbcOperations.queryForObject(GET_SPITTER_BY_USERNAME, this::mapResults, userName);
		
//	}

//	private Spitter mapResults(ResultSet rs, int row) throws SQLException {
//		return new Spitter(rs.getLong("id"),rs.getString("firstname"), rs.getString("lastname"), rs.getString("username"), rs.getString("password"));
//	}

//	private class SpitterRowMapper implements RowMapper<Spitter>{
//
//		@Override
//		public Spitter mapRow(ResultSet rs, int rowNum) throws SQLException {
//			Spitter spitter = new Spitter();
//			spitter.setId(rs.getLong(1));
//			spitter.setFirstName(rs.getString(2));
//			spitter.setLastName(rs.getString(3));
//			spitter.setUserName(rs.getString(4));
//			spitter.setPassword(rs.getString(5));
//			
//			return spitter;
//		}
//		
//	}

//}
