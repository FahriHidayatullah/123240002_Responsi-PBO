/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Karyawan;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class KaryawanController implements KaryawanDAO {

    @Override
    public void add(Karyawan k) {
        String sql = "INSERT INTO evaluasi(nama, divisi, nilai_target, nilai_disiplin, nilai_inovasi, nilai_akhir, status) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = Connector.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, k.getNama());
            ps.setString(2, k.getDivisi());
            ps.setInt(3, k.getTarget());
            ps.setInt(4, k.getKedisiplinan());
            ps.setInt(5, k.getInovasi());
            ps.setDouble(6, k.getNilaiAkhir());
            ps.setString(7, k.getStatus());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error Add: " + e.getMessage());
        }
    }

    @Override
    public List<Karyawan> getAll() {
        List<Karyawan> list = new ArrayList<>();
        String sql = "SELECT * FROM evaluasi";
        try (Connection conn = Connector.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Karyawan k;
                String divisi = rs.getString("divisi");
                if (divisi.equalsIgnoreCase("Divisi Teknis")) {
                    k = new DivisiTeknis(rs.getString("nama"), rs.getString(divisi), rs.getInt("target"), rs.getInt("kedisiplinan"), rs.getInt("inovasi"));
                } else {
                    k = new DivisiPemasaran(rs.getString("nama"), rs.getString(divisi), rs.getInt("target"), rs.getInt("kedisiplinan"), rs.getInt("inovasi"));
                }
                k.setId(rs.getInt("id"));
                list.add(k);
            }
        } catch (SQLException e) {
            System.out.println("Error Get All: " + e.getMessage());
        }
        return list;
    }

    @Override
    public void update(Karyawan k) {
        String sql = "UPDATE evaluasi SET nama=?, divisi=?, nilai_target=?, nilai_disiplin=?, nilai_inovasi=?, nilai_akhir=?, status=? WHERE id=?";
        try (Connection conn = Connector.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, k.getNama());
            ps.setString(2, k.getDivisi());
            ps.setInt(3, k.getTarget());
            ps.setInt(4, k.getKedisiplinan());
            ps.setInt(5, k.getInovasi());
            ps.setDouble(6, k.getNilaiAkhir());
            ps.setString(7, k.getStatus());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error Update: " + e.getMessage());
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM evaluasi WHERE id=?";
        try (Connection conn = Connector.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error DELETE: " + e.getMessage());
        }
    }

}
