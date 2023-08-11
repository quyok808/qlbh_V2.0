package ranh_roi;

import java.util.*;
import static ranh_roi.KHO.sc;


public class Ranh_roi {
    private KHO kho = new KHO();
    private NhaCungCap ncc = new NhaCungCap();
    private CTHD cthd;
    
    public Ranh_roi() {
    }
    
    public void Nhap_Hang_vao_Kho(){
        Scanner sc = new Scanner(System.in);
        kho.ThongKe();
        System.out.println();
        int stop;
        do{
            ncc.Show_SP();
            System.out.println("Ma hang muon nhap: ");
            String Masp = sc.nextLine();
            System.out.println("So luong nhap: ");
            int soluong = sc.nextInt();
            kho.NhapKho(Masp,soluong);
            ncc.Xoa_SLSP(Masp, soluong);
            System.out.println("tiep tuc ? ");
            stop = sc.nextInt();
            sc.nextLine();
        } while(stop != 0);
        
        System.out.println();
        kho.ThongKe();
        System.out.println("Xem ncc");
        System.out.println();
        ncc.Show_SP();
    }
    
    public void Ton_Kho(){
        kho.ThongKe();
    }
    
    public void Nhap_NCC(HANGHOA h){
        h = new HANGHOA();
        h.input();
        ncc.Nhap_SP(h);
    }
    
    public void Xoa_SP_NCC(){
        sc.nextLine();
        String Masp;
        System.out.println("Nhap ma sp muon xoa: ");
        Masp = sc.nextLine();
        ncc.Xoa_SP(Masp);
    }
    
    public void Xem_Kho_NCC(){
        ncc.Show_SP();
    }
    
    public void BanHang(){
        cthd = new CTHD();
        System.out.println("Chọn -1 để hoàn thành order!");
        int chon_order;
        do{
            kho.ThongKe();
            
            String Mahang;
            System.out.println("Nhap ma hang: ");
            Mahang = sc.nextLine();
            HANGHOA order;
            order = kho.Tim_SP(Mahang);
            System.out.println("Số lượng: ");
            int soluong = sc.nextInt();
            cthd.input_CTHD(order, soluong);
            System.out.println("Thanh toan ?(1/0)");
            chon_order = sc.nextInt();
            sc.nextLine();
            if (chon_order == 1){
                break;
            }
        }while(chon_order != 1); 
        cthd.output();
    }
    
    public void Thanhtoan(){
        for (HANGHOA obj : cthd.getCthd()){
            kho.Xoa_SLSP(obj, cthd.getSLOrder()[cthd.getCthd().indexOf(obj)]);
        }
        cthd.output();
    }
    
    public static void main(String[] args) {
        Ranh_roi rr = new Ranh_roi();
        
        Scanner sc = new Scanner(System.in);
        int chon;
        do{
            System.out.println("0: Thoat");
            System.out.println("1: Nha cung cap");
            System.out.println("2: Cua hang");
            chon = sc.nextInt();
            switch(chon){
                case 1:
                    HANGHOA h = null;
                    int chon_ncc;
                    do {
                        System.out.println("0: Thoat");
                        System.out.println("1: Nhap mat hang moi");
                        System.out.println("2: Xoa mat hang");
                        System.out.println("3: Show kho");
                        chon_ncc = sc.nextInt();
                        switch(chon_ncc){
                            case 1:
                                rr.Nhap_NCC(h);
                                break;
                            case 2: 
                                rr.Xoa_SP_NCC();
                                break;
                            case 3:
                                rr.Xem_Kho_NCC();
                                break;
                            default:
                                chon_ncc = 0;
                                break;
                        }
                    } while(chon_ncc != 0);
                    break;
                case 2:
                    int chon_cuahang;
                    do{
                        System.out.println("0: Thoat");
                        System.out.println("1: Nhap kho");
                        System.out.println("2: Ban hang");
                        System.out.println("3: Ton kho");
                        System.out.print("Chon: "); 
                        chon_cuahang= sc.nextInt();
                        switch (chon_cuahang) {
                            case 1:
                                rr.Nhap_Hang_vao_Kho();
                                break;
                            case 2:
                                rr.BanHang();
                                System.out.println("Xac nhan thanh toan: (1/0)");
                                int xac_nhan = sc.nextInt();
                                if (xac_nhan == 1){
                                    rr.Thanhtoan();
                                    System.out.println("Da thanh toan thanh cong!");
                                }
                                break;
                            case 3:
                                rr.Ton_Kho();
                                break;
                            default:
                                chon_cuahang = 0;
                                break;
                        }
                    } while(chon_cuahang != 0);
                    break;
                default:
                    chon = 0;
                    break;
            }  
        }while(chon != 0);
    }
}
