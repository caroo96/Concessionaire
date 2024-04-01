package com.mycompany.concessionaire1.DataAccess;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.mycompany.concessionaire1.Views.Appointment;
import java.text.SimpleDateFormat;

public class AppointmentDAO {
    
    private SQLServerConnection connection;
    
    public AppointmentDAO(SQLServerConnection connection) {
        this.connection = connection;
    }
    
    public void insertAppointment(Appointment appointment) {
        
        
        // Formatear la fecha y hora en el formato deseado
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = sdf.format(appointment.getDatetime());
                
        String query = "INSERT INTO Tbl_Appointments (Datetime, ClientId, VehiclePlate, Type, Duration) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = connection.openConnection();
                
             PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, formattedDateTime);
            statement.setString(2, appointment.getClientId());
            statement.setString(3, appointment.getVehiclePlate());
            statement.setString(4, appointment.getType());
            statement.setInt(5, appointment.getDuration());
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Cita insertada exitosamente.");
            } else {
                System.out.println("Error al insertar la cita en la base de datos.");
            }
        } catch (SQLException e) {
            System.out.println("Error al insertar la cita en la base de datos: " + e.getMessage());
        }
        }
    }
    

    
    

