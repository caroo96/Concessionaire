package com.mycompany.concessionaire1;
import com.mycompany.concessionaire1.DataAccess.CustomerDAO;
import com.mycompany.concessionaire1.DataAccess.InventoryDAO;
import com.mycompany.concessionaire1.DataAccess.VehicleDAO;
import com.mycompany.concessionaire1.DataAccess.SQLServerConnection;
import com.mycompany.concessionaire1.Views.Appointment;
import com.mycompany.concessionaire1.Views.Client;
import com.mycompany.concessionaire1.Views.Inventory;
import com.mycompany.concessionaire1.Views.RepairOrMaintenance;
import com.mycompany.concessionaire1.Views.Vehicle;
import java.util.Date;
import javax.swing.JOptionPane;


public class Concessionaire1 {

    public static void main(String[] args) {
        
        SQLServerConnection objectConecction = new SQLServerConnection();
        objectConecction.openConnection();
        
        int option = Integer.parseInt(JOptionPane.showInputDialog("Bienvenido a Mundo Auto \n Escoge la opción que deseas realizar \n\n 1. Agendar cita. \n 2. registrar Cliente. \n 3. registrar Vehiculo. \n 4. Proceso de reparación o mantenimiento. "
                +"\n 5. Registrar Inventario. \n 6. Listar Inventario.  \n 7. Listar clientes activos. \n 8. Listar clientes en reparación o mantenimiento.")); 
        
          if (option < 1 || option > 7) {          
            JOptionPane.showInputDialog("Deber ingresar un número de 1 a 7  ");            
            
        }else{
            
            switch(option) {
            case 1:
                Date datetime = new Date();
                Appointment appointment = new Appointment(datetime, "", "", "",0);
                appointment.registerAppointment();         
                break;
                
            case 2:
                Client client = new Client("", "", "", "", "");
                client.registerClient();             
                break;
                
            case 3:
                Vehicle vehicle = new Vehicle("","",0,0,"");
                vehicle.registerVehicle(); 
                
                VehicleDAO vehicleDAO = new VehicleDAO(objectConecction);
                vehicleDAO.insertVehicle(vehicle);
                break;
                
            case 4:
                RepairOrMaintenance repairOrMaintenance = new RepairOrMaintenance("");
                repairOrMaintenance.searchVehicle();                               
                break;
                
            case 5:
                Inventory inventory = new Inventory(0,"",0,0);
                inventory.registerInventory();
                break;
                
             case 6:
                InventoryDAO inventoryDAO = new InventoryDAO(objectConecction);
                inventoryDAO.listInventory();
                break;    
             
             case 7:
                CustomerDAO customerDAO = new CustomerDAO(objectConecction);
                customerDAO.listActiveClients();
                break; 
                
             case 8:
                
                break; 
                
            default:
                JOptionPane.showMessageDialog(null, "Número Incorrecto, ingrese un número valido");
           }
        }
        
        
    }
}
