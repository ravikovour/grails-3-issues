vendorDataSource {
     // JNDI configuration for use in 'production' environment
    jndiName = "jdbc/vendorDataSource"

	url="jdbc:oracle:thin:@localhost:1521:TESTDB"
 
    username = "testuser"
    password = "testpwd"	
    driver   = "oracle.jdbc.OracleDriver"
 }

customerDataSource {
 
    // JNDI configuration for use in 'production' environment
    jndiName = "jdbc/customerDataSource"

	url="jdbc:oracle:thin:@localhost:1521:TESTDB"

    username = "testuser"
    password = "testpwd"	
    driver   = "oracle.jdbc.OracleDriver"

}

/*** If I remove following dataSource entry as we need to inject at runtime application will fail on startup ***/
dataSource {
 
	url="jdbc:oracle:thin:@localhost:1521:TESTDB"

	username = "testuser"
    password = "testpwd"	
    driverClassName = "oracle.jdbc.OracleDriver"

}

