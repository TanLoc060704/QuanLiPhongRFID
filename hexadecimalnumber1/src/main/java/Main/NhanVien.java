/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

/**
 *
 * @author rfid
 */
public class NhanVien {
    String tenNhanVien;
    boolean trangThai;
    String ghiChu;
    String viTri;

    public NhanVien(String tenNhanVien, boolean trangThai, String ghiChu, String viTri) {
        this.tenNhanVien = tenNhanVien;
        this.trangThai = trangThai;
        this.ghiChu = ghiChu;
        this.viTri = viTri;
    }

    // Getters và setters
    public String getTenNhanVien() { return tenNhanVien; }
    public void setTenNhanVien(String tenNhanVien) { this.tenNhanVien = tenNhanVien; }

    public boolean isTrangThai() { return trangThai; }
    public void setTrangThai(boolean trangThai) { this.trangThai = trangThai; }

    public String getGhiChu() { return ghiChu; }
    public void setGhiChu(String ghiChu) { this.ghiChu = ghiChu; }

    public String getViTri() { return viTri; }
    public void setViTri(String viTri) { this.viTri = viTri; }
}

