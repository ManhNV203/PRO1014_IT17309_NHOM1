/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RepositoryJdbc.Implement;

import DomainModel.NguyenLieu;
import Utility.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import RepositoryJdbc.Interface.NguyenLieuRepositoryInterface;

/**
 *
 * @author ADMIN
 */
public class NguyenLieuRepositoryImplement implements NguyenLieuRepositoryInterface{
    
    @Override
    public List<NguyenLieu> all() {
         List<NguyenLieu> list = new ArrayList<>();
            String sql = "SELECT * from NguyenLieu";
            try (Connection c = DBContext.getConnection();  PreparedStatement ps = c.prepareStatement(sql)){
                ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                NguyenLieu nl = new NguyenLieu();
                nl.setId(rs.getString(1));
                nl.setMa(rs.getString(2));
                nl.setTen(rs.getString(3));
                nl.setGia(rs.getDouble(4));
                nl.setSoLuong(rs.getInt(5));
                nl.setTrangThai(rs.getInt(6));
                nl.setNgaySanXuat(rs.getDate(7));
                nl.setHSD(rs.getInt(8));
                nl.setNhaCungCap(rs.getString(9));
                nl.setXuatXu(rs.getString(10));
                System.out.println(nl);
                list.add(nl);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
            return list;
    }

    @Override
    public void create(NguyenLieu nl) throws Exception {
        String sql = "insert into NguyenLieu(Ma,Ten,Gia,SoLuong,TrangThai,NXS,HXD,NhaCungCap,XuatXu) values (?,?,?,?,?,?,?,?,?)";
        
        try ( Connection c = DBContext.getConnection();  PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setObject(1, nl.getMa());
            ps.setObject(2, nl.getTen());
            ps.setObject(3, nl.getGia());
            ps.setObject(4, nl.getSoLuong());
            ps.setObject(5, nl.getTrangThai());
            ps.setObject(6, nl.getNgaySanXuat());
            ps.setObject(7, nl.getHSD());
            ps.setObject(8, nl.getNhaCungCap());
            ps.setObject(9, nl.getXuatXu());
            
            
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        
    
    }

    @Override
    public void update(String ma, NguyenLieu nl) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(String ma) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public NguyenLieu getone(String ma) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
//    public static void main(String[] args) {
//        NguyenLieuRepositoryImplement nl = new NguyenLieuRepositoryImplement();
//        List<NguyenLieu> list = new ArrayList<>();
//        list = nl.all();
//        System.out.println(list.toString());
//    }
}
