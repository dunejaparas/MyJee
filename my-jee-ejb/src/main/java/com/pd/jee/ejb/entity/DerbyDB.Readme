http://db.apache.org/derby/papers/DerbyTut/index.html


#########################################################################

		Derby JDBC database connection URL for embedded driver

#########################################################################


Following is the syntax of Derby JDBC database connection URL for the embedded driver:

	jdbc:derby:[subsubprotocol:][databaseName][;attribute=value]*


Where subsubprotocol tells where Derby should look for the database. It can be one of:

	directory			: looks for the database in the file system. The directory can be relative path or absolute path. 
							For the relative path, Derby will look in the system directory (specified by the environment variable user.dir). 
							This is the default location if subsubprotocol is not specified.
	memory				: looks for the database in memory. This may e useful in case we only use a temporary database.
	classpath			: looks for the database in the file system which is relative to the classpath directory. In this way the database is 
							treated as in read-only mode.
	jar					: looks for the database inside a jar or zip file. Read-only mode.
	attribute=value		: specifies one or more additional attributes when making the connection. Some commonly used attributes are:
	create=true			: creates the database if it does not exist.
	shutdown=true		: closes the database. This must be used without database name.
	user=<username>		: specifies the username to connect.
	password=<password>	: specifies password of the username to connect.


Example connection URLs:
	Connect and create a database called webdb under the directory codejava. The database path is relative to the system directory.
	jdbc:derby:codejava/webdb;create=true
	
	Connect to a database in the file system using absolute path: 
	jdbc:derby:E:/projects/codejava/webdb;create=true
	
	Connect and create a database if not exist in the memory:
	jdbc:derby:memory:codejava/webdb;create=true
	
	Connect to a database presents in the classpath:
	jdbc:derby:classpath:webdb
	
	Where the absolute directory E:/projects/codejava is added to the classpath.
	
	Connect to a database called webdb inside a jar file which is on the classpath:
	jdbc:derby:jar:webdb
	
	Connect to a database called webdb inside a jar file db.jar which is not on the classpath:
	jdbc:derby:jar:(E:/projects/db.jar)webdb
	
	Shutdown the current database:
	jdbc:derby:;shutdown=true
	
	
	
##################################################

	Location of Derby DB (embedded)

	 $JAVA_HOME\db\bin
	
		C:\Program Files\Java\jdk1.7.0_75\db\bin

	Location of Derby DB (installed)
	cd DERBY_INSTALL_LOCATION/lib

	<dependency>
		<groupId>org.apache.derby</groupId>
		<artifactId>derbyclient</artifactId>
		<version>10.11.1.1</version>
	</dependency>


	$ java -jar derbyrun.jar server start &
	$ java -jar derbyrun.jar server shutdown

##################################################
##################################################

	
1. Apache Derby

1.1. Overview

		Apache Derby is an open source database written in Java. It is free and performs well. Apache Derby is used in the JDK 
		and is called Java DB. Apache Derby and Java DB are essentially the same. Apache Derby is the reference implementation 
		for JDBC 4.0 and compatible to ANSI-SQL. JDBC is the Java interface to connect to databases.

1.2. Server vs. embedded mode

		Derby can be used in a server mode and in so-called embedded mode. If Derby runs in the server mode you start the Derby 
		network server which will be responsible for handling the database requests. In embedded mode Derby runs within the JVM 
		(Java Virtual Machine) of the application. In this mode only the application can access the database, e.g. another user 
		/ application will not be able to access the database.

2. Installation of Derby

		Download the latest Derby version from the Apache website http://db.apache.org/derby/. Choose the bin distribution and 
		extract this zip to a directory of your choice. Also make the Derby tools available in your path via the following:

		Set the environment variable DERBY_HOME to the Derby installation directory

		Add DERBY_HOME/bin to the "path" environment variable

3. Server mode

	3.1. Starting Derby in server mode
	
		Use the following command in the command line to start the Derby network server (located in the Derby installation directory/bin). 
		On Microsoft Windows it is possible to use the .bat version.
		
		startNetworkServer 
		
		
		This will start the network server which can serve an unlimited number of database. By default the server will be listening on port 
		1527 but this can be changed via the -p option.
		
		startNetworkServer -p 3301 
		
		
		
		By default Derby will only accept connections from the localhost. To make the Derby server accept connections also from other hosts 
		then use the following start command. Replace "sampleserver.sampledomain.com" with the name or the IP of the server. The server will 
		then accept connections only from other servers as the localhost.
		
		startNetworkServer -h sampleserver.sampledomain.com 
		
		
		
		If connections should be allowed from localhost and any other server use the following.
		
		startNetworkServer -h 0.0.0.0 
	
	###################