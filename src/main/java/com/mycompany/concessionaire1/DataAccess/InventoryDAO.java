package com.mycompany.concessionaire1.DataAccess;
import com.mycompany.concessionaire1.Views.Inventory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InventoryDAO {
    
     private SQLServerConnection connection;
    
    public InventoryDAO(SQLServerConnection connection) {
        this.connection = connection;
    }
    
     public void insertInventory(Inventory inventory) {
        String insertQuery = "INSERT INTO Tbl_Inventory (idItem, nameItem, unitCost, quantity) VALUES (?, ?, ?, ?)";
        try (Connection conn = connection.openConnection();
            PreparedStatement statement = conn.prepareStatement(insertQuery)) {
            statement.setInt(1, inventory.getidItem());
            statement.setString(2, inventory.getnameItem());
            statement.setDouble(3, inventory.getunitCost());
            statement.setInt(4, inventory.getquantity());            
            statement.executeUpdate();
            System.out.println("Cliente insertado exitosamente.");
        } catch (SQLException e) {
            System.out.println("Error al insertar el cliente: " + e.getMessage());
        }
    }
     
     public void listInventory() {
         String query = "SELECT idItem, nameItem, unitCost, quantity FROM Tbl_Inventory";
         try (Connection conn = connection.openConnection();
                 Statement statement = conn.createStatement();
                 ResultSet resultSet = statement.executeQuery(query)) {
             
            while (resultSet.next()) {
                 int idItem = resultSet.getInt("idItem");            
                 String nameItem = resultSet.getString("nameItem");
                 double unitCost = resultSet.getDouble("unitCost");
                 int quantity = resultSet.getInt("quantity");
            
                 System.out.println("ID del ítem: " + idItem);
                 System.out.println("Nombre del ítem: " + nameItem);
                 System.out.println("Costo unitario: " + unitCost);
                 System.out.println("Cantidad: " + quantity);
                 System.out.println("---------------------------------------");
            }
          } catch (SQLException e) {
              System.out.println("Error al listar el inventario: " + e.getMessage());
          }
    }
}
