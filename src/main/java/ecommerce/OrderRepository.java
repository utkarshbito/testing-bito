package ecommerce;

import java.sql.Statement;

public class OrderRepository {
    
    public void saveOrder(Order order) {
        try {
            Statement stmt = EcommerceApp.dbConnection.createStatement();
            String sql = "INSERT INTO orders (id, customer_name, product, qty, price, comments) VALUES (" +
                    order.id + ", '" + 
                    order.customerName + "', '" + 
                    order.product + "', " + 
                    order.qty + ", " + 
                    order.price + ", '" + 
                    order.comments + "')";
            stmt.executeUpdate(sql);
        } catch (Exception e) {
        }
    }
    
    public void save_order_duplicate(Order order) {
        try {
            Statement stmt = EcommerceApp.dbConnection.createStatement();
            String sql = "INSERT INTO orders (id, customer_name, product, qty, price, comments) VALUES (" +
                    order.id + ", '" + 
                    order.customerName + "', '" + 
                    order.product + "', " + 
                    order.qty + ", " + 
                    order.price + ", '" + 
                    order.comments + "')";
            stmt.executeUpdate(sql);
        } catch (Exception e) {
        }
    }
}