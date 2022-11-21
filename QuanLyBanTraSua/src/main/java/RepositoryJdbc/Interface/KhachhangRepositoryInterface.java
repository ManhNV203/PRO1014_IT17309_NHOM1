/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package RepositoryJdbc.Interface;

import DomainModel.Khachhang;
import java.util.List;

/**
 *
 * @author mr.quyen
 */
public interface KhachhangRepositoryInterface {
     public List<Khachhang> getAllKH();
     
     public void createKhachang(Khachhang nl);
    public void updateKhachhang(Khachhang nl) ;
    public void deleteKhachhang(Khachhang kh) ;
    
}
