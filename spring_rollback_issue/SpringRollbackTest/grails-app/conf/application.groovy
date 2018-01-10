server.port=8080

grails.spring.transactionManagement.proxies = false


/* Merged Datasource.groovy from 2.5 */
// Note: Most of the dataSource configuration resides in resources.groovy and in the
// installation-specific configuration file (see Config.groovy for the include).

dataSource {
 
    dialect = "org.hibernate.dialect.Oracle10gDialect"
    loggingSql = false
    pooled = true
    jmxExport = true
    url = "jdbc:oracle:thin:@localhost:1521:BAN83"
    driverClassName = "oracle.jdbc.OracleDriver"
    username = "system"
    password = "xxxxxx"

}


hibernate {
    cache {
        queries = false
        use_second_level_cache = true
        use_query_cache = false
        region.factory_class = "org.hibernate.cache.ehcache.SingletonEhCacheRegionFactory"
    }
    
	packagesToScan="com.student"
    
    //cache.use_second_level_cache = true
    //cache.use_query_cache = true
    //cache.provider_class = 'net.sf.ehcache.hibernate.EhCacheProvider'
    // cache.region.factory_class = 'net.sf.ehcache.hibernate.EhCacheRegionFactory' // Hibernate 3
    //cache.region.factory_class = 'org.hibernate.cache.ehcache.EhCacheRegionFactory' // Hibernate 4
    //hbm2ddl.auto = false
    show_sql = false
//   	naming_strategy = "org.hibernate.cfg.ImprovedNamingStrategy"
    dialect = "org.hibernate.dialect.Oracle10gDialect"

}

// environment specific settings
environments {
    development {
        dataSource {
            dbCreate = "none"
            url = "jdbc:oracle:thin:@localhost:1521:BAN83"
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