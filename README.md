# WebServerCustomizer
Sample to reproduce WebServerCustomizer not available to management webserver

## Steps
1. Run server 
  `mvn spring-boot:run -Dspring-boot.run.arguments=--management.server.port=8082`

2. `curl -v -X TRACE http://localhost:8080` :Expectedly give `405`
3. `curl -v -X TRACE http://localhost:8082` : gives `200` confirming the configuration as provided by `UndertowCustomizer` is not available to management server

Looking for help to have the configuration replicated to management webserver.
