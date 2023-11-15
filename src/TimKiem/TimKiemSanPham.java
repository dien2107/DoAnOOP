package TimKiem;

import SanPham.Ao;
import SanPham.ManagementSystemProduct;
import SanPham.Quan;

public class TimKiemSanPham {
    
    public static void SearchSanPham(String s1) {
        ManagementSystemProduct managementSystemProduct = new ManagementSystemProduct();
        Quan[] quanProducts = managementSystemProduct.getQuanProductList();
        Ao[] aoProducts = managementSystemProduct.getAoProductList();
        if (s1.startsWith("Q")) {
            for (Quan c : quanProducts) {
                if (s1.equalsIgnoreCase(c.getTen())) {
                    System.out.println(c);
                }
            }
            return;
        } else if (s1.startsWith("Á") || s1.startsWith("a") || s1.startsWith("A") || s1.startsWith("á")) {
            for (Ao c : aoProducts) {
                if (s1.equalsIgnoreCase(c.getTen())) {
                    System.out.println(c);
                }
            }
            return;
        }else {
        	 System.out.println("Không có sản phẩm bạn tìm");
        }
    }
}