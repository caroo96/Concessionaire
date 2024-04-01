package com.mycompany.concessionaire1.Views;
import com.mycompany.concessionaire1.Controller.ClientValidations;
import com.mycompany.concessionaire1.DataAccess.CustomerDAO;
import com.mycompany.concessionaire1.DataAccess.SQLServerConnection;

import java.util.Scanner;

public class Client {
    String identification;
    String name;
    String lastName;
    String address;
    String phoneNumber;

    Scanner scanner = new Scanner(System.in);
    ClientValidations clientValidations = new ClientValidations(); 

    public Client(String identification, String name, String lastName, String address, String phoneNumber) {
        this.identification = identification;
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public Client registerClient() {
        System.out.println("Por favor ingresa los datos del cliente:");
        
        System.out.println("Identificación: ");
        identification = scanner.nextLine();        
        identification = clientValidations.validateIdentification(identification);

        System.out.println("Nombre: ");
        name = scanner.nextLine();

        System.out.println("Apellido: ");
        lastName = scanner.nextLine();

        System.out.println("Dirección: ");
        address = scanner.nextLine();
        clientValidations.validateAdress(address);

        System.out.println("Teléfono: ");
        phoneNumber = scanner.nextLine();
        clientValidations.validatePhoneNumber(phoneNumber);
        
        System.out.print("\n \n"); 
        
        SQLServerConnection objectConnection = new SQLServerConnection();
        objectConnection.openConnection();
        CustomerDAO customerDAO = new CustomerDAO(objectConnection);
        customerDAO.insertClient(new Client(identification, name, lastName, address, phoneNumber)); 

        return new Client(identification, name, lastName, address, phoneNumber);           
           
    }
    
    public String getIdentification() {return identification;}
    
    public String getName() {return name;}
    
    public String getLastName() {return lastName;}
    
    public String getAddress() {return address;}
    
    public String getPhoneNumber() {return phoneNumber;}
}

