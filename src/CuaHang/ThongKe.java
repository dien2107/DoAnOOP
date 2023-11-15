package CuaHang;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;

public class ThongKe {

	public ThongKe() {

	}

	private double sum = 0;
	String ArraysSP[] = new String[1];
	int SL[] = new int[1];

	public void ShowThongKe() {
		File file = new File("D:\\java\\DoAnOOP\\src\\fileHoaDon.txt");
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line;
			while (true) {
				line = br.readLine();
				if (line != null) {
					String[] subInfos = line.split("; ");
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

					for (int i = 0; i < arrSP.length; i++) {
						if (ArraysSP[0] == null) {
							ArraysSP[0] = arrSP[i];
							SL[0] += n[0];
						} else {
							boolean flag = false;
							for (int j = 0; j < ArraysSP.length; j++) {
								if (ArraysSP[j].equals(arrSP[i])) {
									SL[j] += n[i];
									flag = true;
									break;
								}
							}
							if (flag == false) {
								int N = ArraysSP.length;
								ArraysSP = Arrays.copyOf(ArraysSP, N + 1);
								SL = Arrays.copyOf(SL, N + 1);
								ArraysSP[N] = arrSP[i];
								SL[N] += n[i];
							}

						}
					}
					sum += Double.parseDouble(subInfos[5]);
				} else {
					break;
				}

			}
			br.close();
			String ten = "Cửa Hàng Bán Quần Áo OOP";
			System.out.println("----------------------------------------------------");
			System.out.println("            " + ten + "           ");
			System.out.println("----------------------------------------------------");
			System.out.println("                Thống kê doanh thu                  ");
			System.out.println("----------------------------------------------------");
			System.out.println("              Các sản phẩm đã được bán:             ");
			System.out.println("Mã sản phẩm                                       SL");
			for (int i = 0; i < ArraysSP.length; i++) {
				System.out.println(
						(i + 1) + ")" + ArraysSP[i] + ".........................................."
								+ SL[i]);
			}
			System.out.println(" ---------------------------------------------------");
			System.out.println("Tổng doanh thu: " + this.sum);
			System.out.println("----------------------------------------------------");
		} catch (Exception e) {
			System.out.println("Lỗi !!!");
			e.printStackTrace();
		}
	}

}
