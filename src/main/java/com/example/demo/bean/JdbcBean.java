package com.example.demo.bean;

public class JdbcBean {
/*
	@Autowired
	private DatabaseConfig databaseConfig;

	@Bean(destroyMethod = "close")
	Connection connection() {
		try {
			Class.forName(databaseConfig.getDriverClassName());
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Cannot init driver", e);
		}

		Connection connection;
		try {
			connection = DriverManager.getConnection(databaseConfig.getUrl(), databaseConfig.getUsername(),
					databaseConfig.getPassword());
			connection.setReadOnly(true);
			connection.setAutoCommit(true);
		} catch (SQLException e) {
			throw new RuntimeException("Cannot obtain connection", e);
		}
		return connection;
	}

	@Bean(destroyMethod = "close")
	Connection secondConnection() {
		try {
			Class.forName(databaseConfig.getSecondDriverClassName());
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Cannot init driver", e);
		}

		Connection connection;
		try {
			connection = DriverManager.getConnection(databaseConfig.getSecondUrl(), databaseConfig.getSecondUsername(),
					databaseConfig.getSecondPassword());
			connection.setReadOnly(true);
			connection.setAutoCommit(true);
		} catch (SQLException e) {
			throw new RuntimeException("Cannot obtain connection", e);
		}
		return connection;
	}

	@Bean(destroyMethod = "destroy")
	DataSource dataSource(Connection connection) {

		SingleConnectionDataSource ret = new SingleConnectionDataSource(connection, true);
		return ret;
	}

	@Bean
	NamedParameterJdbcTemplate namedParameterJdbcTemplate(DataSource dataSource) {
		return new NamedParameterJdbcTemplate(dataSource);
	}

	@Bean
	JdbcTemplate jdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource, true);
	}
	*/
}
