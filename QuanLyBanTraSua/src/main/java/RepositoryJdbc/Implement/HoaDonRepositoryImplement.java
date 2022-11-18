/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RepositoryJdbc.Implement;

import DomainModel.HoaDon;
import DomainModel.KhachHang;
import DomainModel.KhuyenMai;
import DomainModel.NhanVien;
import RepositoryJdbc.Interface.HoaDonRepositoryInterface;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author FPTSHOP
 */
public class HoaDonRepositoryImplement implements HoaDonRepositoryInterface{
    private static Connection cn = Utility.DBContext.getConnection();
    @Override
    public List<HoaDon> getList() {
        List<HoaDon> lst_hd = new ArrayList<>();
        String sql = "select hd.Ma,nv.HoTen as Ten_nv,hd.ngayTao,hd.TongTien,kh.HoTen as Ten_kh,km.Ma as Ma_km,hd.TrangThai from HoaDon hd\n" +
"join NhanVien nv on hd.Id_NV = nv.Id \n" +
"join Khachhang kh on hd.id_KH = kh.Id \n" +
"join KhuyenMai km on hd.id_KM = km.Id";
        try {
            PreparedStatement pr = cn.prepareStatement(sql);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {  
                KhuyenMai km = new KhuyenMai();
                km.setMa(rs.getString("Ma_km"));
                NhanVien nv = new NhanVien();
                nv.setHoTen(rs.getString("Ten_nv"));
                KhachHang kh = new KhachHang();
                kh.setHoTen(rs.getString("Ten_kh"));
                HoaDon hd = new HoaDon(null, rs.getString("ma"), nv, rs.getString("ngaytao"), rs.getBigDecimal("tongtien"), kh, km, rs.getInt("trangthai"));
                lst_hd.add(hd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst_hd;
    }
    
}
