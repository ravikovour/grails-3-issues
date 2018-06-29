
package com.mycompany.db

import javax.sql.DataSource
import java.sql.Connection
import java.sql.SQLException
import java.sql.SQLFeatureNotSupportedException
import org.springframework.jdbc.support.nativejdbc.CommonsDbcpNativeJdbcExtractor

import oracle.jdbc.OracleConnection

import grails.util.Environment
import grails.util.Holders
import groovy.sql.Sql

public class CustomDataSource implements DataSource {


	def nativeJdbcExtractor

	public Connection getConnection() throws SQLException {
		Connection conn
		//Get the database connection using JDBC or JNDI lookup from appserver connection pool
		//We will get the connection using external config properties jdbcurl or jndiname etc
		OracleConnection oconn = nativeJdbcExtractor.getNativeConnection(conn)
		//set some native parameters to oracle connection
		customCon= new CustomConnection(oconn, null, this)
		return customCon
	}
	
    public Connection getConnection(String username, String password) {
		//Get the database connection using JDBC or JNDI lookup from apperver con pool
		OracleConnection oconn = nativeJdbcExtractor.getNativeConnection(conn)
		//set some native parameters to oracle connection
		customCon= new CustomConnection(oconn, null, this)
		return customCon
    }	
	
	void setLoginTimeout(int i) {
		//TODO implelement 
        setLoginTimeout
    }


    int getLoginTimeout() {
       //TODO implelement 
        println "getLoginTimeout"
    }
	
	
	java.util.logging.Logger getParentLogger() throws SQLFeatureNotSupportedException {
        throw new SQLFeatureNotSupportedException("Operation getParentLogger not supported.");
    }
	
	public void setLogWriter(PrintWriter printWriter) {
		//TODO implelement 
         println "setLogWriter"
    }


    public PrintWriter getLogWriter() {
        
        println "getLogWriter"
    }
	
    boolean isWrapperFor(Class clazz) {

         println "isWrapperFor"
    }


    Object unwrap(Class clazz) {
       
        println "unwrap"
    }	
	

}