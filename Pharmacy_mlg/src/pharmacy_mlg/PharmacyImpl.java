/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pharmacy_mlg;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DAW TARDE
 */
public class PharmacyImpl {
    List<Medicine> medicines;
    String name;
    String address;

    //1
    public List<Medicine> getMedicines() {
        return medicines;
    }

    public void setMedicines(List<Medicine> medicines) {
        this.medicines = medicines;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    
    //2
    public PharmacyImpl(String name) {
        this.medicines = new ArrayList<>();
        this.name = name;
        this.address= "";
    }
    
    
    
}
