package com.example.barangfirebase.Child;

public class data_barang {

    //Deklarasi Variable
    private String kode;
    private String nama;
    private String satuan;
    private String expDate;
    private String harga;
    private String jumlah;
    private String key;

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public String getSatuan() {
        return satuan;
    }

    public void setSatuan(String satuan) {
        this.satuan = satuan;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJumlah() {
        return jumlah;
    }

    public void setJumlah(String jumlah) {
        this.jumlah=jumlah;
    }

    //Membuat Konstuktor kosong untuk membaca data snapshot
    public data_barang(){
    }

    //Konstruktor dengan beberapa parameter, untuk mendapatkan Input Data dari User
    public data_barang(String kode, String nama, String satuan, String tanggal, String harga, String jumlah) {
        this.kode=kode;
        this.nama = nama;
        this.satuan = satuan;
        this.expDate = tanggal;
        this.harga = harga;
        this.jumlah=jumlah;
    }
}
