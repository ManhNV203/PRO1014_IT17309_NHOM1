/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service.Interface;


import DomainModel.NguyenLieu;
import ViewModel.NguyenLieuVModel;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface NguyenLieuServiceInterface {
    List<NguyenLieuVModel> getAll();
    String delete(String Ma);
    String update(NguyenLieuVModel nl, String Ma);
    String add(NguyenLieu nl) ;
    boolean checkMa(String Ma);
    NguyenLieuVModel getOne(String ma);
}
