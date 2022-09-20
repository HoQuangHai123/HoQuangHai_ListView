package com.example.adapterlistview;

public class TraiCay {
    private String Ten;
    private String Mota;
    private int Hinh;
    private String Tien;

    public TraiCay(String ten, String mota, int hinh, String tien) {
        Ten = ten;
        Mota = mota;
        Hinh = hinh;
        Tien = tien;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public String getMota() {
        return Mota;
    }

    public void setMota(String mota) {
        Mota = mota;
    }

    public int getHinh() {
        return Hinh;
    }

    public void setHinh(int hinh) {
        Hinh = hinh;
    }

    public String getTien(){return Tien;}

    public void setTien(String tien){Tien = tien;}
}
