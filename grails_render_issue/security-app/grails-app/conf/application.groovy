/**** Spring security settings ***/

/*** For Grails-2.5 ***/
/*
import grails.plugin.springsecurity.SecurityConfigType
grails.plugin.springsecurity.securityConfigType = SecurityConfigType.InterceptUrlMap
*/

/*** Modified for Grails-3 ***/
grails.plugin.springsecurity.securityConfigType = grails.plugin.springsecuritySecurityConfigType.InterceptUrlMap

grails.plugin.springsecurity.interceptUrlMap = [
        [pattern:'/',access:['IS_AUTHENTICATED_ANONYMOUSLY']],
        [pattern:'/resetPassword/**',access:['IS_AUTHENTICATED_ANONYMOUSLY']],
        [pattern:'/login/**',access:['IS_AUTHENTICATED_ANONYMOUSLY']],
        [pattern:'/index**',access:['IS_AUTHENTICATED_ANONYMOUSLY']],
        [pattern:'/logout/**',access:['IS_AUTHENTICATED_ANONYMOUSLY']],
        [pattern: '/assets/**',access: ['IS_AUTHENTICATED_ANONYMOUSLY']],
        [pattern:'/javascripts/**',access:['IS_AUTHENTICATED_ANONYMOUSLY']],
        [pattern:'/stylesheets/**',access:['IS_AUTHENTICATED_ANONYMOUSLY']],
        [pattern:'/css/**',access:['IS_AUTHENTICATED_ANONYMOUSLY']],
        [pattern:'/images/**',access:['IS_AUTHENTICATED_ANONYMOUSLY']],
        [pattern:'/js/**',access:['IS_AUTHENTICATED_ANONYMOUSLY']],
        [pattern:'/css/**',access:['IS_AUTHENTICATED_ANONYMOUSLY']]
]


/* Merged Datasource.groovy from 2.5 */



dataSource {
    //configClass = org.grails.orm.hibernate.cfg.GrailsAnnotationConfiguration.class
    //configClass = org.grails.orm.hibernate.HibernateMappingContextConfiguration.class

    dialect = "org.hibernate.dialect.Oracle10gDialect"
    loggingSql = false
    pooled = true
    jmxExport = true
    url = "jdbc:oracle:thin:@localhost:1521:TESTDB"
    driverClassName = "oracle.jdbc.OracleDriver"
    username = "testuser"
    password = "test123"

}


hibernate {
    cache {
        queries = false
        use_second_level_cache = true
        use_query_cache = false
        region.factory_class = "org.hibernate.cache.ehcache.SingletonEhCacheRegionFactory"
    }
    

    show_sql = false
//   	naming_strategy = "org.hibernate.cfg.ImprovedNamingStrategy"
    dialect = "org.hibernate.dialect.Oracle10gDialect"

    config.location = [
            "classpath:hibernate.cfg.xml",
            "classpath:hibernate-sample-core.cfg.xml",
    ]

}


// environment specific settings
environments {
    development {
        dataSource {
            dbCreate = "none"
            url = "jdbc:oracle:thin:@localhost:1521:TESTDB"
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
