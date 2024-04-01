package com.mycompany.concessionaire1.DataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RepairOrMaintenanceDAO {
    
    private SQLServerConnection connection;
    
    public RepairOrMaintenanceDAO(SQLServerConnection connection) {
        this.connection = connection;
    }
    
    public String[] searchVehicle(String plate) {
        String[] result = new String[2]; 
        
        String query = "SELECT VehiclePlate, Type FROM Tbl_Appointments WHERE VehiclePlate = ?";
        
        try (Connection conn = connection.openConnection();
            PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, plate);
            ResultSet resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
                result[0] = resultSet.getString("VehiclePlate"); 
                result[1] = resultSet.getString("Type"); 
            } else {
                System.out.println("No se encontraron registros para la placa proporcionada.");
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar el vehículo: " + e.getMessage());
        }        
        return result;
    }
    
    public void updateAppointmentState(String vehiclePlate, String estado) {
        String query = "UPDATE Tbl_Appointments SET Estado = ? WHERE VehiclePlate = ?";
        try (Connection conn = connection.openConnection();
                
            PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, estado);
            statement.setString(2, vehiclePlate);
            int rowsAffected = statement.executeUpdate();
            
            if (rowsAffected > 0) {
                System.out.println("Estado actualizado exitosamente.");
            } else {
                System.out.println("No se pudo actualizar el estado.");
            }
        } catch (SQLException e) {
            System.out.println("Error al actualizar el estado del vehículo: " + e.getMessage());
        }
    }
}


