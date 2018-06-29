

/* Merged Datasource.groovy from Grails-2.5 */



dataSource {
    //configClass = org.grails.orm.hibernate.cfg.GrailsAnnotationConfiguration.class
    //configClass = org.grails.orm.hibernate.HibernateMappingContextConfiguration.class

    dialect = "org.hibernate.dialect.Oracle10gDialect"
    loggingSql = false
    pooled = true
    jmxExport = true
    url = "jdbc:oracle:thin:@localhost:1521:TESTDB"
    driverClassName = "oracle.jdbc.OracleDriver"
    username = "TESTUSER"
    password = "TESTPASS"

}


hibernate {
    cache {
        queries = false
        use_second_level_cache = true
        use_query_cache = false
        region.factory_class = "org.hibernate.cache.ehcache.SingletonEhCacheRegionFactory"
    }
    
	packagesToScan="com.mycompany.business"
    
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