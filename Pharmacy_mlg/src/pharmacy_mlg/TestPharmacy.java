
package pharmacy_mlg;

import java.util.Scanner;


public class TestPharmacy {


    public static void main(String[] args) {
        // TODO code application logic here
        Pharmacy p = new PharmacyImpl("Farmacia MiBarrio");
        Scanner sc = new Scanner(System.in);
        
        p.menu(sc);
    }
    
}
