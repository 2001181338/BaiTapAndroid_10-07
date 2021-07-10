package com.example.myapplication;

public class Contract {
    public String hoTen;
    public String soDienThoai;

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public Contract(String hoTen, String soDienThoai) {
        this.hoTen = hoTen;
        this.soDienThoai = soDienThoai;
    }

    public Contract() {
    }
}
