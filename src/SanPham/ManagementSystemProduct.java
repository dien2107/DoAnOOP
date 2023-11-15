package SanPham;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.text.html.HTMLEditorKit.InsertHTMLTextAction;

import ChucNang.ChucNangCoBan;
import ChucNang.ChucNangSanPham;
import DiaChi.Address;
import NhanVien.FullTime;
import NhanVien.Manager;
import NhanVien.PartTime;

public class ManagementSystemProduct implements ChucNangCoBan, ChucNangSanPham {
	
	Scanner sc = new Scanner(System.in);

	public ManagementSystemProduct() {
		ReadFile();
	}

	Ao[] arrayAo = new Ao[1];
	Quan[] arrayQuan = new Quan[1];

	@Override
	public void ReadFile() {
		File file = new File("D:\\java\\DoAnOOP\\src\\fileSanPham.txt");
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line;

			while ((line = br.readLine()) != null) {
				String[] subInfos = line.split(", ");
				if (subInfos[0].startsWith("Q")) {
					if (arrayQuan[0] == null) {
						arrayQuan[0] = new Quan(subInfos[0], subInfos[1], subInfos[2], subInfos[3],
								Long.parseLong(subInfos[4]), Integer.parseInt(subInfos[5]),
								Integer.parseInt(subInfos[6]));
					} else {
						int N = arrayQuan.length;
						arrayQuan = Arrays.copyOf(arrayQuan, N + 1);
						arrayQuan[N] = new Quan(subInfos[0], subInfos[1], subInfos[2], subInfos[3],
								Long.parseLong(subInfos[4]), Integer.parseInt(subInfos[5]),
								Integer.parseInt(subInfos[6]));
					}
					// Quần
				} else if (subInfos[0].startsWith("A")) {
					if (arrayAo[0] == null) {
						arrayAo[0] = new Ao(subInfos[0], subInfos[1], subInfos[2], subInfos[3],
								Long.parseLong(subInfos[4]), Integer.parseInt(subInfos[5]), subInfos[6]);
					} else {
						int N = arrayAo.length;
						arrayAo = Arrays.copyOf(arrayAo, N + 1);
						arrayAo[N] = new Ao(subInfos[0], subInfos[1], subInfos[2], subInfos[3],
								Long.parseLong(subInfos[4]), Integer.parseInt(subInfos[5]), subInfos[6]);

					}
					// Áo
				}
			}

			br.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Lỗi load file!");
		}
	}

	public void showAllListProduct() {
		for (Ao c : arrayAo) {
			if (c != null) {
				System.out.println(c);
			}
		}
		for (Quan c : arrayQuan) {
			if (c != null) {
				System.out.println(c);
			}
		}
	}

	@Override
	public void WriteFile() {
		// TODO Auto-generated method stub
		File file = new File("D:\\java\\DoAnOOP\\src\\fileSanPham.txt");
		try {
			FileWriter fileWriter = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fileWriter);

			for (Ao ao : arrayAo) {
				bw.write(ao.getMaHang() + ", "
						+ ao.getTen() + ", "
						+ ao.getDescript() + ", "
						+ ao.getColor() + ", "
						+ ao.getGia() + ", "
						+ ao.getSoluong() + ", "
						+ ao.getSize() + "\n");
			}
			for (Quan quan : arrayQuan) {
				bw.write(quan.getMaHang() + ", "
						+ quan.getTen() + ", "
						+ quan.getDescript() + ", "
						+ quan.getColor() + ", "
						+ quan.getGia() + ", "
						+ quan.getSoluong() + ", "
						+ quan.getSize() + "\n");
			}

			bw.close();
			System.out.println("Ghi file thành công!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addProduct(Object product) {
		if (product instanceof Quan) {
			if (arrayQuan[0] == null) {
				arrayQuan[0] = (Quan) product;
			}
			int n = arrayQuan.length;
			arrayQuan = Arrays.copyOf(arrayQuan, n + 1);
			arrayQuan[n] = (Quan) product;
		} else if (product instanceof Ao) {
			if (arrayAo[0] == null) {
				arrayAo[0] = (Ao) product;
			}
			int n = arrayAo.length;
			arrayAo = Arrays.copyOf(arrayAo, n + 1);
			arrayAo[n] = (Ao) product;
		} else {
			System.out.println("Dữ liệu truyền vào không phù hợp");
		}
	}

	@Override
	public void editProduct(String ID) {
		int n;
		int index = 0;
		if (ID.startsWith("A")) {
			for (Ao c : arrayAo) {
				if (c.getMaHang().equals(ID)) {
					break;
				}
				index++;
			}
			if (index == arrayAo.length) {
				System.out.println("Không có sản phẩm trong danh sách!");
				return;
			}
			System.out.println("----------------------------------------------------");
			System.out.println("|            Mời bạn chọn chế độ:                  |");
			System.out.println("|     1:   Sửa Mã Sản Phẩm                         |");
			System.out.println("|     2:   Sửa Tên Sản Phẩm                        |");
			System.out.println("|     3:   Sửa Mô Tả Sản Phẩm                      |");
			System.out.println("|     4:   Sửa Màu Sản Phẩm                        |");
			System.out.println("|     5:   Sửa Giá Sản Phẩm                        |");
			System.out.println("|     6:   Sửa Số Lượng Sản Phẩm                   |");
			System.out.println("|     7:   Sửa Kích Thước Sản Phẩm                 |");
			System.out.println("----------------------------------------------------");
			System.out.println(
					"Nhập các lựa chọn muốn chỉnh sửa thông tin nhân viên (nhập liền các lựa chọn (VD:1234)): ");
			n = Integer.parseInt(sc.nextLine());

			// tạo biến tạm
			// tạo vòng lặp điều kiện là khi nào n còn lớn hơn 0 thì làm {
			// tạm = n %10;
			// n /= 10; loại bỏ số biến tạm vừa giữ
			// dùng switch ... case để check biến tạm là gì để sửa theo đúng yêu cầu biến
			// tạm
			// } kết thúc vòng lặp
			while (n > 0) {
				int tmp = n % 10;
				switch (tmp) {
					case 1:
						System.out.print("Nhập mã sản phẩm thay thế: ");
						arrayAo[index].setMaHang(sc.nextLine());
						break;
					case 2:
						System.out.print("Nhập tên sản phẩm thay thế: ");
						arrayAo[index].setTen(sc.nextLine());
						break;
					case 3:
						System.out.print("Sửa mô tả sản phẩm: ");
						arrayAo[index].setDescript(sc.nextLine());
						break;
					case 4:
						System.out.print("Sửa màu sản phẩm: ");
						arrayAo[index].setColor(sc.nextLine());
						break;
					case 5:
						System.out.print("Sửa giá sản phẩm: ");
						arrayAo[index].setGia(Integer.parseInt(sc.nextLine()));
						break;
					case 6:
						System.out.print("Sửa số lượng sản phẩm: ");
						arrayAo[index].setSoluong(Integer.parseInt(sc.nextLine()));
						break;
					case 7:
						System.out.print("Sửa kích thước sản phẩm: ");
						arrayAo[index].setSize(sc.nextLine());
						break;
					default:
						break;
				}
				n /= 10;

			}

		} else if (ID.startsWith("Q")) {
			for (Quan c : arrayQuan) {
				if (c.getMaHang().equals(ID)) {
					break;
				}
				index++;
			}
			if (index == arrayQuan.length) {
				System.out.println("Không có sản phẩm trong danh sách!");
				return;
			}
			System.out.println("----------------------------------------------------");
			System.out.println("|            Mời bạn chọn chế độ:                  |");
			System.out.println("|     1:   Sửa Mã Sản Phẩm                         |");
			System.out.println("|     2:   Sửa Tên Sản Phẩm                        |");
			System.out.println("|     3:   Sửa Mô Tả Sản Phẩm                      |");
			System.out.println("|     4:   Sửa Màu Sản Phẩm                        |");
			System.out.println("|     5:   Sửa Giá Sản Phẩm                        |");
			System.out.println("|     6:   Sửa Số Lượng Sản Phẩm                   |");
			System.out.println("|     7:   Sửa Kích Thước Sản Phẩm                 |");
			System.out.println("----------------------------------------------------");
			System.out.println(
					"Nhập các lựa chọn muốn chỉnh sửa thông tin nhân viên (nhập liền các lựa chọn (VD:1234)): ");
			n = Integer.parseInt(sc.nextLine());
			// tạo biến tạm
			// tạo vòng lặp điều kiện là khi nào n còn lớn hơn 0 thì làm {
			// tạm = n %10;
			// n /= 10; loại bỏ số biến tạm vừa giữ
			// dùng switch ... case để check biến tạm là gì để sửa theo đúng yêu cầu biến
			// tạm
			// } kết thúc vòng lặp
			while (n > 0) {
				int tmp = n % 10;
				switch (tmp) {
					case 1:
						System.out.print("Nhập mã sản phẩm thay thế: ");
						arrayQuan[index].setMaHang(sc.nextLine());
						break;
					case 2:
						System.out.print("Nhập tên sản phẩm thay thế: ");
						arrayQuan[index].setTen(sc.nextLine());
						break;
					case 3:
						System.out.print("Sửa mô tả sản phẩm: ");
						arrayQuan[index].setDescript(sc.nextLine());
						break;
					case 4:
						System.out.print("Sửa màu sản phẩm: ");
						arrayQuan[index].setColor(sc.nextLine());
						break;
					case 5:
						System.out.print("Sửa giá sản phẩm: ");
						arrayQuan[index].setGia(Integer.parseInt(sc.nextLine()));
						break;
					case 6:
						System.out.print("Sửa số lượng sản phẩm: ");
						arrayQuan[index].setSoluong(Integer.parseInt(sc.nextLine()));
						break;
					case 7:
						System.out.print("Sửa kích thước sản phẩm: ");
						arrayQuan[index].setSize(Integer.parseInt(sc.nextLine()));
						break;
					default:
						break;
				}
				n /= 10;

			}

		} else {
			System.out.println("Mã sản phẩm chỉnh sửa không hợp lệ!");
		}
	}

	@Override
	public void deleteProduct(String ID) {
		if (ID.startsWith("Q")) {
			for (int i = 0; i < arrayQuan.length; i++) {
				if (ID.equalsIgnoreCase(arrayQuan[i].getMaHang())) {
					arrayQuan[i] = null;
					break;
				}
			}
			int N = arrayQuan.length - 1;
			Quan quanmoi[] = new Quan[N];
			int j = 0;
			for (Quan quan : arrayQuan) {
				if (quan != null) {

					quanmoi[j] = quan;
					j++;
				}

			}
			arrayQuan = Arrays.copyOf(quanmoi, N);
		} else if (ID.startsWith("A")) {
			for (int i = 0; i < arrayAo.length; i++) {
				if (ID.equalsIgnoreCase(arrayAo[i].getMaHang())) {
					arrayAo[i] = null;
					break;
				}
			}
			int N = arrayAo.length - 1;
			Ao aomoi[] = new Ao[N];
			int j = 0;
			for (Ao ao : arrayAo) {
				if (ao != null) {

					aomoi[j] = ao;
					j++;
				}
			}
			arrayAo = Arrays.copyOf(aomoi, N);

		} else {
			System.out.println("Không có sản phẩm muốn xóa");
		}
		for (Quan c : arrayQuan) {
			System.out.println(c);
		}
		for (Ao c : arrayAo) {
			System.out.println(c);
		}
	}

	public Quan[] getQuanProductList() {
		return this.arrayQuan;
	}

	public Ao[] getAoProductList() {
		return this.arrayAo;
	}

}