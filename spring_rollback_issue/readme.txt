
* The table creation scripts are presetn in 

* Import SpringRollbakTest grails project
  do a grails clean,compile and run-app
* On the index page clink on RegController link
* This controller calls a service which insert record into two tables (University and Course)
* If second one fails first one is not getting rollback (For Spring Transcational)
* If we use grails Transactional annotation it works fine

* In application.groovy - added packageToScan property



