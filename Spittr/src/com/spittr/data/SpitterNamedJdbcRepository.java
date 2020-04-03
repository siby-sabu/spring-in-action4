package com.spittr.data;

//@Repository
//@Primary
//public class SpitterNamedJdbcRepository implements SpitterRepository{
//	
//	NamedParameterJdbcOperations namedParameterJdbcOperations;
//	
//	private static final String SAVE_SPITTER = "INSERT INTO spitter(firstname, lastname, username,password)values(:firstname,:lastname,:username,:password)";
//	private static final String GET_SPITTER_BY_USERNAME = "SELECT id,firstname, lastname, username, password from spitter where username=:username";
//
//	
//	@Autowired
//	public SpitterNamedJdbcRepository(NamedParameterJdbcOperations namedParameterJdbcOperations) {
//		this.namedParameterJdbcOperations = namedParameterJdbcOperations;
//	}
//	
//	@Override
//	public Spitter save(Spitter spitter) {
//		System.out.println("Executed from SpitterNamedJdbcRepository");
//		Map<String,Object> paramMap = new HashMap<>();
//		paramMap.put("firstname", spitter.getFirstName());
//		paramMap.put("lastname", spitter.getLastName());
//		paramMap.put("username", spitter.getUserName());
//		paramMap.put("password", spitter.getPassword());
//		
//		namedParameterJdbcOperations.update(SAVE_SPITTER, paramMap);
//		return spitter;
//		
//	}
//
//	@Override
//	public Spitter get(String username) {
//		Map<String,Object> paramMap = new HashMap<>();
//		paramMap.put("username", username);
//		return namedParameterJdbcOperations.queryForObject(GET_SPITTER_BY_USERNAME, paramMap, (rs, row) -> {
//			return new Spitter(rs.getLong("id"), rs.getString("firstname"), rs.getString("lastname"),
//					rs.getString("username"), rs.getString("password"));
//		});
//	}
//
//}
