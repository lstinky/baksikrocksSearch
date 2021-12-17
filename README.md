# baksikrocksSearch
микросервис для поиска на сайте baksik.rocks

Для корректной работы необходимо добавить файл src/main/resources/application.properties с следующим содержанием. Строка spring.jpa.generate-ddl=false говорит о том, что мы не будем генерировть структуру в БД на основании классов java

____
spring.datasource.url=jdbc:postgresql://host:port/nameDatabase  
spring.datasource.username=login  
spring.datasource.password=pass  
spring.jpa.generate-ddl=false  
