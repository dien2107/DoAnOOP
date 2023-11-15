package MuaSanPham;

import SanPham.Ao;
import SanPham.ManagementSystemProduct;
import SanPham.Quan;

public class MuaHang {
	private ManagementSystemProduct m = new ManagementSystemProduct();

	public MuaHang(ManagementSystemProduct m) {
		this.m = m;
	}

	public Long MuaSanPham(String ID, int soluong) {
		Quan[] spQuan = this.m.getQuanProductList();
		Ao[] spAo = this.m.getAoProductList();
		int count = 0;
		for (int i = 0; i < spAo.length; i++) {
			if (ID.equalsIgnoreCase(spAo[i].getMaHang())) {
				count += 1;
			}
		}
		for (int i = 0; i < spQuan.length; i++) {
			if (ID.equalsIgnoreCase(spQuan[i].getMaHang())) {
				count += 1;
			}
		}
		if (count == 1) {
			if (ID.startsWith("A")) {
				for (int i = 0; i < spAo.length; i++) {
					if (ID.equalsIgnoreCase(spAo[i].getMaHang())) {
						if (soluong > spAo[i].getSoluong()) {
							System.out.println("Không đủ mặt hàng cung cấp !");
							return null;
						} else {
							spAo[i].setSoluong(spAo[i].getSoluong() - soluong);
							return soluong * spAo[i].getGia();
						}
					}
				}
			} else if (ID.startsWith("Q")) {
				for (int i = 0; i < spQuan.length; i++) {
					if (ID.equalsIgnoreCase(spQuan[i].getMaHang())) {
						if (soluong > spQuan[i].getSoluong()) {
							System.out.println("Không đủ mặt hàng cung cấp !");
							return null;
						} else {
							spQuan[i].setSoluong(spQuan[i].getSoluong() - soluong);
							return soluong * spQuan[i].getGia();
						}
					}
				}
			}
		}

		System.out.println("Chúng tôi không có sản phẩm này !");
		return null;
	}

	public ManagementSystemProduct capnhapSLSP() {
		return m;
	}

}