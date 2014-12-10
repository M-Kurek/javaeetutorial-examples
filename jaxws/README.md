# howto

- preparing wsdl (and server classes): 
  - cd helloservice-war
  - mvn clean package
- compile web client
  - cd ../hello-webclient
  - mvn clean package
- run server
  - cd ../helloservice-war
  - mvn jboss-as:run
  - CHECK : open http://localhost:8080/helloservice-war/Hello?wsdl
- install client
  - copy ../hello-webclient/target/hello-webclient.war to jboss deployment folder (in target/jboss...../standalone/)
  - CHECK : http://localhost:8080/hello-webclient/HelloServlet
