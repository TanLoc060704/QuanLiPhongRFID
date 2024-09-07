/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

/**
 *
 * @author rfid
 */
public class Order {

    private int lenh;
    private String po;
    private String maSp;
    private String sku;
    private int qty;

    public Order(int lenh, String po, String maSp, String sku, int qty) {
        this.lenh = lenh;
        this.po = po;
        this.maSp = maSp;
        this.sku = sku;
        this.qty = qty;
    }

    // Getters and Setters
    public int getLenh() {
        return lenh;
    }

    public void setLenh(int lenh) {
        this.lenh = lenh;
    }

    public String getPo() {
        return po;
    }

    public void setPo(String po) {
        this.po = po;
    }

    public String getMaSp() {
        return maSp;
    }

    public void setMaSp(String maSp) {
        this.maSp = maSp;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }


}
