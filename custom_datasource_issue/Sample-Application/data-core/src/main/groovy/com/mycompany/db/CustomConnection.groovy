
package com.mycompany.db


import javax.sql.DataSource
import java.sql.Connection
import java.sql.SQLException
import java.sql.CallableStatement

import oracle.jdbc.OracleConnection
import grails.util.Environment

import org.apache.log4j.Logger



/**
 * A dataSource that proxies connections, sets roles needed for the current request,
 * and invokes p_commit and p_rollback.
 * */
class CustomConnection {

    @Delegate
    Connection underlyingConnection

    def proxyUserName
    def customDataSource
    def oracleConnection // the native connection
    boolean isCached

    private final Logger log = Logger.getLogger(getClass())

    CustomConnection(Connection conn, DataSource customDataSource) {
        underlyingConnection = conn
        this.customDataSource = customDataSource
        log.trace "CustomConnection has been constructed: ${this}"
		//invokeProcedureCall 
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
     * an invocation of the 'p_commit' stored procedure, as required by business
     */
    public void commit() throws SQLException {
        log.trace "CustomConnection ${super.toString()} 'commit()' invoked"
		println "CustomConnection.groovy =====> commit()"
        //invokeProcedureCall 
        customDataSource.clearDbmsApplicationInfo(this)
    }

    /**
     * Replaces the invocation of rollback on the underlying connection with
     * an invocation of the 'p_rollback' stored procedure, as required by business
     */
    public void rollback() throws SQLException {
        log.trace "CustomConnection ${super.toString()}.rollback() invoked"
		println "CustomConnection.groovy =====> rollback()"
        //invokeProcedureCall 
        customDataSource.clearDbmsApplicationInfo(this)
    }


    public void close() throws SQLException {
        try {
            log.trace "CustomConnection ${super.toString()}.close() invoked"
            if (!isCached) {
                log.debug Thread.currentThread().getName()
                log.debug "Closing proxy session for env ${Environment.current} and user ${proxyUserName}}"
                customDataSource.closeProxySession( this, proxyUserName )
                customDataSource.clearIdentifer( this )
            }

        } finally {
            log.trace "${super.toString()} will close it's underlying connection: $underlyingConnection, that wraps ${extractOracleConnection()}"
            if (!proxyUserName || (proxyUserName == "anonymousUser") || !isCached) {
                log.trace "${super.toString()} closing $underlyingConnection}"
                log.debug Thread.currentThread().getName()
                log.debug "Closing underlyign connection for env ${Environment.current} and user ${proxyUserName}}"
                underlyingConnection?.close()
            }
        }
    }



    /**
     * Invokes the supplied stored procedure call.
     * @param procedureCall the stored procedure to call
     * @throws SQLException if reported when executing this stored procedure
     */
    private void invokeProcedureCall(String procedureCall) throws SQLException {
        log.trace "CustomConnection ${super.toString()}.invokeProcedureCall() will execute '$procedureCall'"
        CallableStatement cs
        try {
            cs = underlyingConnection.prepareCall(procedureCall)
            cs.execute()
        }
        finally {
            cs?.close()
        }
    }


    boolean isWrapperFor(Class clazz) {
        log.trace "isWrapperFor clazz = $clazz"
    }


    Object unwrap(Class clazz) {
        log.trace "unwrap clazz = $clazz"
    }


    public String toString() {
        "${super.toString()}[user='${proxyUserName}', oracle connection='${extractOracleConnection()}']"
    }
}
