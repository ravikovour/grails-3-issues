
package com.mycompany.db

import javax.sql.DataSource
import java.sql.Connection
import java.sql.SQLException
import java.sql.SQLFeatureNotSupportedException

import oracle.jdbc.OracleConnection


import grails.util.Environment
import grails.util.Holders
import groovy.sql.Sql

public class CustomDataSource implements DataSource {

	DataSource vendorDataSource
    DataSource customerDataSource
	def nativeJdbcExtractor

	public Connection getConnection() throws SQLException {
		println "getConnection ====> in Custom DataSource "
		Connection conn
		CustomConnection customConnection
		conn = vendorDataSource.getConnection()
		OracleConnection oconn = nativeJdbcExtractor.getNativeConnection(conn)
		customConnection = new CustomConnection(conn, null, this)
		
	}
	
    public Connection getConnection(String username, String password) {
        println "getConnection(userName,password) ====> Custom DataSource"
		Connection conn = null;
		return conn
    }	
	
	void setLoginTimeout(int i) {
        //log.trace "setLoginTimeout i = $i"
        setLoginTimeout
    }


    int getLoginTimeout() {
        //log.trace 'getLoginTimeout'
        println "getLoginTimeout"
    }
	
	
	java.util.logging.Logger getParentLogger() throws SQLFeatureNotSupportedException {
        throw new SQLFeatureNotSupportedException("Operation getParentLogger not supported.");
    }
	
	public void setLogWriter(PrintWriter printWriter) {
        //log.trace "CustomDS.setLogWriter(printWriter) will set '$printWriter' onto the underyling dataSource"
         println "setLogWriter"
    }


    public PrintWriter getLogWriter() {
        //log.trace 'CustomDS.getLogWriter() will delegate to underlying dataSource'
        println "getLogWriter"
    }
	
    boolean isWrapperFor(Class clazz) {
        //log.trace "CustomDS.isWrapperFor(clazz) was invoked with '$clazz' and will delegate to the underlying dataSource"
         println "isWrapperFor"
    }


    Object unwrap(Class clazz) {
        //log.trace "CustomDS.unwrap(clazz) was invoked with '$clazz' and will delegate to the underlying dataSource"
        println "unwrap"
    }	
	
	/************** custom added **************/
	
	public void setIdentifier(conn, identifier) {

    }
	
    public void closeProxySession(OracleConnection conn, String proxiedUserName) {

        //log.trace "${super.toString()}.closeProxySession(OracleConnection) will close proxy session for $conn"
        if (conn.isProxySession()) {
            conn.close(OracleConnection.PROXY_SESSION)
        }
    }


    public void closeProxySession(CustomConnection conn, String proxiedUserName) {

        closeProxySession(conn.extractOracleConnection(), proxiedUserName)
    }	
	
	public void clearIdentifer(conn) {

    }
	
    public void clearDbmsApplicationInfo(conn) {
		
    }	
	


}