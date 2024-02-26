/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pharmacy_mlg;

import Exceptions.PharmacyException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public interface Pharmacy {

    //4
    void addMedicine(Medicine medicine);

    String getAddress();

    //1
    List<Medicine> getMedicines();

    //7
    List<Medicine> getMedicinesByDiscomfort(Discomfort d);

    //8
    List<Medicine> getMedicinesByDiscomfortOrderByPrice(Discomfort d);

    //9
    Medicine getMostStockMedicine();

    String getName();

    //6
    int getStockByName(String name) throws PharmacyException;

    //10
    int getSumStockByDiscomfort(Discomfort d);

    void setAddress(String address);

    void setMedicines(List<Medicine> medicines);

    void setName(String name);

    //5
    void subtrackStock(String medicineName, int num) throws PharmacyException;
    
    void menu(Scanner sc);
}
