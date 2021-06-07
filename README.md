# SpringPerson

# To build the project (Steps as per Eclipse)
# 1. Right on the project name in Project Explorer and click on Maven/Update Project
# 2. Press Ctrl+B to compile
# 3. Should now show no errors and thus compiled
# 4. H2 in memory database used

# Add server connection to the project
# 1. Open Server window and click on add server
# 2. Select local tomcat directory and tomcat version and click add

# To run the project
# 1. Right on the project name in Project Explorer and click on Run As/Run On server
# 2. Tomcat should start

# To access REST endpoint from any client like Postman try following urls
# 1. Person CRUD
### POST/PUT/GET - (CREATE/UPDATE/LIST) -http://localhost:8080/spring/api/persons
### GETByID/DELETEById - http://localhost:8080/spring/api/persons/1
### COUNT - http://localhost:8080/spring/api/persons/count
# 2. Address CRUD
### POST/PUT/GET - (CREATE/UPDATE/LIST) -http://localhost:8080/spring/api/addresses
### GETD/DELETE - http://localhost:8080/spring/api/addresses/1

#Sample JSON - attached
