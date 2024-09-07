/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hexadecimalnumber1;

/**
 *
 * @author rfid
 */
public class TaiLieu {
    private Integer id;
    private String maqrcodel;
    private String EPC;
    private String TID;
    private String Chuoisaumaqr;
    private String EPCconvert;

    public TaiLieu() {
    }

    public TaiLieu(Integer id, String maqrcodel, String EPC, String TID, String Chuoisaumaqr, String EPCconvert) {
        this.id = id;
        this.maqrcodel = maqrcodel;
        this.EPC = EPC;
        this.TID = TID;
        this.Chuoisaumaqr = Chuoisaumaqr;
        this.EPCconvert = EPCconvert;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMaqrcodel() {
        return maqrcodel;
    }

    public void setMaqrcodel(String maqrcodel) {
        this.maqrcodel = maqrcodel;
    }

    public String getEPC() {
        return EPC;
    }

    public void setEPC(String EPC) {
        this.EPC = EPC;
    }

    public String getTID() {
        return TID;
    }

    public void setTID(String TID) {
        this.TID = TID;
    }

    public String getChuoisaumaqr() {
        return Chuoisaumaqr;
    }

    public void setChuoisaumaqr(String Chuoisaumaqr) {
        this.Chuoisaumaqr = Chuoisaumaqr;
    }

    public String getEPCconvert() {
        return EPCconvert;
    }

    public void setEPCconvert(String EPCconvert) {
        this.EPCconvert = EPCconvert;
    }
    
    @Override
    public String toString() {
        return "TaiLieu{" +
                "id=" + id +
                ", maqrcodel='" + maqrcodel + '\'' +
                ", EPC='" + EPC + '\'' +
                ", TID='" + TID + '\'' +
                ", Chuoisaumaqr='" + Chuoisaumaqr + '\'' +
                ", EPCconvert='" + EPCconvert + '\'' +
                '}';
    }
}
