package web.winkel.webwinkel;

import org.springframework.web.bind.annotation.*;
// import java.util.logging.*;
import java.sql.*;

@RestController
public class Webwinkel {

    // Logger logger = Logger.getLogger(Webwinkel.class);

    private void printSQLException(SQLException e) {
        e.printStackTrace(System.err);
        System.err.println("SQLState: " + e.getSQLState());
        System.err.println("Error Code: " + e.getErrorCode());
        System.err.println("Message: " + e.getMessage());

        Throwable t = e.getCause();
        while(t != null) {
            System.out.println("Cause: " + t);
            t = t.getCause();
        }
    }

    private String sendRequest() throws Exception {
        String url = "jdbc:postgresql://localhost:5432/postgres?user=postgres&password=3141";
        String res = "no result";
        try {
            Connection conn = DriverManager.getConnection(url);
            Statement statement = conn.createStatement();
            String createsql = "INSERT INTO Customer (id, name) VALUES (0, 'Karst');";
            String sql = "SELECT * FROM Customer;";
            statement.execute(createsql);
            ResultSet result = statement.executeQuery(sql);
            int i = 0;
            while (result.next()) {
                i++;
            }
            res = Integer.toString(i);

            result.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            printSQLException(e);
        }
        return res;
    }

    @GetMapping("/hello")
	public String helloWorld(@RequestParam(value = "name", defaultValue = "world") String name) {
		return "Hello " + name;
	}

    @GetMapping("/getCustomer")
    public String getCustomer() throws Exception {
        String name = sendRequest();
        return "Customer: " + name;
    }
}
