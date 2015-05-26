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
            
