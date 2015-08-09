+----------------------------+
WHERE TO PUT THINGS?
+----------------------------+

api
================================
	All local/remote interfaces and POJOs used by other services. 
	
	This is the module other services will depend on (compile time) when using your service.
	Anything found in this module will be considered part of your interface.


jar
================================
	CDI (non-JEE) implementation. Might be used when testing JSE environment. Should not use anything not available in CDI environment
	(JEE things, for example).


ejb
================================
	JEE wrapper around (mostly for remoting and transaction management) around jar module.
	Should contain only EJBs (SLSB, SFSB, Singletons).


war
================================
	All web implementation artifacts: Restful services, Servlets, JSPs etc


ear
================================
	Responsible for packaging whole project. 


+----------------------------+
DEPLOYING TO JBOSS
+----------------------------+
	System property JBOSS_HOME should point to the installation folder of JBoss.
	
	Once you started JBoss you have to execute mvn jboss-as:deploy to deploy service
	or execute "./deploy_to_local_jboss.sh" to copy the ear to deployments folder 


+----------------------------+
NOTE FOR LOGGING
+----------------------------+
	Update standalone.xml with 
	            <logger category="com.pd.jee" use-parent-handlers="true">
	                <level name="DEBUG"/>
	            </logger>
            

+----------------------------+
NOTE FOR DERBY DB
+----------------------------+			
Direct Deployment
	The first solution is a very easy way to deploy the Derby driver in the application server. 
	If you quickly want to test something it is sufficient. But in a productive environment it 
	is better to create a module definition in the JBoss. (see next section)
	
	To deploy the Derby driver directly you simply copy the driver derbyclient.jar into the directory 
		[JBOSS]/standalone/deployments. 
	If the server is running the new file is recognized by JBoss and automatically deployed.
	
	
	Then you have to adapt the file [JBOSS]/standalone/configuration/standalone.xml. 
	Add the following section into the file:			

	<datasources>
		<datasource jndi-name="java:jboss/datasources/DerbyDS" pool-name="DerbyDS" enabled="true" use-ccm="false">
			<connection-url>jdbc:derby://localhost:1527/derbyDBJee;create=true</connection-url>
			<driver-class>org.apache.derby.jdbc.ClientDriver</driver-class>
			<driver>derbyclient.jar</driver>
			<security>
				<user-name>demo</user-name>
				<password>demo</password>
			</security>
			<validation>
				<validate-on-match>false</validate-on-match>
				<background-validation>false</background-validation>
			</validation>
			<statement>
				<share-prepared-statements>false</share-prepared-statements>
			</statement>
		</datasource>
		<drivers>
			<driver name="org.apache.derby" module="org.apache.derby">
				<xa-datasource-class>org.apache.derby.jdbc.ClientXADataSource</xa-datasource-class>
			</driver>
		</drivers>
	</datasources>	