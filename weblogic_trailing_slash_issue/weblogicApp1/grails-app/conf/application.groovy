server.contextPath="/MySampleApp"
grails.web.servlet.path='/'

// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.userLookup.userDomainClassName = 'weblogicapp1.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'weblogicapp1.UserRole'
grails.plugin.springsecurity.authority.className = 'weblogicapp1.Role'
grails.plugin.springsecurity.controllerAnnotations.staticRules = [
		[pattern: '/',               access: ['ROLE_USER']],
		[pattern: '/error',          access: ['permitAll']],
		[pattern: '/index',          access: ['ROLE_USER']],
		[pattern: '/index.gsp',      access: ['ROLE_USER']],
		[pattern: '/home.gsp',       access: ['ROLE_USER']],
		[pattern: '/shutdown',       access: ['permitAll']],
		[pattern: '/assets/**',      access: ['permitAll']],
		[pattern: '/**/js/**',       access: ['permitAll']],
		[pattern: '/**/css/**',      access: ['permitAll']],
		[pattern: '/**/images/**',   access: ['permitAll']],
		[pattern: '/**/favicon.ico', access: ['permitAll']]
]

grails.plugin.springsecurity.filterChain.chainMap = [
	[pattern: '/assets/**',      filters: 'none'],
	[pattern: '/**/js/**',       filters: 'none'],
	[pattern: '/**/css/**',      filters: 'none'],
	[pattern: '/**/images/**',   filters: 'none'],
	[pattern: '/**/favicon.ico', filters: 'none'],
	[pattern: '/**',             filters: 'JOINED_FILTERS']
]


dataSource{
	dbCreate = "create-drop"
	url = "jdbc:h2:mem:devDb;MVCC=TRUE;LOCK_TIMEOUT=10000;DB_CLOSE_ON_EXIT=-1"
	pooled = true
	jmxExport = true
	driverClassName = "org.h2.Driver"
	username = "sa"
	password =  ''
}

hibernate {
    show_sql = false
    cache {
		queries=false
        use_second_level_cache=false
        use_query_cache=false
	}
    packagesToScan="com.sample.jpa.domains"
}



