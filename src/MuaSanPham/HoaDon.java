package MuaSanPham;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Date;

public class HoaDon {
	private String id;
	private Date date;
	private String tenKhachHang;
	private String masanphamdamua[];
	private int soluongsanpham[];
	private double TongTien;

	public HoaDon() {

	}

	public HoaDon(String tenKhachHang, String masanphamdamua[], int soluongsanpham[], double tien) {
		File file = new File("D:\\java\\DoAnOOP\\src\\fileHoaDon.txt");
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			int i = 0;
			while ((br.readLine()) != null) {
				i++;
			}
			this.id = "HD" + i;
			this.date = new Date();
			this.tenKhachHang = tenKhachHang;
			this.masanphamdamua = masanphamdamua;
			this.soluongsanpham = soluongsanpham;
			this.TongTien = tien;
			br.close();
		} catch (Exception e) {
		}

	}

	public void ReadFile() {
		File file = new File("D:\\java\\DoAnOOP\\src\\fileHoaDon.txt");
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line;
			while (true) {
				line = br.readLine();
				if (line != null) {
					String[] subInfos = line.split("; ");
					String idkhachhang = subInfos[0];
					String ngaymua = subInfos[1];
					String tenKH = subInfos[2];
					String str = subInfos[3];
					str = subInfos[3].substring(1, str.length() - 1);
					String[] arrSP = str.split(", ");
					String str2 = subInfos[4];
					str2 = subInfos[4].substring(1, str2.length() - 1);
					String[] arrSP1 = str2.split(", ");
					int n[] = new int[arrSP1.length];
					for (int i = 0; i < arrSP1.length; i++) {
						n[i] = Integer.parseInt(arrSP1[i]);
					}
					double TongTien = Double.parseDouble(subInfos[5]);
					String ten = "Cửa Hàng Bán Quần Áo OOP";
					System.out.println("----------------------------------------------------");
					System.out.println("            " + ten + "           ");
					System.out.println("----------------------------------------------------");
					System.out.println("Mã hóa đơn: " + idkhachhang);
					System.out.println("Ngày mua: " + ngaymua);
					System.out.println("Tên khách hàng: " + tenKH);

					System.out.println("----------------------------------------------------");
					System.out.println("                 Các sản phẩm đã mua:               ");
					System.out.println("Mã sản phẩm                                       SL");
					for (int i = 0; i < arrSP.length; i++) {
						System.out.println(
								(i + 1) + ")" + arrSP[i] + ".........................................."
										+ n[i]);
					}
					System.out.println(" ---------------------------------------------------");
					System.out.println("Tổng tiền: " + TongTien + "(Đã áp dụng discount)");
					System.out.println("----------------------------------------------------");
					System.out.println("****************************************************");
				} else {
					break;
				}

			}

		} catch (

		Exception e) {
			System.out.println("Lỗi !!!");
			e.printStackTrace();
		}

	}

	public void WriteFile() {
		File file = new File("D:\\java\\DoAnOOP\\src\\fileHoaDon.txt");
		try {
			FileWriter fw = new FileWriter(file, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			pw.println(
					this.id + "; "
							+ this.date.toString() + "; "
							+ this.tenKhachHang + "; "
							+ Arrays.toString(this.masanphamdamua) + "; "
							+ Arrays.toString(soluongsanpham) + "; "
							+ this.TongTien);
			pw.close();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public void InHoaDon() {
		String ten = "Cửa Hàng Bán Quần Áo OOP";
		System.out.println("----------------------------------------------------");
		System.out.println("            " + ten + "           ");
		System.out.println("----------------------------------------------------");
		System.out.println("Mã hóa đơn: " + this.id);
		System.out.println("Ngày mua: " + this.date.toString());
		System.out.println("Tên khách hàng: " + this.tenKhachHang);

		System.out.println("----------------------------------------------------");
		System.out.println("                 Các sản phẩm đã mua:               ");
		System.out.println("Mã sản phẩm                                       SL");
		for (int i = 0; i < masanphamdamua.length; i++) {
			System.out.println(
					(i + 1) + ")" + masanphamdamua[i] + ".........................................."
							+ soluongsanpham[i]);
		}
		System.out.println(" ---------------------------------------------------");
		System.out.println("Tổng tiền: " + this.TongTien + "(Đã áp dụng discount)");
		System.out.println("----------------------------------------------------");
	}

}
