/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serveurg4;

import dao.IDao;
import entities.Machine;
import entities.Salle;
import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.logging.Level;
import java.util.logging.Logger;
import service.MachineService;
import service.SalleService;

/**
 *
 * @author Lachgar x troti
 */
public class ServeurG4 {


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws RemoteException {
        try {
            IDao<Machine> dao = new  MachineService();
       // dao.create(new Machine("RE855","Toshiba",2000));
            LocateRegistry.createRegistry(1989);
  
            Naming.bind("rmi://localhost:1989/dao", dao);
            
             IDao<Salle> daoSalle =  new SalleService();
            Naming.bind("rmi://localhost:1989/salleService", daoSalle);

            
            System.out.println("En attente d'un client ");
            
        } catch (AlreadyBoundException ex) {
            Logger.getLogger(ServeurG4.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ServeurG4.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}


