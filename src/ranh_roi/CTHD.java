package ranh_roi;

import java.util.*;
/**
 *
 * NGUYEN CONG QUY
 */
public class CTHD{
//================================= Properties ======================
    private ArrayList<HANGHOA> cthd = new ArrayList<>();
    private HOADON hd = new HOADON();
    private int[] SLOrder = new int[100];
    private int n = 0;
    
//================================= Constructer =====================
    public CTHD() {
        hd.init_HD(); 
    }
//================================= Getter and setter ===============

    public ArrayList<HANGHOA> getCthd() {
        return cthd;
    }

    public void setCthd(ArrayList<HANGHOA> cthd) {
        this.cthd = cthd;
    } 

    public int[] getSLOrder() {
        return SLOrder;
    }

    public void setSLOrder(int[] SLOrder) {
        this.SLOrder = SLOrder;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public HOADON getHd() {
        return hd;
    }

    public void setHd(HOADON hd) {
        this.hd = hd;
    }

//================================= Methods ===============
    

    public int input_CTHD(HANGHOA e, int soluong){
        if (n == 0 && cthd.isEmpty()){
            cthd.add(e);
            SLOrder[n++] = soluong;
        } else {
            int flag = -1;
            for (int i = 0; i < cthd.size(); i++){
                if (cthd.get(i).getMaHang().equals(e.getMaHang())){
                    flag = i;
                    break;
                }  
            }
            if (flag == -1) {
                cthd.add(e);
                SLOrder[n++] = soluong;
            } else {
                SLOrder[flag] += soluong;
            }
        }
        return 0;
    }
    
    public double thanhtien(){                    
        double tongtien = 0;
        for (int i = 0; i < cthd.size(); i++){
            tongtien += (cthd.get(i).getDonGia() * SLOrder[i]);
        }
        return tongtien;
    }
    
    public void output(){
        System.out.println("+-------------------------------------+");
        hd.setThanhtien(thanhtien());
        hd.output();
        System.out.println("+--------------------+----------+-----+");
        System.out.println("|Tên hàng hoá        |Giá bán   |SL   |");
        for (HANGHOA obj : cthd){
            System.out.println("|--------------------+----------+-----+");
            int soluong_xuatkho = SLOrder[cthd.indexOf(obj)];
            System.out.printf("|%20s|%10d|%5d|\n",obj.getTenHang(),obj.getDonGia(),soluong_xuatkho);   
        }
        System.out.println("+--------------------+----------+-----+");
    }
}
