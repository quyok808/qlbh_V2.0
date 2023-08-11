package ranh_roi;

import java.util.Random;
import java.util.Scanner;
import java.time.LocalDate;

/**
 *
 * NGUYEN CONG QUY
 */
public class HOADON {
//================================= Properties =====================
    protected String SoHD, NgayLap;
    protected double Thanhtien;
//================================= Constructer =====================
    public HOADON() {
    }
    
//================================= Getter and setter =====================

    public String getSoHD() {
        return SoHD;
    }

    public void setSoHD(String SoHD) {
        this.SoHD = SoHD;
    }

    public String getNgayLap() {
        return NgayLap;
    }

    public void setNgayLap(String NgayLap) {
        this.NgayLap = NgayLap;
    }

    public double getThanhtien() {
        return Thanhtien;
    }

    public void setThanhtien(double Thanhtien) {
        this.Thanhtien = Thanhtien;
    }
    
//================================= Random SoHD =====================
    public static Random getGenerator() {
        return generator;
    }

    public static void setGenerator(Random generator) {
        HOADON.generator = generator;
    }

    //========================================================
    //              Tạo class random số và chữ
    private static final String alpha = "abcdefghijklmnopqrstuvwxyz"; // a-z
    private static final String alphaUpperCase = alpha.toUpperCase(); // A-Z
    private static final String digits = "0123456789"; // 0-9
    private static final String ALPHA_NUMERIC = alpha + alphaUpperCase + digits;
 
    private static Random generator = new Random();
 
    /**
     * Random string with a-zA-Z0-9, not included special characters
     */
    public String randomAlphaNumeric(int numberOfCharactor) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numberOfCharactor; i++) {
            int number = randomNumber(0, ALPHA_NUMERIC.length() - 1);
            char ch = ALPHA_NUMERIC.charAt(number);
            sb.append(ch);
        }
        return sb.toString();
    }

    public static int randomNumber(int min, int max) {
        return generator.nextInt((max - min) + 1) + min;
    }
    
//================================= Methods =====================
    
    public void init_HD(){
        Scanner sc = new Scanner(System.in);
        setSoHD(randomAlphaNumeric(6));
        setNgayLap(LocalDate.now().toString());
    }
    
    public void output(){
        System.out.printf("|Số HD: %30s|\n", getSoHD());
        System.out.printf("|Ngày lập: %27s|\n", getNgayLap());
        System.out.printf("|Thành tiền: %25f|\n", getThanhtien());
    }
    
    public static void main(String[] args){
        HOADON hd = new HOADON();
        hd.init_HD();
        hd.output();
    }
}
