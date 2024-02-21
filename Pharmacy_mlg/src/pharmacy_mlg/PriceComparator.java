/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pharmacy_mlg;

import java.util.Comparator;

/**
 *
 * @author DAW TARDE
 */
public class PriceComparator implements Comparator<Medicine> {
    public int compare(Medicine m1, Medicine m2){
        return Double.compare(m1.getPrice(), m2.getPrice());
    }
}
