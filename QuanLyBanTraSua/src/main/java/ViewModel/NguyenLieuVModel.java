/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class NguyenLieuVModel {
    private String id;
    private String ma;
    private String ten;
    private double gia;
    private int trangThai;
    private int soLuong;
    private Date ngaySanXuat;
    private int HanSuDung;
    private String nhaCungCap;
    private String xuatXu;

    public NguyenLieuVModel() {
    }

    public NguyenLieuVModel(String id, String ma, String ten, double gia, int trangThai, int soLuong, Date ngaySanXuat, int HanSuDung, String nhaCungCap, String xuatXu) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.gia = gia;
        this.trangThai = trangThai;
        this.soLuong = soLuong;
        this.ngaySanXuat = ngaySanXuat;
        this.HanSuDung = HanSuDung;
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

    public int getHanSuDung() {
        return HanSuDung;
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

    public void setHanSuDung(int HanSuDung) {
        this.HanSuDung = HanSuDung;
    }

    public void setNhaCungCap(String nhaCungCap) {
        this.nhaCungCap = nhaCungCap;
    }

    public void setXuatXu(String xuatXu) {
        this.xuatXu = xuatXu;
    }
    public String trangThai(int trangThai){
        if(trangThai == 1){
            return "còn hàng";
            
        }else{
            return "h?t hàng";
        }
    }
    public Object[] dataRow() {
        return new Object[]{ma,ten,gia,trangThai(trangThai),soLuong,ngaySanXuat,HanSuDung +" tháng k? t? ngày s?n xu?t",nhaCungCap,xuatXu};
    }
}
