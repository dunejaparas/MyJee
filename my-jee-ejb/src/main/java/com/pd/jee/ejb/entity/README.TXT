EJB 3.0, entity bean used in EJB 2.0 is largely replaced by persistence mechanism. Now entity bean is a simple POJO having mapping with table.

Following are the key actors in persistence API

Entity - A persistent object representing the data-store record. It is good to be serializable.

EntityManager - Persistence interface to do data operations like add/delete/update/find on persistent object(entity). It also helps to execute queries using Query interface.

Persistence unit (persistence.xml) - Persistence unit describes the properties of persistence mechanism.

Data Source (*ds.xml) - Data Source describes the data-store related properties like connection url. user-name,password etc.

To demonstrate ejb persistence mechanism, we're going to do the following tasks.

Step 1. Create table in database.

Step 2. Create Entity class corresponding to table.

Step 3. Create Data Source and Persistence Unit

Step 4. Create a stateless ejb having EntityManager instance.

Step 5. Update stateless ejb. Add methods to add records and get records from database via entity manager.

Step 6. A console based application client will access the stateless ejb to persist data in database.




