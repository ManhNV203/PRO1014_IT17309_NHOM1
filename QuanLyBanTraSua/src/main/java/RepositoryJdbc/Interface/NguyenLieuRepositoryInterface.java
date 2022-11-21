/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package RepositoryJdbc.Interface;

import DomainModel.NguyenLieu;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface NguyenLieuRepositoryInterface {
    public List<NguyenLieu> all();
    boolean create(NguyenLieu nl) ;
    boolean update(String ma,NguyenLieu nl) ;
    boolean delete(String ma) ;
    NguyenLieu getone(String ma);
}
