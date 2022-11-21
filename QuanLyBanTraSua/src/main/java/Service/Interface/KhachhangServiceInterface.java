/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service.Interface;

import DomainModel.Khachhang;
import java.util.List;

/**
 *
 * @author mr.quyen
 */
public interface KhachhangServiceInterface {
    public List<Khachhang> getallKH();

    
    public void CREATEKhachhang(Khachhang kh);
    
    public void deleteKhachhang(Khachhang kh);
    
    public  void UPdatekhachhang(Khachhang kh);
    
}
