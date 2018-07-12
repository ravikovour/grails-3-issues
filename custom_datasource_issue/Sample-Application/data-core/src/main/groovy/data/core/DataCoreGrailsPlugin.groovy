package data.core

import grails.plugins.*

import org.apache.commons.dbcp.BasicDataSource
import grails.util.Environment
import grails.util.Holders as CH
import groovy.util.logging.Slf4j
import org.springframework.jdbc.support.nativejdbc.CommonsDbcpNativeJdbcExtractor as NativeJdbcExtractor
import com.mycompany.db.CustomDataSource


@Slf4j
class DataCoreGrailsPlugin extends Plugin {

    // the version or versions of Grails the plugin is designed for
    def grailsVersion = "3.3.2 > *"
    // resources that are excluded from plugin packaging
    def pluginExcludes = [
        "grails-app/views/error.gsp"
    ]

    // TODO Fill in these fields
    def title = "Data Core" // Headline display name of the plugin
    def author = "Your name"
    def authorEmail = ""
    def description = '''\
Brief summary/description of the plugin.
'''
    def profiles = ['web']

    // URL to the plugin's documentation
    def documentation = "http://grails.org/plugin/data-core"

    // Extra (optional) plugin metadata

    // License: one of 'APACHE', 'GPL2', 'GPL3'
//    def license = "APACHE"

    // Details of company behind the plugin (if there is one)
//    def organization = [ name: "My Company", url: "http://www.my-company.com/" ]

    // Any additional developers beyond the author specified above.
//    def developers = [ [ name: "Joe Bloggs", email: "joe@bloggs.net" ]]

    // Location of the plugin's issue tracker.
//    def issueManagement = [ system: "JIRA", url: "http://jira.grails.org/browse/GPMYPLUGIN" ]

    // Online location of the plugin's browseable source code.
//    def scm = [ url: "http://svn.codehaus.org/grails-plugins/" ]

    Closure doWithSpring() { {->
            // TODO Implement runtime spring config (optional)
			
			
						println "================= doWithSpring =====>"

			
			println grailsApplication.config.getProperty('vendorDataSource.driver')
			println grailsApplication.config.getProperty('vendorDataSource.url')
			println grailsApplication.config.getProperty('vendorDataSource.username')
			println grailsApplication.config.getProperty('vendorDataSource.password')
			
		println "========= Current Environment : " + grails.util.Environment.current.name		
			
		switch (Environment.current) {
            case Environment.PRODUCTION:
                log.info "Will use a dataSource configured via JNDI"
                vendorDataSource(JndiObjectFactoryBean) {
                    jndiName = "java:comp/env/${CH.config.vendorDataSource.jndiName}"
                }
                customerDataSource(JndiObjectFactoryBean) {
                        jndiName = "java:comp/env/${CH.config.customerDataSource.jndiName}"
                }
                
                break
            
			default: // we'll use our locally configured dataSource for development and test environments
                log.info "Using development/test datasource"
				vendorDataSource(BasicDataSource) {
                    maxActive = 5
                    maxIdle = 2
                    defaultAutoCommit = "false"
                    driverClassName = "${CH.config.vendorDataSource.driver}"
                    url = "${CH.config.vendorDataSource.url}"
                    password = "${CH.config.vendorDataSource.password}"
                    username = "${CH.config.vendorDataSource.username}"
                }
                customerDataSource(BasicDataSource) {
                        maxActive = 5
                        maxIdle = 2
                        defaultAutoCommit = "false"
                        driverClassName = "${CH.config.customerDataSource.driver}"
                        url = "${CH.config.customerDataSource.url}"
                        password = "${CH.config.customerDataSource.password}"
                        username = "${CH.config.customerDataSource.username}"
                 }

                break
        }
		 
				 
				  nativeJdbcExtractor(NativeJdbcExtractor)


				  dataSource(CustomDataSource) {
						vendorDataSource = ref(vendorDataSource)
						try {
							customerDataSource = ref(customerDataSource)
						} catch (MissingPropertyException) { } // don't inject it if we haven't configured this datasource
						nativeJdbcExtractor = ref(nativeJdbcExtractor)
				  }	
  
        }
    }

    void doWithDynamicMethods() {
        // TODO Implement registering dynamic methods to classes (optional)
		
   }

    void doWithApplicationContext() {
        // TODO Implement post initialization spring config (optional)
    }

    void onChange(Map<String, Object> event) {
        // TODO Implement code that is executed when any artefact that this plugin is
        // watching is modified and reloaded. The event contains: event.source,
        // event.application, event.manager, event.ctx, and event.plugin.
    }

    void onConfigChange(Map<String, Object> event) {
        // TODO Implement code that is executed when the project configuration changes.
        // The event is the same as for 'onChange'.
    }

    void onShutdown(Map<String, Object> event) {
        // TODO Implement code that is executed when the application shuts down (optional)
    }
}
