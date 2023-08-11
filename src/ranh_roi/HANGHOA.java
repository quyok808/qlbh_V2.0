package ranh_roi;

import java.util.Scanner;

public class HANGHOA {
    private String MaHang, TenHang;
    private int soluong,DonGia;

    public HANGHOA(String MaHang, String TenHang, int DonGia, int soluong) {
        this.MaHang = MaHang;
        this.TenHang = TenHang;
        this.DonGia = DonGia;
        this.soluong = soluong;
    }

    public HANGHOA() {
    }

    public String getMaHang() {
        return MaHang;
    }

    public void setMaHang(String MaHang) {
        this.MaHang = MaHang;
    }

    public String getTenHang() {
        return TenHang;
    }

    public void setTenHang(String TenHang) {
        this.TenHang = TenHang;
    }

    public int getDonGia() {
        return DonGia;
    }

    public void setDonGia(int DonGia) {
        this.DonGia = DonGia;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }
    
    public void input(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ma hang: ");
        MaHang = sc.nextLine();
        System.out.println("Nhap ten hang");
        TenHang = sc.nextLine();
        System.out.println("Nhap don gia: ");
        DonGia = sc.nextInt();
        System.out.println("Nhap so luong: ");
        soluong = sc.nextInt();
    }
    
    public void output(){
        System.out.println(MaHang + " - " + TenHang + " - " + DonGia + " - " + soluong);
    }
}
