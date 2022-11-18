/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RepositoryJdbc.Implement;

import DomainModel.Size;
import RepositoryJdbc.Interface.SizeRepositoryInterface;
import Utility.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class SizeRepositoryImplement implements SizeRepositoryInterface {

    private static Connection connection;

    public SizeRepositoryImplement() {
        connection = DBContext.getConnection();
    }

    @Override
    public List<Size> getAllSize() {
        List<Size> listSize = new ArrayList<>();
        String sql = "SELECT [Id]\n"
                + "      ,[Ma]\n"
                + "      ,[TheTich]\n"
                + "  FROM [dbo].[Size]";
        try {
            PreparedStatement ps =connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                Size sz = new Size();
                sz.setId(rs.getString("Id"));
                sz.setMa(rs.getString("Ma"));
                sz.setTheTich(rs.getString("TheTich"));
                listSize.add(sz);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SizeRepositoryImplement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listSize;
    }

}
