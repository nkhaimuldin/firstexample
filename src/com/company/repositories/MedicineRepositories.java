package com.company.repositories;

import com.company.data.interfaces.IDB;
import com.company.entities.Medicine;
import com.company.repositories.interfaces.IMedicineRepositories;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class MedicineRepositories implements IMedicineRepositories {
    private final IDB db;
    public MedicineRepositories(IDB db){
        this.db=db;
    }

    @Override
    public boolean createMedicine(Medicine medicine) {
        Connection con = null;
        try{
            con=db.getConnection();
            String sql = "INSERT INTO medicines(name,price,expiration,manufacturer) VALUES(?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1,medicine.getName());
            st.setInt(2,medicine.getPrice());
            st.setDate(3,medicine.getExpiration());
            st.setString(4,medicine.getManufacturer());

            st.execute();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public Medicine getMedicine(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id, name, price, expiration, manufacturer FROM medicines WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Medicine medicine = new Medicine(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("price"),
                        rs.getString("expiration"),
                        rs.getString("manufacturer"));
                return medicine;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<Medicine> getAllMedicine() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id, name, price, expiration, manufacturer FROM medicines";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            List<Medicine> medicines = new LinkedList<>();
            while(rs.next()) {
                Medicine medicine = new Medicine(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("price"),
                        rs.getString("expiration"),
                        rs.getString("manufacturer"));
                medicines.add(medicine);
            }
            return medicines;
    } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
        }
    @Override
    public List<Medicine> getMedicineByName(String name) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT * FROM medicines WHERE Name=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, name);

            ResultSet rs = st.executeQuery();
            List<Medicine> list = new LinkedList<>();
            while(rs.next()){

                Medicine medicine = new Medicine(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("price"),
                        rs.getString("expiration"),
                        rs.getString("manufacturer"));
                list.add(medicine);
            }
            return list;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                con.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return null;
    }
    @Override
    public boolean removeMedicineByID(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "DELETE FROM medicines WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            st.executeUpdate();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                con.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return false;
    }
}
