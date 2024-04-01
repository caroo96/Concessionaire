package com.mycompany.concessionaire1.DataAccess;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.mycompany.concessionaire1.Views.Vehicle;

public class VehicleDAO {
    
    private SQLServerConnection connection;
    
    public VehicleDAO(SQLServerConnection connection) {
        this.connection = connection;
    }
    
    public void insertVehicle(Vehicle vehicle) {
        String insertQuery = "INSERT INTO Tbl_Vehicle ( plate, brand, model, mileage, category) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = connection.openConnection();
            PreparedStatement statement = conn.prepareStatement(insertQuery)) {            
            statement.setString(1, vehicle.getPlate());
            statement.setString(2, vehicle.getBrand());
            statement.setInt(3, vehicle.getModel());
            statement.setInt(4, vehicle.getMileage());
            statement.setString(5, vehicle.getCategory());
            statement.executeUpdate();
            System.out.println("Vehículo insertado exitosamente.");
        } catch (SQLException e) {
            System.out.println("Error al insertar el vehículo: " + e.getMessage());
        }
    }
}
    
    
    
    

