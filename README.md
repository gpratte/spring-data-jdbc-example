# spring-data-jdbc-example
Example of the Spring Data JDBC mappings.

In the Parent class you will find the following fields
<pre>       @Id
       private int id;
       private int count;
       @MappedCollection(idColumn = "ID")
       OneToOne oneToOne;
       @MappedCollection
       Set<Day> days;
       @MappedCollection
       Map<String, Color> colors;
       @MappedCollection
       List<Car> cars;
       @MappedCollection
       List<Orderr> orders;</pre>

The database schema can be found in the create_db.sql file.

Spring Data JDBC will map the Java object to the tables.