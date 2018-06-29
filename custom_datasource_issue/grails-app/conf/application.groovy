server.port=8090
server.'contextPath' = '/ConfigDemo'


hibernate {
    cache.provider_class = 'net.sf.ehcache.hibernate.EhCacheProvider'
    cache.region_prefix = ''
    cache.region.factory_class = 'org.hibernate.cache.ehcache.SingletonEhCacheRegionFactory'
    //This is legacy prop.Not required
    //hbm2ddl.auto = false

    show_sql = false

    dialect = "org.hibernate.dialect.Oracle10gDialect"
	
	//specify the package for JPA domains/entities preset
    packagesToScan="com.mycompany."


    /*** need to remove and externalize config ***/

}



dataSource {
		driverClassName = "oracle.jdbc.OracleDriver"
		url = "jdbc:oracle:thin:@localhost:1521:TESTDB"	
		driverClassName = "oracle.jdbc.OracleDriver"
		username = "TESTUSER"
		password = "TESTPWD"
}
	

//}


environments {
    
	development {
        dataSource {
        }
    }
    test {
        dataSource {
        }
    }
    production {
        dataSource {
        }
    }
}



