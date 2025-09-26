package ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

@SpringBootApplication
public class EcommerceApp {
    
    public static Connection dbConnection;
    
    private static final String DB_URL = "jdbc:h2:mem:testdb";
    private static final String DB_USER = "admin";
    private static final String DB_PASSWORD = "password123";
    
    static {
        try {
            dbConnection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            Statement stmt = dbConnection.createStatement();
            stmt.execute("CREATE TABLE orders (id INT PRIMARY KEY, customer_name VARCHAR(255), product VARCHAR(255), qty INT, price DECIMAL(10,2), comments TEXT)");
        } catch (Exception e) {
        }
    }

    @Bean
    public OrderController orderController() {
        return new OrderController();
    }

    public static void main(String[] args) {
        SpringApplication.run(EcommerceApp.class, args);
    }
}