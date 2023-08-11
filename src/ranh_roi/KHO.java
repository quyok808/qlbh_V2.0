package ranh_roi;
import java.util.*;

public class KHO {
    static Scanner sc = new Scanner(System.in);
    private ArrayList<HANGHOA> kho = new ArrayList<>();
    private NhaCungCap ncc = new NhaCungCap();

    public KHO() {
        init();
    }
    
    public void init(){
        kho.add(new HANGHOA("1", "1", 1, 1));
        kho.add(new HANGHOA("12", "12", 12, 10));
        kho.add(new HANGHOA("13", "13", 13, 10));
        kho.add(new HANGHOA("14", "14", 14, 10));
        kho.add(new HANGHOA("15", "15", 15, 10));
        kho.add(new HANGHOA("16", "16", 16, 10));
    }
    
    public void NhapKho(String Masp, int soluong){   
        // Nhap Them so luong vao kho
        HANGHOA temp = Tim_SP(Masp);
        if (temp != null){
            temp.setSoluong(temp.getSoluong()+soluong);
        } else {
            HANGHOA h1;
            h1 = ncc.Tim_SP(Masp);
            if (h1 != null){
                kho.add(h1); //Nhap moi chua co trong kho
                h1.setSoluong(soluong);
            }
        } 
    }
    
    public void ThongKe(){
        for (HANGHOA obj : kho){
            obj.output();
        }
    }
    
    public HANGHOA Tim_SP(String MaSP){ 
        for(HANGHOA obj:kho){
            if (obj.getMaHang().equalsIgnoreCase(MaSP))
                return obj;
        }
        return null;
    } 
    
    public void Xoa_SLSP(HANGHOA h, int soluong){
        if (soluong > h.getSoluong()){
            System.out.println("Khong tru duoc");
            return;
        }
        h.setSoluong(h.getSoluong()-soluong);
    }
}
