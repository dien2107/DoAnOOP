package QuanLyBanQuanAo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

import CuaHang.ThongKe;
import DiaChi.Address;
import KhachHang.Customer;
import MuaSanPham.HoaDon;
import MuaSanPham.MuaHang;
import NhanVien.FullTime;
import NhanVien.ManagementSystem;
import NhanVien.Manager;
import NhanVien.PartTime;
import NhapHang.PhieuNhapHang;
import SanPham.Ao;
import SanPham.Discount;
import SanPham.ManagementSystemProduct;
import SanPham.Quan;
import TimKiem.TimKiemNhanVien;
import TimKiem.TimKiemSanPham;

public class Menu {

	public static void menu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("----------------------------------------------------");
		System.out.println("|            Mời bạn chọn chế độ:                  |");
		System.out.println("|     1:   Admin                                   |");
		System.out.println("|     2:   Customer                                |");
		System.out.println("----------------------------------------------------");
		System.out.println();
		System.out.print("Mời bạn chọn:");
		int choice = Integer.parseInt(sc.nextLine());
		while (choice != 1 && choice != 2) {
			System.out.println("Lựa chọn không phù hợp");
			System.out.print("Mời bạn chọn lại:");
			choice = Integer.parseInt(sc.nextLine());
		}
		if (choice == 1) {
			System.out.println("----------------------------------------------------");
			System.out.println("|            Mời bạn chọn chế độ:                  |");
			System.out.println("|     1:   Thêm Sản Phẩm Mới                       |");
			System.out.println("|     2:   Sửa Sản Phẩm                            |");
			System.out.println("|     3:   Xóa Sản Phẩm                            |");
			System.out.println("|     4:   Thêm Nhân Viên Mới                      |");
			System.out.println("|     5:   Sửa Nhân Viên                           |");
			System.out.println("|     6:   Xóa Nhân Viên                           |");
			System.out.println("|     7:   Xem Thông Tin Sản Phẩm                  |");
			System.out.println("|     8:   Xem Thông Tin Nhân Viên                 |");
			System.out.println("|     9:   Xem Số Liệu Thống Kê                    |");
			System.out.println("|     10:  Tìm Kiếm Sản Phẩm                       |");
			System.out.println("|     11:  Tìm Kiếm Nhân Viên                      |");
			System.out.println("|     12:  Xem Danh Sách Nhập Hàng                 |");
			System.out.println("|     13:  Xem hóa đơn                             |");
			System.out.println("|     14:  Thoát                                   |");
			System.out.println("----------------------------------------------------");
			System.out.println();
			System.out.print("Mời bạn chọn:");
			int choice2 = Integer.parseInt(sc.nextLine());
			while (choice2 < 1 || choice2 > 14) {
				System.out.println("Lựa chọn không phù hợp");
				System.out.print("Mời bạn chọn lại:");
				choice2 = Integer.parseInt(sc.nextLine());
			}
			String timkiem, ID;
			ManagementSystem managementSystem = new ManagementSystem();
			ManagementSystemProduct managementSystemProduct = new ManagementSystemProduct();
			switch (choice2) {
				case 1:
					String maHang, ten, descript, color;
					long gia;
					int soluong;
					while (true) {
						System.out.println("Nhập sản phẩm muốn thêm (áo | quần | nhập 'end' để thoát): ");
						timkiem = sc.nextLine();
						if (timkiem.equalsIgnoreCase("end")) {
							System.out.println("Đã Thoát!");
							break;
						} else if (timkiem.startsWith("Ao") || timkiem.startsWith("ao") || timkiem.startsWith("Áo")
								|| timkiem.startsWith("áo")) {
							String size;
							System.out.println("Nhập mã sản phẩm: ");
							maHang = sc.nextLine();
							System.out.println("Nhập tên sản phẩm: ");
							ten = sc.nextLine();
							System.out.println("Nhập mô tả sản phẩm: ");
							descript = sc.nextLine();
							System.out.println("Nhập giá sản phẩm: ");
							gia = Long.parseLong(sc.nextLine());
							System.out.println("Nhập màu sản phẩm: ");
							color = sc.nextLine();
							System.out.println("Nhập số lượng sản phẩm: ");
							soluong = Integer.parseInt(sc.nextLine());
							System.out.println("Nhập kích thước: ");
							size = sc.nextLine();
							Ao spAoMoi = new Ao(maHang, ten, descript, color, gia, soluong, size);
							managementSystemProduct.addProduct(spAoMoi);
						} else if (timkiem.equalsIgnoreCase("quần")) {
							int size;
							System.out.println("Nhập mã sản phẩm: ");
							maHang = sc.nextLine();
							System.out.println("Nhập tên sản phẩm: ");
							ten = sc.nextLine();
							System.out.println("Nhập mô tả sản phẩm: ");
							descript = sc.nextLine();
							System.out.println("Nhập giá sản phẩm: ");
							gia = Long.parseLong(sc.nextLine());
							System.out.println("Nhập màu sản phẩm: ");
							color = sc.nextLine();
							System.out.println("Nhập số lượng sản phẩm: ");
							soluong = Integer.parseInt(sc.nextLine());
							System.out.println("Nhập kích thước: ");
							size = Integer.parseInt(sc.nextLine());
							Quan spQuanmoi = new Quan(maHang, ten, descript, color, gia, soluong, size);
							managementSystemProduct.addProduct(spQuanmoi);
						} else {
							System.out.println("Sản Phẩm thêm vào không hợp lệ!");
							break;
						}
					}
					break;
				case 2:
					while (true) {
						System.out.println("Nhập mã sản phẩm muốn sửa (nhập 'end' để thoát) : ");
						ID = sc.nextLine();
						if (ID.equalsIgnoreCase("end")) {
							System.out.println("Đã Thoát!");
							break;
						} else {
							managementSystemProduct.editProduct(ID);
						}
					}
					break;
				case 3:
					while (true) {
						System.out.println("Nhập mã sản phẩm muốn xóa (nhập 'end' để thoát) : ");
						ID = sc.nextLine();
						if (ID.equalsIgnoreCase("end")) {
							System.out.println("Đã Thoát!");
							break;
						} else {
							managementSystemProduct.deleteProduct(ID);
						}
					}
					break;
				case 4:
					while (true) {
					    System.out.println("Nhân viên bạn muốn thêm vào (parttime|fulltime|manager|nhập 'end' để thoát):");
					    timkiem = sc.nextLine();
					    if (timkiem.equalsIgnoreCase("end")) {
					        System.out.println("Đã Thoát!");
					        break;
					    } 
					    String maNV, name, age;
					    int baseSalary, aNumber;
					    String street, district, city;
					    System.out.println("Nhập Mã NV: ");
					    maNV = sc.nextLine();
					    System.out.println("Nhập tên: ");
					    name = sc.nextLine();
					    System.out.println("Nhập tuổi: ");
					    age = sc.nextLine();
					    System.out.println("Nhập lương cơ bản: ");
					    baseSalary = Integer.parseInt(sc.nextLine());
					    System.out.println("Nhập số nhà: ");
					    aNumber = Integer.parseInt(sc.nextLine());
					    System.out.println("Nhập tên đường: ");
					    street = sc.nextLine();
					    System.out.println("Nhập quận/huyện: ");
					    district = sc.nextLine();
					    System.out.println("Nhập thành phố/ tỉnh: ");
					    city = sc.nextLine();
					    if (timkiem.equalsIgnoreCase("parttime")) {
					        int caLamViec;
					        System.out.println("Nhập ca Làm việc: ");
					        caLamViec = Integer.parseInt(sc.nextLine());
					        PartTime ptime = new PartTime(maNV, name, age, new Address(aNumber, street, district, city),
					            baseSalary, caLamViec);
					        managementSystem.addEmployee(ptime);
					        System.out.println("Thêm Thành Công !");
					    } else if (timkiem.equalsIgnoreCase("fulltime")) {
					        int exp;
					        double bonus;
					        System.out.println("Nhập năm kinh nghiệm: ");
					        exp = Integer.parseInt(sc.nextLine());
					        System.out.println("Nhập thưởng thêm: ");
					        bonus = Double.parseDouble(sc.nextLine());
					        FullTime ftime = new FullTime(maNV, name, age, new Address(aNumber, street, district, city),
					            baseSalary, exp, bonus);
					        managementSystem.addEmployee(ftime);
					        System.out.println("Thêm Thành Công !");
					    } else if (timkiem.equalsIgnoreCase("manager")) {
					        int exp;
					        double bonus;
					        String chucVu;
					        System.out.println("Nhập năm kinh nghiệm: ");
					        exp = Integer.parseInt(sc.nextLine());
					        System.out.println("Nhập thưởng thêm: ");
					        bonus = Double.parseDouble(sc.nextLine());
					        System.out.println("Nhập Chức Vụ Quản Lý: ");
					        chucVu = sc.nextLine();
					        Manager mger = new Manager(maNV, name, age, new Address(aNumber, street, district, city),
					            baseSalary, chucVu, exp, bonus);
					        managementSystem.addEmployee(mger);
					        System.out.println("Thêm Thành Công !");
					    } else {
					        System.out.println("Không có chức vụ này");
					        break;
					    }
					}
					break;
				case 5:
					while (true) {
						System.out.println("Nhập mã nhân viên muốn xóa (nhập 'end' để thoát) : ");
						ID = sc.nextLine();
						if (ID.equalsIgnoreCase("end")) {
							System.out.println("Đã Thoát!");
							break;
						} else {
							managementSystem.editEmployee(ID);
						}
					}
                    break;
				case 6:
					while (true) {
						System.out.println("Nhập mã nhân viên bạn muốn xóa (nhập 'end' để thoát)");
						timkiem = sc.nextLine();
						if (timkiem.equalsIgnoreCase("end")) {
							System.out.println("Đã Thoát!");
							break;
						} else {
							managementSystem.deleteEmployee(timkiem);
						}
					}
					break;
				case 7:
					managementSystemProduct.showAllListProduct();
					break;
				case 8:
					managementSystem.ShowAllList();
					break;
				case 9:
					System.out.println("Xem Thống Kê");
					ThongKe tk = new ThongKe();
					tk.ShowThongKe();
					break;
				case 10:
					while (true) {
						System.out.println("Nhập sản phẩm bạn muốn tìm (nhập 'end' để thoát) : ");
						timkiem = sc.nextLine();
						if (timkiem.equalsIgnoreCase("end")) {
							System.out.println("Đã Thoát !");
							break;
						} else {
							TimKiemSanPham.SearchSanPham(timkiem);
						}
					}
					break;
				case 11:
					while (true) {
						System.out.println("Nhập tên nhân viên muốn tìm (nhập 'end' để thoát) : ");
						timkiem = sc.nextLine();
						if (timkiem.equalsIgnoreCase("end")) {
							System.out.println("Đã Thoát !");
							break;
						} else {
							TimKiemNhanVien.SearchNhanVien(timkiem);
						}
					}
					break;
				case 12:
					System.out.println("Xem Danh Sách Nhập Hàng");
					PhieuNhapHang pnh = new PhieuNhapHang();
					System.out.println("Dữ liệu nhập hàng:");
					pnh.NhapHang();
					managementSystemProduct = pnh.Update();
					System.out.println("Sau khi nhập hàng:");
					managementSystemProduct.showAllListProduct();
					break;
				case 13:
					System.out.println("Xem hóa đơn");
					HoaDon hd = new HoaDon();
					hd.ReadFile();
					break;
				case 14:
					System.out.println("Đã Thoát!!!");
					break;
				default:
					System.out.println("Không có dữ liệu !");
			}
			// managementSystemProduct.WriteFile();
			// managementSystem.WriteFile();
			// admin mode
			/*
			 * thêm sản phẩm
			 * sửa sản phẩm
			 * xóa sản phẩm
			 * thêm nhân viên
			 * sửa nhân viên
			 * xóa nhân viên
			 * xem danh sách nhân viên
			 * xem danh sách sản phẩm
			 * xem số liệu thống kê (doanh thu , sản phẩm bán chạy,...)
			 * tìm kiếm
			 */
			managementSystem.WriteFile();
			managementSystemProduct.WriteFile();
		} else {
			File file = new File("D:\\java\\DoAnOOP\\src\\fileKhachHang.txt");
			Customer[] KHs = new Customer[1];
			try {
				BufferedReader br = new BufferedReader(new FileReader(file));
				String line;
				while ((line = br.readLine()) != null) {
					String[] infos = line.split(", ");
					if (KHs[0] == null) {
						KHs[0] = new Customer(
								infos[0],
								infos[1],
								infos[2],
								new Address(
										Integer.parseInt(
												infos[3]),
										infos[4],
										infos[5],
										infos[6]),
								Integer.parseInt(infos[7]), infos[8]);
					}else {
						int N = KHs.length;
						KHs = Arrays.copyOf(KHs, N+1);
						KHs[N] = new Customer(
								infos[0],
								infos[1],
								infos[2],
								new Address(
										Integer.parseInt(
												infos[3]),
										infos[4],
										infos[5],
										infos[6]),
								Integer.parseInt(infos[7]), infos[8]);
					}
				}
				br.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
			// Customer khachhang = new Customer(null, null, choice, null, choice);
			System.out.print("\nMời bạn nhập mã khách hàng (kiểm tra đăng nhập): ");
			String maKhachHang = sc.nextLine();
			Customer cus = new Customer();
			boolean flag = false;
			for (Customer customer : KHs) {
				if (customer.getMaKhachHang().equals(maKhachHang)) {
					cus = customer;
					flag = true;
					break;
				}
			}
			if (flag == false) {
				cus.setMaKhachHang("KH" + (KHs.length+1));
				System.out.print("Nhập tên: ");
				cus.setTen(sc.nextLine());
				System.out.print("Nhập tuổi: ");
				cus.setTuoi(Integer.parseInt(sc.nextLine()));
				System.out.print("Nhập số điện thoại: ");
				cus.setPhoneNumber(sc.nextLine());
				System.out.print("Nhập số nhà: ");
				int aNumberKH = Integer.parseInt(sc.nextLine());
				System.out.print("Nhập tên đường: ");
				String streetKH = sc.nextLine();
				System.out.print("Nhập quận/huyện: ");
				String districtKH = sc.nextLine();
				System.out.print("Nhập thành phố/ tỉnh: ");
				String cityKH = sc.nextLine();
				cus.setDiaChi(new Address(aNumberKH, streetKH, districtKH, cityKH));
				System.out.print("Nhập level(Vang,Bac,Dong): ");
				cus.setLVKhachHang(sc.nextLine());

				try {
					FileWriter fw = new FileWriter(file, true);
					BufferedWriter bw = new BufferedWriter(fw);
					PrintWriter pw = new PrintWriter(bw);
					pw.println(cus.getMaKhachHang() + ", " + cus.getTen() + ", " + cus.getPhoneNumber() + ","
							+ cus.getDiaChi() + ", " + cus.getTuoi() + ", " + cus.getLVKhachHang());
					pw.close();
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			// System.out.print("Nhập ");
			// customer mode
			System.out.println("----------------------------------------------------");
			System.out.println("|            Mời bạn chọn chế độ:                  |");
			System.out.println("|     1:   Xem Sản Phẩm                            |");
			System.out.println("|     2:   Tìm Kiếm Sản Phẩm                       |");
			System.out.println("|     3:   Mua Hàng                                |");
			System.out.println("|     4:   Thoát                                   |");
			System.out.println("----------------------------------------------------");
			System.out.println();
			System.out.print("Mời bạn chọn:");
			int choice3 = Integer.parseInt(sc.nextLine());
			while (choice3 < 1 || choice3 > 4) {
				System.out.println("Lựa chọn không phù hợp");
				System.out.print("Mời bạn chọn lại:");
				choice3 = Integer.parseInt(sc.nextLine());
			}
			String timkiem;
			ManagementSystemProduct managementSystemProduct = new ManagementSystemProduct();
			switch (choice3) {
				case 1:
					managementSystemProduct.showAllListProduct();
					break;
				case 2:
					while (true) {
						System.out.println("Nhập sản phẩm bạn muốn tìm (nhập 'end' để thoát) : ");
						timkiem = sc.nextLine();
						if (timkiem.equalsIgnoreCase("end")) {
							System.out.println("Đã Thoát !");
							break;
						} else {
							TimKiemSanPham.SearchSanPham(timkiem);
						}
					}
					break;
				case 3:
					managementSystemProduct.showAllListProduct();
					System.out.println();
					System.out.println("Mua hàng ");
					String maSPs[] = new String[1];
					int sl[] = new int[1];
					Long TongTien = new Long(0);
					while (true) {
						System.out.println("Nhập mã sản phẩm bạn muốn mua (nhập 'end' để thoát hoặc xuất hóa đơn) : ");
						String maSP = sc.nextLine();
						if (maSP.equalsIgnoreCase("end")) {
							System.out.println("Đã Thoát !");
							break;
						} else {
							System.out.print("Nhập số lượng: ");
							int soluong = Integer.parseInt(sc.nextLine());
							MuaHang muaHang = new MuaHang(managementSystemProduct);
							Long tmp1 = muaHang.MuaSanPham(maSP, soluong);
							if (tmp1 != null) {
								TongTien += tmp1;
								if (maSPs[0] == null) {
									maSPs[0] = maSP;
									sl[0] = soluong;
								} else {
									int N = maSPs.length;
									maSPs = Arrays.copyOf(maSPs, N + 1);
									sl = Arrays.copyOf(sl, N + 1);
									maSPs[N] = maSP;
									sl[N] = soluong;
								}
							}
							managementSystemProduct = muaHang.capnhapSLSP();
							managementSystemProduct.showAllListProduct();

						}

					}
					if (maSPs[0] != null) {

						double Tien = Discount.GiamGiaSanPham(cus.getLVKhachHang(), TongTien);
						HoaDon hd = new HoaDon(cus.getTen(), maSPs, sl, Tien);
						hd.InHoaDon();
						hd.WriteFile();
					}
					break;
				case 4:
					System.out.println("Đã Thoát!!!");

					break;
				default:
					System.out.println("Không có dữ liệu!");
			}
			/*
			 * xem danh sách sản phẩm
			 * tìm kiếm sản phẩm
			 * mua hàng
			 */
			managementSystemProduct.WriteFile();
		}
	}

}
