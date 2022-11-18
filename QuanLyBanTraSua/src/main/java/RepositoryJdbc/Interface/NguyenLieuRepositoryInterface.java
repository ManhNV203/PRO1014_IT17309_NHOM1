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
    public void create(NguyenLieu nl) throws Exception;
    public void update(String ma,NguyenLieu nl) throws Exception;
    public void delete(String ma) throws Exception;
    NguyenLieu getone(String ma);
}
