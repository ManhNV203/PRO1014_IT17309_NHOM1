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
import java.sql.Date;

/**
 *
 * @author ADMIN
 */
public class NguyenLieuRepositoryImplement implements NguyenLieuRepositoryInterface{
    
    @Override
    public List<NguyenLieu> all() {
         List<NguyenLieu> list = new ArrayList<>();
            String sql = "SELECT * from NguyenLieu";
            try {
                Connection c = DBContext.getConnection();
                PreparedStatement ps = c.prepareStatement(sql);
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

//    @Override
//    public boolean create(NguyenLieu nl)  {
//        String sql = "insert into NguyenLieu(Ma,Ten,Gia,SoLuong,TrangThai,NXS,HXD,NhaCungCap,XuatXu) values (?,?,?,?,?,?,?,?,?)";
//        int check =0;
//        
//        try(Connection c = DBContext.getConnection();  PreparedStatement ps = c.prepareStatement(sql);) {
//            
//            ps.setObject(1, nl.getMa());
//            ps.setObject(2, nl.getTen());
//            ps.setObject(3, nl.getGia());
//            ps.setObject(4, nl.getSoLuong());
//            ps.setObject(5, nl.getTrangThai());
//            ps.setDate(6, (Date) nl.getNgaySanXuat());
//            ps.setObject(7, nl.getHSD());
//            ps.setObject(8, nl.getNhaCungCap());
//            ps.setObject(9, nl.getXuatXu());
//            
//            check = ps.executeUpdate();
//            
//           
//            
//        } catch (SQLException e) {
//            e.printStackTrace();
//            
//        }
//        return check >0;
//    
//    }

   

    @Override
    public NguyenLieu getone(String ma) {
            String sql = "select * from NguyenLieu where Ma = ?";
            
            NguyenLieu nl = new NguyenLieu();
            try {
            Connection c = DBContext.getConnection();
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setObject(1, ma);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                
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
                
                
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
            return nl;
    }
//    public static void main(String[] args) {
//        NguyenLieuRepositoryImplement nl = new NguyenLieuRepositoryImplement();
//        List<NguyenLieu> list = new ArrayList<>();
//        list = nl.all();
//        System.out.println(list.toString());
//    }

    @Override
    public boolean create(NguyenLieu nl) {
        String sql = "insert into NguyenLieu(Ma,Ten,Gia,SoLuong,TrangThai,NXS,HXD,NhaCungCap,XuatXu) values (?,?,?,?,?,?,?,?,?)";
        int check =0;
        try {
            Connection c = DBContext.getConnection();
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setObject(1, nl.getMa());
            ps.setObject(2, nl.getTen());
            ps.setObject(3, nl.getGia());
            ps.setObject(4, nl.getSoLuong());
            ps.setObject(5, nl.getTrangThai());
            ps.setObject(6, nl.getNgaySanXuat());
            ps.setObject(7, nl.getHSD());
            ps.setObject(8, nl.getNhaCungCap());
            ps.setObject(9, nl.getXuatXu());
            
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check>0;
    }

    @Override
    public boolean update(String ma, NguyenLieu nl) {
        String sql = "update NguyenLieu set Ten = ?, Gia = ?, SoLuong = ?,TrangThai = ?,NXS = ?, HXD = ?,NhaCungCap = ?, XuatXu = ? where Ma = ? ";
        int check = 0;
        try {
            Connection c = DBContext.getConnection();
            PreparedStatement ps = c.prepareStatement(sql);
           
            ps.setObject(1, nl.getTen());
            ps.setObject(2, nl.getGia());
            ps.setObject(3, nl.getSoLuong());
            ps.setObject(4, nl.getTrangThai());
            ps.setObject(5, nl.getNgaySanXuat());
            ps.setObject(6, nl.getHSD());
            ps.setObject(7, nl.getNhaCungCap());
            ps.setObject(8, nl.getXuatXu());
            ps.setObject(9, ma);
            
            check = ps.executeUpdate();
            
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check >0;
    }

    @Override
    public boolean delete(String ma) {
        String sql = "delete from NguyenLieu where Ma = ?";
        int check = 0;
        try {
            Connection c = DBContext.getConnection();
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setObject(1, ma);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check >0;
    }
}
