package SanPham;

public class Discount {

    public static double GiamGiaSanPham(String LvKH, Long tongTien) {
        if(tongTien > 10000000) {
            tongTien = tongTien * 90 / 100;
        }else if(tongTien > 5000000){
            tongTien = tongTien * 93 / 100;
        }else if(tongTien > 2000000){
            tongTien = tongTien * 95 / 100;
        }
        
        if(LvKH.equalsIgnoreCase("Dong")) {
            tongTien = tongTien * 98 /100;
        }else if(LvKH.equalsIgnoreCase("Bac")) {
            tongTien = tongTien * 95 /100;
        }else if(LvKH.equalsIgnoreCase("Vang")) {
            tongTien = tongTien * 97 /100;
        }
        return tongTien;
    }    
    
}