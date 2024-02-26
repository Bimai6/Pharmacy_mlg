/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pharmacy_mlg;

import Exceptions.PharmacyException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author DAW TARDE
 */
public class PharmacyImpl implements Pharmacy {

    List<Medicine> medicines;
    String name;
    String address;

    //1
    @Override
    public List<Medicine> getMedicines() {
        return this.medicines;
    }

    @Override
    public void setMedicines(List<Medicine> medicines) {
        this.medicines = medicines;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getAddress() {
        return this.address;
    }

    @Override
    public void setAddress(String address) {
        try {
            checkAddress(address);
            this.address = address;
        } catch (PharmacyException e) {
            System.out.println(e);
        }
    }

    //2
    public PharmacyImpl(String name) {
        this.medicines = new ArrayList<>();
        this.name = name;
        this.address = "";
    }

    //3
    @Override
    public String toString() {
        return "Pharmacy{" + "medicines=" + medicines + ", name=" + name + ", address=" + address + '}';
    }

    //4
    @Override
    public void addMedicine(Medicine medicine) {
        boolean medicineExists = false;
        for (Medicine m : this.medicines) {
            if (m.equals(medicine)) {
                medicineExists = true;
                m.setStock(m.getStock() + medicine.getStock());
                System.out.println("El medicamento: " + m.getName() + " tiene de stock: " + m.getStock() + "y su posición es: " + this.medicines.indexOf(m));
                break;

            }

        }

        if (!medicineExists) {
            this.medicines.add(medicine);
            System.out.println("El medicamento: " + medicine.getName() + " tiene de stock: " + medicine.getStock() + "y su posición es: " + this.medicines.indexOf(medicine));
        }
    }

    //5
    @Override
    public void subtrackStock(String medicineName, int num) throws PharmacyException {
        boolean nameHasntBeenFound = false;
        for (Medicine m : this.medicines) {
            if (m.getName().equals(medicineName)) {
                nameHasntBeenFound = true;
                int subtrack = m.getStock() - num;
                if (subtrack < 0) {
                    throw new PharmacyException("Stock is below 0");
                }
                m.setStock(subtrack);
                System.out.println("El medicamento: " + m.getName() + " tiene de stock: " + m.getStock() + "y su posición es: " + this.medicines.indexOf(m));
                break;
            }

        }

        if (!nameHasntBeenFound) {
            throw new PharmacyException("Name hasn't been found");
        }
    }

    //6
    @Override
    public int getStockByName(String name) throws PharmacyException {
        int value = 0;
        boolean medicineExist = false;
        for (Medicine m : this.medicines) {
            if (m.getName().equals(name)) {
                medicineExist = true;
                value = m.getStock();
                break;
            }
        }
        if (!medicineExist) {
            throw new PharmacyException("That medicine is not in the Pharmacy.");
        }
        return value;
    }

    //7
    @Override
    public List<Medicine> getMedicinesByDiscomfort(Discomfort d) {
        List<Medicine> lista = new ArrayList<>();
        for (Medicine m : this.medicines) {
            if (m.getDiscomfort().equals(d)) {
                lista.add(m);
            }
        }
        //Collections.sort(lista); no sé porque no me funciona

        return lista;
    }

    //8
    @Override
    public List<Medicine> getMedicinesByDiscomfortOrderByPrice(Discomfort d) {
        List<Medicine> lista = new ArrayList<>();
        for (Medicine m : this.medicines) {
            if (m.getDiscomfort().equals(d)) {
                lista.add(m);
            }
        }
        Collections.sort(lista, new PriceComparator());
        return lista;
    }

    //9
    @Override
    public Medicine getMostStockMedicine() {
        Medicine medicine = null;
        medicine.setStock(0);
        medicine.setPrice(Double.MAX_VALUE);

        for (Medicine m : medicines) {
            int r;
            r = m.getStock().compareTo(medicine.getStock());
            if (r == 1) {
                medicine = m;
            }
            if (r == 0) {
                r = Double.compare(m.getPrice(), medicine.getPrice());
                if (r == -1) {
                    medicine = m;
                }
            }
        }
        return medicine;
    }

    //10
    @Override
    public int getSumStockByDiscomfort(Discomfort d) {
        int sum = 0;
        List<Medicine> medicineList = this.getMedicinesByDiscomfort(d);
        for (Medicine m : medicineList) {
            sum += m.getStock();
        }
        return sum;
    }

    //11
    public void menu(Scanner sc) {
        int option;
        do {
            System.out.println("""
                               1. Añadir stock del medicamento
                               2. Quitar stock del medicamento
                               3. Mostrar posición y stock de un medicamento.
                               4. Mostrar la farmacia
                               5. Cerrar el menú indicando previamente con un mensaje..
                               """);
            option = Integer.parseInt(sc.nextLine());
            switch (option) {
                case 1:
                    addStock(this, sc);
                    break;
                case 2:
                    try {
                    menuSubtractStock(this, sc);
                } catch (PharmacyException e) {
                    System.out.println(e);
                }
                break;
                case 3:
                    watchMedicines(this, sc);
                    break;
                case 4:
                    System.out.println(this);
                    break;
                case 5:
                    System.out.println("Sesión finalizada");
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (option != 5);
    }

    //12
    public static void addStock(Pharmacy p, Scanner sc) {
        System.out.println("Introduce el nombre del medicamento: ");
        String name = "";
        try{
        name = sc.nextLine();
        checkName(name);
        }catch(PharmacyException e){
            System.out.println(e);
        }
        System.out.println("Introduce la cantidad de stock a añadir: ");
        int quantity = 0;
        try{
        quantity = Integer.parseInt(sc.nextLine());
        checkStock(quantity);
        Medicine m = new MedicineImpl(name, quantity, 0, null);
        p.addMedicine(m);
        }catch(PharmacyException e){
            System.out.println(e);
        }
        
    }

    //13
    public static void menuSubtractStock(Pharmacy p, Scanner sc) throws PharmacyException {
        System.out.println("Introduce el nombre del medicamento: ");
        String name = "";
        try{
        name = sc.nextLine();
        checkName(name);
        }catch(PharmacyException e){
            System.out.println(e);
        }
        System.out.println("Introduce la cantidad de stock a restar: ");
        int quantity = 0;
        try{
        quantity = Integer.parseInt(sc.nextLine());
        checkStock(quantity);
        p.subtrackStock(name, quantity);
          }catch(PharmacyException e){
            System.out.println(e);
        }
    }

    //14
    public static void watchMedicines(Pharmacy p, Scanner sc){
        System.out.println("Los medicamentos disponibles son: ");
        for(Medicine m : p.getMedicines()){
            if(m != null){
                System.out.println(m.getName());
            }
        }
        System.out.println("Introduce el nombre del medicamento: ");
        String name = sc.nextLine();
        
        
        for(Medicine m : p.getMedicines()){
            if(m.getName().equals(name)){
                 System.out.println("El medicamento: " + m.getName() + " tiene de stock: " + m.getStock() + "y su posición es: " + p.getMedicines().indexOf(m));
                break;
            }
        }
    }
    
    
    public static void checkAddress(String address) throws PharmacyException {
        if (!address.matches("[a-zA-Z]+,//s//d+//s-//d{5}.//s[a-zA-Z].")) {
            throw new PharmacyException("Address format isn't valid.");
        }
    }
    
    public static void checkName(String name) throws PharmacyException {
        if(!name.matches("[a-zA-Z]+")){
            throw new PharmacyException("Name format isn't valid.");
        }
    }
    
    public static void checkStock(int stock) throws PharmacyException {
        String s = Integer.toString(stock);
        //Vamos a poner, como delimitador, que el stock máximo sea de 99.
        if(!s.matches("[0-9]?[0-9]")){
            throw new PharmacyException("Stock format isn't valid.");
        }
    }
}
