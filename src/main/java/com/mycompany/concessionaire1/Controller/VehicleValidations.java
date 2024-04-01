package com.mycompany.concessionaire1.Controller;
import java.util.Scanner;

public class VehicleValidations {
    
    Scanner scanner = new Scanner(System.in);
    
    public void validatePlate(String plate) {
          while (plate.length() > 6) {
              System.out.println("La placa debe tener máximo 6 dígitos. \n ");
              System.out.println("Ingrese la placa::");
              plate = scanner.nextLine();
          }
      }
    
}
