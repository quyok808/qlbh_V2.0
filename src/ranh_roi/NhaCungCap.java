
package ranh_roi;

import java.util.*;
public class NhaCungCap {

    private ArrayList<HANGHOA> ncc = new ArrayList<>();

    public NhaCungCap() {
        init();
    }
    
    public void init(){
        ncc.add(new HANGHOA("1", "1", 1, 10));
        ncc.add(new HANGHOA("2", "2", 2, 10));
        ncc.add(new HANGHOA("3", "3", 3, 10));
        ncc.add(new HANGHOA("4", "4", 4, 10));
        ncc.add(new HANGHOA("5", "5", 5, 10));
        ncc.add(new HANGHOA("6", "6", 6, 10));
    }
    
    public void Nhap_SP(HANGHOA e){ // Nhap hang hoa oi ve de giao cho cua hang
        ncc.add(e);
    }
    
    public void Show_SP(){
        for (HANGHOA obj : ncc){
            obj.output();
        }
    }
    
    public void Xoa_SP(String MaSP){ // Xoa 1 san pham khi khong giao nua
        HANGHOA temp;
        temp = Tim_SP(MaSP);
        if (temp == null){
            System.out.println("Khong xoa duoc");
            return;
        }
        ncc.remove(temp);
        System.out.println("Da xoa");
    }
    
    public HANGHOA Tim_SP(String MaSP){ 
        for(HANGHOA obj:ncc){
            if (obj.getMaHang().equalsIgnoreCase(MaSP))
                return obj;
        }
        return null;
    }
    
    public void Xoa_SLSP(String MaSP, int soluong){ // tru kho khi giao hang cho cua hang
        HANGHOA temp;
        temp = Tim_SP(MaSP);
        if (soluong > temp.getSoluong()){
            System.out.println("Khong tru duoc");
            return;
        }
        temp.setSoluong(temp.getSoluong()-soluong);
    }
}
