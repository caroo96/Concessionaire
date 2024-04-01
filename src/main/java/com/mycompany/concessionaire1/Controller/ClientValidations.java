package com.mycompany.concessionaire1.Controller;
import java.util.Scanner;

public class ClientValidations {
    
    Scanner scanner = new Scanner(System.in);    
    
      public String validateIdentification(String identification) {
          while (identification.length() > 11) {
              System.out.println("La identificación debe tener máximo 11 dígitos. \n ");
              System.out.println("Ingrese la identificación::");
              identification = scanner.nextLine();
          }
          return identification;
      }
      
      public void validateAdress(String address) {         
          while(address.length() > 30){
            System.out.println("La dirección debe tener máximo 30 dígitos. \n");
            System.out.println("Ingrese la dirección:");
            address = scanner.nextLine();
        }
      } 
      
      public void validatePhoneNumber(String phoneNumber) {         
         while (phoneNumber.length() > 11){
            System.out.println("El número debe tener máximo 11 dígitos. \n");
            System.out.println("Ingrese el número de teléfono:");
            phoneNumber = scanner.nextLine();
        }
      } 
    
    
}
