/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModel;

import java.util.Date;



/**
 *
 * @author ADMIN
 */
public class NguyenLieu {
    private String id;
    private String ma;
    private String ten;
    private double gia;
    private int trangThai;
    private int soLuong;
    private Date ngaySanXuat;
    private int HSD;
    private String nhaCungCap;
    private String xuatXu;

    public NguyenLieu() {
    }

    public NguyenLieu(String id, String ma, String ten, double gia, int trangThai, int soLuong, Date ngaySanXuat, int HSD, String nhaCungCap, String xuatXu) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.gia = gia;
        this.trangThai = trangThai;
        this.soLuong = soLuong;
        this.ngaySanXuat = ngaySanXuat;
        this.HSD = HSD;
        this.nhaCungCap = nhaCungCap;
        this.xuatXu = xuatXu;
    }

    public String getId() {
        return id;
    }

    public String getMa() {
        return ma;
    }

    public String getTen() {
        return ten;
    }

    public double getGia() {
        return gia;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public Date getNgaySanXuat() {
        return ngaySanXuat;
    }

    public int getHSD() {
        return HSD;
    }

    public String getNhaCungCap() {
        return nhaCungCap;
    }

    public String getXuatXu() {
        return xuatXu;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public void setNgaySanXuat(Date ngaySanXuat) {
        this.ngaySanXuat = ngaySanXuat;
    }

    public void setHSD(int HSD) {
        this.HSD = HSD;
    }

    public void setNhaCungCap(String nhaCungCap) {
        this.nhaCungCap = nhaCungCap;
    }

    public void setXuatXu(String xuatXu) {
        this.xuatXu = xuatXu;
    }

    @Override
    public String toString() {
        return "NguyenLieu{" + "id=" + id + ", ma=" + ma + ", ten=" + ten + ", gia=" + gia + ", trangThai=" + trangThai + ", soLuong=" + soLuong + ", ngaySanXuat=" + ngaySanXuat + ", HSD=" + HSD + ", nhaCungCap=" + nhaCungCap + ", xuatXu=" + xuatXu + '}';
    }

   
}
