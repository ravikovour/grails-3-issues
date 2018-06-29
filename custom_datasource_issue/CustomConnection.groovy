package com.mycompany.db

import javax.sql.DataSource
import java.sql.Connection
import java.sql.SQLException
import java.sql.CallableStatement

import oracle.jdbc.OracleConnection
import grails.util.Environment

import org.apache.log4j.Logger



class CustomConnection {

    @Delegate
    Connection underlyingConnection

    def proxyUserName
    def customDataSource
    def oracleConnection // the native connection
    boolean isCached

    private final Logger log = Logger.getLogger(getClass())

    CustomConnection(Connection conn, DataSource customDataSource) {
        assert conn
        assert customDataSource
        underlyingConnection = conn
        this.customDataSource = customDataSource

    }


    CustomConnection(Connection conn, String userName, customDataSource) {
        this(conn, customDataSource)
        proxyUserName = userName
        customDataSource.setIdentifier(conn, userName)
    }


    public OracleConnection extractOracleConnection() {
        if (!oracleConnection) {
            oracleConnection = customDataSource.nativeJdbcExtractor.getNativeConnection(underlyingConnection)
        }
        oracleConnection
    }

    /**
     * Replaces the invocation of 'commit' on the underlying connection with
     * an invocation of custom logic before commit
     * @see java.sql.Connection#commit()
     */
    public void commit() throws SQLException {

    }

    /**
     * Replaces the invocation of rollback on the underlying connection with
	 * an invocation of custom logic before rollback
     * @see java.sql.Connection#rollback()
     */
    public void rollback() throws SQLException {

    }


    public void close() throws SQLException {
        try {
			//custom logic
            customDataSource.closeProxySession( this, proxyUserName )

        } finally {
                underlyingConnection?.close()
            }
        }
    }



    boolean isWrapperFor(Class clazz) {
        log.trace "isWrapperFor clazz = $clazz"
    }


    Object unwrap(Class clazz) {
        log.trace "unwrap clazz = $clazz"
    }

}
