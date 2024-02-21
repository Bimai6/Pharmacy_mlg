/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pharmacy_mlg;

import java.util.Objects;


/**
 *
 * @author DAW TARDE
 */
public class MedicineImpl implements Medicine, Comparable<Medicine>{
    String name;
    Integer stock;
    double price;
    Discomfort discomfort;

    public MedicineImpl(String name, Integer stock, double price, Discomfort discomfort) {
        this.name = name;
        this.stock = stock;
        this.price = price;
        this.discomfort = discomfort;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Integer getStock() {
        return stock;
    }

    @Override
    public void setStock(Integer stock) {
        this.stock = stock;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public Discomfort getDiscomfort() {
        return discomfort;
    }

    @Override
    public void setDiscomfort(Discomfort discomfort) {
        this.discomfort = discomfort;
    }

    @Override
    public String toString() {
        return "Medicine{" + "name=" + name + ", stock=" + stock + ", price=" + price + ", discomfort=" + discomfort + '}';
    }
    
    
    public boolean equals(Object o){
        boolean r = false;
        if(o instanceof Medicine){
            Medicine m = (Medicine) o;
            r= m.getName().equals(this.getName());
        }
        return r;
    }

    @Override
    public int compareTo(Medicine m) {
       int n;
       n= this.getName().compareTo(m.getName());
       if(n ==0 ){
           n= Double.compare(this.getPrice(), m.getPrice());
       }
       return n;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.name);
        return hash;
    }
    
    
    
}
