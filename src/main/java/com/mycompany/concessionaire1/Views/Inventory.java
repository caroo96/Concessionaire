package com.mycompany.concessionaire1.Views;
import com.mycompany.concessionaire1.DataAccess.InventoryDAO;
import com.mycompany.concessionaire1.DataAccess.SQLServerConnection;
import java.util.Scanner;

public class Inventory {
    
    int idItem;
    String nameItem;
    Double unitCost;
    int quantity;
    
    Scanner scanner = new Scanner(System.in);
    SQLServerConnection objectConecction = new SQLServerConnection();
    
    
      public Inventory(int idItem, String nameItem, double unitCost, int quantity) {
        this.idItem = idItem;
        this.nameItem = nameItem;
        this.unitCost = unitCost;
        this.quantity = quantity;
    }
      
        public Inventory registerInventory() {
            System.out.println("Por favor ingresa los datos del inventario:");
        
            System.out.println("Id Item: ");              
            idItem = scanner.nextInt();
            scanner.nextLine();
        
            System.out.println("Nombre Item: ");
            nameItem = scanner.nextLine();

            System.out.println("Costo unitario: ");
            unitCost = scanner.nextDouble();
            scanner.nextLine();
         
            System.out.println("Cantidad: ");
            quantity = scanner.nextInt();
            scanner.nextLine();
            
            InventoryDAO inventoryDAO = new InventoryDAO(objectConecction);
            inventoryDAO.insertInventory(this);
        
            return new Inventory(idItem,nameItem,unitCost,quantity);        
        }
               
    
    public int getidItem() {return idItem;}
    
    public String getnameItem() {return nameItem;}
    
    public Double getunitCost() {return unitCost;}
    
    public int getquantity() {return quantity;}
}

        

