/**** Spring security settings ***/

/*** For Grails-2.5 ***/
/*
import grails.plugin.springsecurity.SecurityConfigType
grails.plugin.springsecurity.securityConfigType = SecurityConfigType.InterceptUrlMap
*/


server.'contextPath' = '/MyDemoApp'
server.port=8080

/* external configuration file */
grails.config.locations = [
        '~/.grails/myapp_external_config.groovy'
]





/* Merged Datasource.groovy from Grails-2.5 */



/********* For H2 databse ********/
/*
dataSource {
	driverClassName = "org.h2.Driver"
    dialect = "org.hibernate.dialect.H2Dialect"
    url = "jdbc:h2:mem:testDb;MVCC=TRUE;LOCK_TIMEOUT=10000"
}
*/

hibernate {
    cache {
        queries = false
        use_second_level_cache = false
        use_query_cache = false
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