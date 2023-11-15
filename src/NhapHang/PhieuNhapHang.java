package NhapHang;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;

import SanPham.Ao;
import SanPham.ManagementSystemProduct;
import SanPham.Quan;

public class PhieuNhapHang {

	private String IDphieuNhapHang;
	private String ngayNhapHang;
	private String IDNhaCungCap;
	private String tenNhacungcap;
	private String IDNhanVien;
	private double TongTien;
	private Object matHang;

	private ManagementSystemProduct m = new ManagementSystemProduct();
	Quan[] arQ = m.getQuanProductList();
	Ao[] arA = m.getAoProductList();

	public PhieuNhapHang(String IDphieuNhapHang, String ngayNhapHang, String iDNhaCungCap, String tenNhacungcap,
			String iDNhanVien, double tongTien, Object matHang) {
		this.IDphieuNhapHang = IDphieuNhapHang;
		this.ngayNhapHang = ngayNhapHang;
		this.IDNhaCungCap = iDNhaCungCap;
		this.tenNhacungcap = tenNhacungcap;
		this.IDNhanVien = iDNhanVien;
		this.TongTien = tongTien;
		this.matHang = matHang;
	}

	public PhieuNhapHang() {

	}

	public void NhapHang() {
		File file = new File("D:\\java\\DoAnOOP\\src\\filePhieuNhapHang.txt");
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line;
			while (true) {
				line = br.readLine();

				if (line != null) {
					System.out.println(line);
					String[] subInfos = line.split(", ");
					if (subInfos[6].startsWith("Q")) {
						boolean flag1 = false;
						for (int i = 0; i < arQ.length; i++) {
							if (subInfos[6].equalsIgnoreCase(arQ[i].getMaHang())) {
								arQ[i].setSoluong(arQ[i].getSoluong() + Integer.parseInt(subInfos[11]));
								flag1 = true;
								break;
							}
						}
						if (flag1 == false) {
							Quan newQuan = new Quan(subInfos[6], subInfos[7], subInfos[8], subInfos[9],
									Long.parseLong(subInfos[10]), Integer.parseInt(subInfos[11]),
									Integer.parseInt(subInfos[12]));
							m.addProduct(newQuan);
						}
					} else if (subInfos[6].startsWith("A")) {
						boolean flag2 = false;
						for (int i = 0; i < arA.length; i++) {
							if (subInfos[6].equalsIgnoreCase(arA[i].getMaHang())) {
								arA[i].setSoluong(arA[i].getSoluong() + Integer.parseInt(subInfos[11]));
								flag2 = true;
								break;
							}
						}
						if (flag2 == false) {
							Ao newAo = new Ao(subInfos[6], subInfos[7], subInfos[8], subInfos[9],
									Long.parseLong(subInfos[10]), Integer.parseInt(subInfos[11]), subInfos[12]);
							m.addProduct(newAo);
						}
					}
				} else {
					break;
				}
			}
			br.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public ManagementSystemProduct Update() {
		return this.m;
	}
}
