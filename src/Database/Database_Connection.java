package Database;
import java.sql.*;

public class Database_Connection {
    static final String DB_URL = "jdbc:postgresql://localhost:5432/Printing_System_OOPS";
    static final String USER = "postgres";
    static final String PASS = "Ritik@1234";

    public static Connection connect() {
        try {
            return DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            System.out.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return null;
    }
    public static void TableCreation(){
        try(Connection conn = Database_Connection.connect();
            Statement stmt = conn.createStatement()
        ) {/*
            *
            * The table employee_details is to be prepared in SQL
            *
            sql = "CREATE TABLE employee_details" +
                    "(empid INTEGER AUTO_INCREMENT,"+
                    "name VARCHAR(30)not NULL , " +
                    "phone VARCHAR(10) not NULL, " +
                    "department VARCHAR(20) not NULL, " +
                    "room_no VARCHAR(10)not NULL , " +
                    "print_elig VARCHAR(3) not NULL, " +
                    "PRIMARY KEY (empid))";
            */

             String  sql = "CREATE TABLE login_details" +
                    "(username VARCHAR(20) not NULL ,"+
                    "password VARCHAR(15)not NULL , " +
                    "empid INTEGER not NULL, " +
                    "PRIMARY KEY (username)," +
                    "FOREIGN KEY (empid) references employee_details)";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO login_details VALUES " +
                    "('testuser'," + " 'password',"+" 'A101')";
            stmt.executeUpdate(sql);

            /*
            * The table employee_details is to be prepared in SQL
            *
            sql = "CREATE TABLE PRINT_DETAILS " +
                    "(reqid INTEGER AUTO_INCREMENT, " +
                    "empid INTEGER not NULL , " +
                    "filename varchar(200) not NULL, " +
                    "papersize varchar(20) not NULL,"+
                    "color VARCHAR(3) not NULL ,"+
                    "doublesided VARCHAR(3) not NULL,"+
                    "Copies INTEGER,"+
                    "tasktype VARCHAR(10),"+
                    "Orientation VARCHAR(12),"+
                    "PRIMARY KEY (reqid)," +
                    "FOREIGN KEY (empid) references employee_details)";
                */
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public static void main(String[] args){
       connect();
    }
}

