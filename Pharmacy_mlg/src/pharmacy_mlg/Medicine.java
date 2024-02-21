/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pharmacy_mlg;

/**
 *
 * @author DAW TARDE
 */
public interface Medicine {

    Discomfort getDiscomfort();

    String getName();

    double getPrice();

    Integer getStock();

    void setDiscomfort(Discomfort discomfort);

    void setName(String name);

    void setPrice(double price);

    void setStock(Integer stock);
    
}
