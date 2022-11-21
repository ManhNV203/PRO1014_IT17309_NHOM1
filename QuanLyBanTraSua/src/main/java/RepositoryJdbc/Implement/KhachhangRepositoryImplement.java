package RepositoryJdbc.Implement;

import java.util.List;
import DomainModel.Khachhang;
import RepositoryJdbc.Interface.KhachhangRepositoryInterface;
import Utility.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class KhachhangRepositoryImplement implements KhachhangRepositoryInterface {

    private Connection con;

    public KhachhangRepositoryImplement() {
        con = DBContext.getConnection();
    }

    @Override
    public List<Khachhang> getAllKH() {
        List<Khachhang> listkh = new ArrayList<>();
        String sql = " SELECT [Id]\n"
                + "      ,[Ma]\n"
                + "      ,[HoTen]\n"
                + "      ,[GioiTinh]\n"
                + "      ,[DiaChi]\n"
                + "      ,[SDT]\n"
                + "      ,[MoTa]\n"
                + "  FROM [dbo].[Khachhang]\n"
                + "\n"
                + "GO";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Khachhang kh = new Khachhang();
                listkh.add(new Khachhang(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)));
         
//            Khachhang kh  = new Khachhang(sql, sql, sql, sql, sql, sql, sql)
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhachhangRepositoryImplement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listkh;
    }

    @Override
    public void createKhachang(Khachhang kh) {

        List<Khachhang> list = new ArrayList<>();
        String query = " 	INSERT INTO [dbo].[Khachhang]\n"
                + "           (\n"
                + "           [Ma]\n"
                + "           ,[HoTen]\n"
                + "           ,[GioiTinh]\n"
                + "           ,[DiaChi]\n"
                + "           ,[SDT]\n"
                + "           ,[MoTa])\n"
                + "     VALUES "
                + "(?,?,?,?,?,?)";

        PreparedStatement ptm;
        try {
            ptm = con.prepareStatement(query);
            ptm.setString(1, kh.getMa());
            ptm.setString(2, kh.getHoTen());
            ptm.setString(3, kh.getGioiTinh());
            ptm.setString(4, kh.getDiaChi());
            ptm.setString(5, kh.getSDT());
            ptm.setString(6, kh.getMoTa());
            ptm.executeUpdate();

        } catch (SQLException e) {
            Logger.getLogger(KhachhangRepositoryImplement.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    @Override
    public void updateKhachhang(Khachhang kh) {
        String query = "UPDATE [dbo].[Khachhang]\n"
                + "   SET\n"
                   
                + "      [HoTen] = ?\n"
                + "      ,[GioiTinh] =?\n"
                + "      ,[DiaChi] = ?\n"
                + "      ,[SDT] =?\n"
                + "      ,[MoTa] = ?\n"
                + " WHERE Ma = ?";
        try {
            PreparedStatement ptm =  con.prepareStatement(query);
            
            ptm.setString(1, kh.getHoTen());
            ptm.setString(2, kh.getGioiTinh());
            ptm.setString(3, kh.getDiaChi());
            ptm.setString(4, kh.getSDT());
            ptm.setString(5, kh.getMoTa());
            ptm.setString(6, kh.getMa());
            ptm.executeUpdate();
        }  catch (SQLException e) {
            Logger.getLogger(KhachhangRepositoryImplement.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void deleteKhachhang(Khachhang kh) {
        String query = " DELETE FROM [dbo].[Khachhang] WHERE Ma=(?)";

        PreparedStatement ptm;
        try {
            ptm = con.prepareStatement(query);
            ptm.setString(1, kh.getMa());
            ptm.executeUpdate();
            ptm.close();
        } catch (SQLException e) {
            Logger.getLogger(Khachhang.class.getName()).log(Level.SEVERE, null, e);
        }

    }

}
