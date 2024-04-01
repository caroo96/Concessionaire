package com.mycompany.concessionaire1.Views;
import com.mycompany.concessionaire1.Controller.VehicleValidations;
import com.mycompany.concessionaire1.DataAccess.SQLServerConnection;
import com.mycompany.concessionaire1.DataAccess.VehicleDAO;
import java.util.Scanner;

public class Vehicle {
    
    String plate;
    String brand;
    int model;
    int mileage;   
    String category;
    
    Scanner scanner = new Scanner(System.in);
    VehicleValidations vehicleValidations = new VehicleValidations();
    
     public Vehicle(String plate, String brand, int model, int mileage, String category) {
        this.plate = plate;
        this.brand = brand;
        this.model = model;
        this.mileage = mileage;
        this.category = category;        
    }
     
     public void registerVehicle() {
        System.out.println("Por favor ingresa los datos del vehiculo:");
        
        System.out.print("Placa: ");
        plate = scanner.nextLine();
        vehicleValidations.validatePlate(plate);
        
        System.out.print("Marca: ");
        brand = scanner.nextLine();
        
        System.out.print("Modelo: ");
        model = scanner.nextInt();
        scanner.nextLine(); 
        
        System.out.print("Kilometraje: ");
        mileage = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Categoria: ");
        category = scanner.nextLine();
        
        System.out.print("\n \n");
        
        SQLServerConnection objectConnection = new SQLServerConnection();
        objectConnection.openConnection();
        
        VehicleDAO vehicleDAO = new VehicleDAO(objectConnection);
        vehicleDAO.insertVehicle(this);
        
    }     
        
     public String getPlate() {return plate;}
     
     public String getBrand() {return brand;}
     
     public int getModel() {return model;}
     
     public int getMileage() {return mileage;}
     
     public String getCategory() {return category;}  

}
