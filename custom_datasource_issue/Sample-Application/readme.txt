
1) Provided a sample application with Oracle
2) H2 database can not be provided as the behaviour is different
3) With oracle If I remove dataSource entry as we are injecting in runtime. It fails on startup.
4) check the code snippet in DataCoreGrailsPlugin.groovy
	The bean created with dataSouce name its life cycle methods like getConnection() etc never get called in runtime.
	
5)provided a sample database script which creates one table and there is corresponding jpa entity in the source code