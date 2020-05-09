package com.example.barangfirebase.Child;

public class data_terjual {
    private String kodeTerjual;
    private String namaTerjual;
    private String satuanTerjual;
    private String tanggalTerjual;
    private String hargaTerjual;

    public String getSatuanTerjual() {
        return satuanTerjual;
    }

    public void setSatuanTerjual(String satuanTerjual) {
        this.satuanTerjual = satuanTerjual;
    }

    public String getTanggalTerjual() {
        return tanggalTerjual;
    }

    public void setTanggalTerjual(String tanggalTerjual) {
        this.tanggalTerjual = tanggalTerjual;
    }

    public String getHargaTerjual() {
        return hargaTerjual;
    }

    public void setHargaTerjual(String hargaTerjual) {
        this.hargaTerjual = hargaTerjual;
    }

    private String jumlahTerjual;

    public String getKodeTerjual() {
        return kodeTerjual;
    }

    public void setKodeTerjual(String kodeTerjual) {
        this.kodeTerjual = kodeTerjual;
    }

    public String getNamaTerjual() {
        return namaTerjual;
    }

    public void setNamaTerjual(String namaTerjual) {
        this.namaTerjual = namaTerjual;
    }

    public String getJumlahTerjual() {
        return jumlahTerjual;
    }

    public void setJumlahTerjual(String jumlahTerjual) {
        this.jumlahTerjual = jumlahTerjual;
    }

    public data_terjual(){
    }


    public data_terjual(String kode, String nama, String satuan,String tanggal, String harga, String jumlah) {
        this.kodeTerjual=kode;
        this.namaTerjual = nama;
        this.satuanTerjual = satuan;
        this.tanggalTerjual = tanggal;
        this.hargaTerjual = harga;
        this.jumlahTerjual=jumlah;
    }
}
