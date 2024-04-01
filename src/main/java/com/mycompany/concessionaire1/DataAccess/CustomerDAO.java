package com.mycompany.concessionaire1.DataAccess;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.mycompany.concessionaire1.Views.Client;
import java.sql.ResultSet;

public class CustomerDAO {
    
    private SQLServerConnection connection;
    
    public CustomerDAO(SQLServerConnection connection) {
        this.connection = connection;
    }
    
    public void insertClient(Client client) {
        String insertQuery = "INSERT INTO Tbl_Client (Identification, Name, LastName, Address, PhoneNumber) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = connection.openConnection();
            PreparedStatement statement = conn.prepareStatement(insertQuery)) {
            statement.setString(1, client.getIdentification());
            statement.setString(2, client.getName());
            statement.setString(3, client.getLastName());
            statement.setString(4, client.getAddress());
            statement.setString(5, client.getPhoneNumber());
            statement.executeUpdate();
            System.out.println("Cliente insertado exitosamente.");
        } catch (SQLException e) {
            System.out.println("Error al insertar el cliente: " + e.getMessage());
        }
    }
    
    public void listActiveClients() {
        try {     
            String query = "SELECT * FROM Tbl_Client WHERE State = 1";
            try (Connection conn = connection.openConnection();
                    PreparedStatement statement = conn.prepareStatement(query);
                    ResultSet resultSet = statement.executeQuery()) {                
                while (resultSet.next()) {
                    String identification = resultSet.getString("Identification");
                    String name = resultSet.getString("Name");
                    String lastName = resultSet.getString("LastName");
                    String address = resultSet.getString("Address");
                    String phoneNumber = resultSet.getString("PhoneNumber");
                    
                    System.out.println("Identificación: " + identification);
                    System.out.println("Nombre: " + name + " " + lastName);
                    System.out.println("Dirección: " + address);
                    System.out.println("Teléfono: " + phoneNumber);
                    System.out.println("---------------------------");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al listar los clientes activos: " + e.getMessage());
        }
    }
}