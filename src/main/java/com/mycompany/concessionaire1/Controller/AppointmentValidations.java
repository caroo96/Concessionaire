package com.mycompany.concessionaire1.Controller;
import com.mycompany.concessionaire1.DataAccess.SQLServerConnection;
import com.mycompany.concessionaire1.Views.Client;
import com.mycompany.concessionaire1.Views.Vehicle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AppointmentValidations {
    
    Scanner scanner = new Scanner(System.in);
    private SQLServerConnection connection;

    public AppointmentValidations(SQLServerConnection connection) {
        this.connection = connection;
    }    
     
     public void validateClient(String identification) {
         
        String query = "SELECT COUNT(*) FROM Tbl_Client WHERE Identification = ?";
        
        try (Connection conn = connection.openConnection();
            PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, identification);
            ResultSet resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                if (count == 0) {
                    System.out.println("El cliente con identificación " + identification + " no existe. Por favor regístrelo primero. \n ");
                    Client client = new Client(identification, "", "", "", "");
                    client.registerClient();
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al verificar la existencia del cliente: " + e.getMessage());
        }
    }
     
     public void validatePlate(String plate) {
         
        String query = "SELECT COUNT(*) FROM  Tbl_Vehicle WHERE plate = ?";
        
        try (Connection conn = connection.openConnection();
            PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, plate);
            ResultSet resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                if (count == 0) {
                    System.out.println("El vehiculo con placa: " + plate + " no existe. Por favor regístrelo primero. \n ");
                     Vehicle vehicle = new Vehicle("","",0,0,""); 
                    vehicle.registerVehicle();
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al verificar la existencia del vehiculo: " + e.getMessage());
        }
    }
     
      public int validateDuration(int duration) {
          while (duration > 60) {
              System.out.println("La duración es máximo de 60 minutos\n ");
              System.out.println("Duración de la cita: ");
              duration = scanner.nextInt();          
          }
          return duration;
      }
      
}
      
    



