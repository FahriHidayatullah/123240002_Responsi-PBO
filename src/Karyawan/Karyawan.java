/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Karyawan;

public abstract class Karyawan {

    private int id;
    private String nama;
    String divisi;
    private int target;
    private int kedisiplinan;
    private int inovasi;
    private double nilaiAkhir;
    private String status;

    public Karyawan(String nama, String path, int target, int kedisiplinan, int inovasi) {
        this.nama = nama;
        this.divisi = divisi;
        this.target = target;
        this.kedisiplinan = kedisiplinan;
        this.inovasi = inovasi;
        this.nilaiAkhir = hitungNilaiAkhir();
        this.status = (this.nilaiAkhir >= 85) ? "PROMOSI" : "TETAP";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public String getDivisi() {
        return divisi;
    }

    public int getTarget() {
        return target;
    }

    public int getKedisiplinan() {
        return kedisiplinan;
    }

    public int getInovasi() {
        return inovasi;
    }

    public double getNilaiAkhir() {
        return nilaiAkhir;
    }

    public String getStatus() {
        return status;
    }
    
    public double hitungNilaiAkhir(){
        return (target * 0.5) + (kedisiplinan * 0.3) + (inovasi * 0.2);
    }
}
