/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Implement;

import DomainModel.NguyenLieu;
import RepositoryJdbc.Implement.NguyenLieuRepositoryImplement;
import Service.Interface.NguyenLieuServiceInterface;
import ViewModel.NguyenLieuVModel;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class NguyenLieuServiceImplement implements NguyenLieuServiceInterface{
    NguyenLieuRepositoryImplement nlRP = new NguyenLieuRepositoryImplement();
    @Override
    public List<NguyenLieuVModel> getAll() {
        List<NguyenLieu> ListMD = this.nlRP.all();
        List<NguyenLieuVModel> ListVMD = new ArrayList<>();
        for (NguyenLieu nguyenLieu : ListMD) {
            NguyenLieuVModel nlVMD = new NguyenLieuVModel();
            nlVMD.setGia(nguyenLieu.getGia());
            nlVMD.setHanSuDung(nguyenLieu.getHSD());
            nlVMD.setMa(nguyenLieu.getMa());
            nlVMD.setNgaySanXuat(nguyenLieu.getNgaySanXuat());
            nlVMD.setNhaCungCap(nguyenLieu.getNhaCungCap());
            nlVMD.setSoLuong(nguyenLieu.getSoLuong());
            nlVMD.setTen(nguyenLieu.getTen());
            nlVMD.setTrangThai(nguyenLieu.getTrangThai());
            nlVMD.setXuatXu(nguyenLieu.getXuatXu());
            ListVMD.add(nlVMD);
        }
        return ListVMD;
//        return nlMD.stream().map((m)
//                -> new NguyenLieuVModel(
//                     m.getMa(),
//                     m.getTen(),
//                     m.getGia(),
//                     m.getSoLuong(),
//                     m.getTrangThai(),
//                     m.getNgaySanXuat(),
//                     m.getHSD(),
//                     m.getNhaCungCap(),
//                     m.getXuatXu()
//                       
//                )).toList();
                        
//        return nlMD.stream().map((n)
//                -> new NguyenLieuVModel()
//                        n.get
//                )).toList();
    }

   

    @Override
    public boolean checkMa(String Ma) {
        
        List<NguyenLieu> list = new ArrayList<>();
        list = (List<NguyenLieu>) nlRP.getone(Ma);
        if(list == null){
            return false;
        }
        return true;
    }

    @Override
    public NguyenLieuVModel getOne(String ma) {
        NguyenLieu nguyenLieu = new NguyenLieu();
        nguyenLieu = nlRP.getone(ma);
        NguyenLieuVModel nlVMD = new NguyenLieuVModel();
        
            nlVMD.setGia(nguyenLieu.getGia());
            nlVMD.setHanSuDung(nguyenLieu.getHSD());
            nlVMD.setMa(nguyenLieu.getMa());
            nlVMD.setNgaySanXuat(nguyenLieu.getNgaySanXuat());
            nlVMD.setNhaCungCap(nguyenLieu.getNhaCungCap());
            nlVMD.setSoLuong(nguyenLieu.getSoLuong());
            nlVMD.setTen(nguyenLieu.getTen());
            nlVMD.setTrangThai(nguyenLieu.getTrangThai());
            nlVMD.setXuatXu(nguyenLieu.getXuatXu());
            
        
        return nlVMD;
    }
    

    @Override
    public String delete(String Ma) {
        boolean check;
        check = nlRP.delete(Ma);
        if(check = true){
            return "thành công";
        }else{
            return "that bai";
        }
    }

    @Override
    public String update(NguyenLieuVModel nl, String Ma) {
        boolean check ;
        NguyenLieu nlVMD = new NguyenLieu();
            nlVMD.setGia(nl.getGia());
            nlVMD.setHSD(nl.getHanSuDung());
            
            nlVMD.setNgaySanXuat(nl.getNgaySanXuat());
            nlVMD.setNhaCungCap(nl.getNhaCungCap());
            nlVMD.setSoLuong(nl.getSoLuong());
            nlVMD.setTen(nl.getTen());
            nlVMD.setTrangThai(nl.getTrangThai());
            nlVMD.setXuatXu(nl.getXuatXu());
        check = nlRP.update(Ma, nlVMD);
        if(check == true){
            return "thành công";
        }else {
            return "that bai";
        }
    }

    @Override
    public String add(NguyenLieu nl) {
        boolean check ;
        check = nlRP.create(nl);
        if(check == true){
            return "Thành công";
        }else{
            return "Th?t b?i";
        }
        
        
//        try {
//            NguyenLieu domain = new NguyenLieu();
//            domain.setGia(nl.getGia());
//            domain.setHSD(nl.getHanSuDung());
//            domain.setMa(nl.getMa());
//            domain.setNgaySanXuat(nl.getNgaySanXuat());
//            domain.setNhaCungCap(nl.getNhaCungCap());
//            domain.setSoLuong(nl.getSoLuong());
//            domain.setTen(nl.getTen());
//            domain.setTrangThai(nl.getTrangThai());
//            domain.setXuatXu(nl.getXuatXu());
//            check = nlRP.create(domain);
//        } catch (Exception e) {
//            e.printStackTrace();
//            
//        } 
//        if(check == true){
//            
//        }
    }
}
