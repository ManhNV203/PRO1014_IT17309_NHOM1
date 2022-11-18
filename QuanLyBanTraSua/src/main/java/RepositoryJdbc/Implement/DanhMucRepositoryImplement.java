package RepositoryJdbc.Implement;

import DomainModel.DanhMuc;
import RepositoryJdbc.Interface.DanhMucRepositoryInterface;
import Utility.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DanhMucRepositoryImplement implements DanhMucRepositoryInterface {
    private static Connection connection;
    public DanhMucRepositoryImplement(){
        connection = DBContext.getConnection();
    }
    @Override
    public List<DanhMuc> getAllDM() {
        List<DanhMuc> listDM = new ArrayList<>();
        String sql = "SELECT [Id]\n"
                + "      ,[Ma]\n"
                + "      ,[Ten]\n"
                + "  FROM [dbo].[DanhMuc]";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                DanhMuc dm = new DanhMuc();
                dm.setId(rs.getString("Id"));
                dm.setMa(rs.getString("Ma"));
                dm.setTenDM(rs.getString("Ten"));
                listDM.add(dm);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DanhMucRepositoryImplement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listDM;
    }
}
