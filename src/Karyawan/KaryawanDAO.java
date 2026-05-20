/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Karyawan;

import java.util.*;

public interface KaryawanDAO {
    void add(Karyawan k);
    List<Karyawan> getAll();
    void update(Karyawan k);
    void delete(int id);
}
