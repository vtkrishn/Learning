#### JAVA API for Database Connection

* JDBC API
* JDBC Driver Manager
* JDBC Driver

>![](https://www.tutorialspoint.com/jdbc/images/jdbc-architecture.jpg)

##### Types
* JDBC ODBC
* JDBC NATIVE
* JDBC NET
* 100% PURE


* DriverManager
* Driver
* Connection
* Resultset
* SQLException

>Create Database <Database name>
Drop Database <name>

>Create Table <table name>(
  column1 type <primary key>,
  column2 type ...
  column n type
  );
Drop table <name>

>Insert into <table name> values (column1, column2)
> Update <table name> set column=<value> where <clause>
> Delete from <table name>

>Select <column names> from <table name> where <clause> order by (ASC|DESC) group by <column names> having <clause>

##### API
* Class.forName("com.mysql.jdbc.Driver"); // register
* conn = DriverManager.getConnection(DB_URL,USER,PASS); // get the Connection
* stmt = conn.createStatement();
* ResultSet rs = stmt.executeQuery(sql);
* iterate

* Driver myDriver = new oracle.jdbc.driver.OracleDriver();
* DriverManager.registerDriver( myDriver );
* String URL = "jdbc:oracle:thin:username/password@amrood:1521:EMP";
* Connection conn = DriverManager.getConnection(URL);

* boolean execute()
* int executeUpdate()
* ResultSet executeQuery()

* addBatch()
* executeBatch()

>Statement stmt = conn.createStatement();
   String SQL = "INSERT INTO Employees  " +
                "VALUES (106, 20, 'Rita', 'Tez')";
   stmt.executeUpdate(SQL);  
   //Submit a malformed SQL statement that breaks
   String SQL = "INSERTED IN Employees  " +
                "VALUES (107, 22, 'Sita', 'Singh')";
   stmt.executeUpdate(SQL);
   // If there is no error.
   conn.commit();

>CallableStatement cstmt = null;
try {
   String SQL = "{call getEmpName (?, ?)}";
   cstmt = conn.prepareCall (SQL);
   . . .
}
catch (SQLException e) {
   . . .
}
finally {
   cstmt.close();
}

>PreparedStatemen pstmt = conn.prepareStatement(SQL);
//Set auto-commit to false
conn.setAutoCommit(false);
// Set the variables
pstmt.setInt( 1, 400 );
pstmt.setString( 2, "Pappu" );
pstmt.setString( 3, "Singh" );
pstmt.addBatch();
