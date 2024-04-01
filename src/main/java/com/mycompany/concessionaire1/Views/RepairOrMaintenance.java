package com.mycompany.concessionaire1.Views;
import com.mycompany.concessionaire1.DataAccess.RepairOrMaintenanceDAO;
import com.mycompany.concessionaire1.DataAccess.SQLServerConnection;
import java.util.Scanner;

public class RepairOrMaintenance {
    
     Scanner scanner = new Scanner(System.in);
     SQLServerConnection objectConnection = new SQLServerConnection();     
     RepairOrMaintenanceDAO repairOrMaintenanceDAO = new RepairOrMaintenanceDAO(objectConnection);
    
    String plate;
        
    public RepairOrMaintenance(String plate){
        this.plate = plate;
    }
    
     public void searchVehicle() {
         System.out.println("Placa del vehiculo: ");
         plate = scanner.nextLine(); 
         String[] vehicleInfo = repairOrMaintenanceDAO.searchVehicle(plate);
         if (vehicleInfo != null) {
             System.out.println("Placa: " + vehicleInfo[0]);
             System.out.println("Tipo: " + vehicleInfo[1]);
             updateAppointmentState(vehicleInfo[0]);
         } else {
             System.out.println("El vehículo no existe en la base de datos.");
         }
     }
     
     private void updateAppointmentState(String vehiclePlate) {
         System.out.println("Ingrese el estado del vehículo: ");
         String estado = scanner.nextLine();
         repairOrMaintenanceDAO.updateAppointmentState(vehiclePlate, estado);
     }
}
