/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Implement;

import DomainModel.Khachhang;
import RepositoryJdbc.Implement.KhachhangRepositoryImplement;
import Service.Interface.KhachhangServiceInterface;
import java.util.List;

/**
 *
 * @author mr.quyen
 */
public class KhachhangServiceImplement implements KhachhangServiceInterface {

    public KhachhangRepositoryImplement khachhangrepositoryimplement;

    public KhachhangServiceImplement() {
        khachhangrepositoryimplement = new KhachhangRepositoryImplement();
    }

    @Override
    public List<Khachhang> getallKH() {
        return khachhangrepositoryimplement.getAllKH();
    }

    @Override
    public void CREATEKhachhang(Khachhang kh) {
        khachhangrepositoryimplement.createKhachang(kh);

    }

    @Override
    public void deleteKhachhang(Khachhang kh) {
khachhangrepositoryimplement.deleteKhachhang(kh);
    }

    @Override
    public void UPdatekhachhang(Khachhang kh) {
khachhangrepositoryimplement.updateKhachhang(kh);
    }

}
