package com.mycompany.concessionaire1.Views;
import com.mycompany.concessionaire1.Controller.AppointmentValidations;
import com.mycompany.concessionaire1.DataAccess.AppointmentDAO;
import com.mycompany.concessionaire1.DataAccess.SQLServerConnection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;

public class Appointment {
    
   Date datetime;
   String clientId;
   String vehiclePlate;
   String type;
   int duration;
   
   Scanner scanner = new Scanner(System.in);
   
   public Appointment(Date datetime, String clientId, String vehiclePlate, String type, int duration) {
        this.datetime = datetime;
        this.clientId = clientId;
        this.vehiclePlate = vehiclePlate;
        this.type = type;
        this.duration = duration;
    }
   
    SQLServerConnection objectConecction = new SQLServerConnection();
    AppointmentValidations appointmentValidations = new AppointmentValidations(objectConecction);
   
   public Appointment registerAppointment() {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            System.out.println("Fecha de la cita (formato yyyy-MM-dd HH:mm:ss): ");
            String datetimeStr = scanner.nextLine();
            datetime = dateFormat.parse(datetimeStr);
                                   
            System.out.println("Identificación del cliente: ");
            clientId = scanner.nextLine();          
            
            appointmentValidations.validateClient(clientId);

            System.out.println("Placa del vehículo: ");
            vehiclePlate = scanner.nextLine();
            appointmentValidations.validatePlate(vehiclePlate);

            System.out.println("Tipo de cita (reparación o mantenimiento): ");
            type = scanner.nextLine();
            
            System.out.println("Duración de la cita: ");
            duration = scanner.nextInt();
            duration = appointmentValidations.validateDuration(duration);
            
            
            AppointmentDAO appointmentDAO = new AppointmentDAO(objectConecction);
            appointmentDAO.insertAppointment(new Appointment (datetime, clientId, vehiclePlate, type, duration));
                                   
            return new Appointment(datetime, clientId, vehiclePlate, type, duration);
            
        } catch (ParseException e) {
            System.out.println("Error al leer la fecha. Formato incorrecto.");
            return null;
        }       
    }
   
   public Date getDatetime() {return datetime;}
   public String getClientId() {return clientId;}
   public String getVehiclePlate() {return vehiclePlate;}
   public String getType() {return type;}
   public int getDuration() {return duration;}

    
}
