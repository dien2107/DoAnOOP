package NhanVien;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import ChucNang.ChucNangCoBan;
import ChucNang.ChucNangNhanVien;
import DiaChi.Address;
import SanPham.Quan;

public class ManagementSystem implements ChucNangCoBan,ChucNangNhanVien{
	
	 Manager[] managerList = new Manager[1];
	 FullTime[] fulltimeList = new FullTime[1];
	 PartTime[] parttimeList = new PartTime[1];
	 Scanner sc = new Scanner(System.in);
	 
	 public ManagementSystem() {
		 ReadFile();
	 }
	
	// Quản Lý Nhân Viên
	public void ReadFile() {
		File file = new File("D:\\\\java\\\\DoAnOOP\\\\src\\\\fileNhanVien.txt");
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line;
			while (true) {
				line = br.readLine();
				if (line != null) {
					String[] subInfos = line.split(", ");
					if (subInfos.length == 9) {
						if (parttimeList[0] == null) {
							parttimeList[0] = new PartTime(subInfos[0],
									subInfos[1], subInfos[2],
									new Address(Integer.parseInt(subInfos[3]), subInfos[4], subInfos[5], subInfos[6]),
									Integer.parseInt(subInfos[7]),
									Integer.parseInt(subInfos[8]));}
						else {
							int N = parttimeList.length;
							parttimeList = Arrays.copyOf(parttimeList, N + 1);
							parttimeList[N] = new PartTime(subInfos[0],
									subInfos[1], subInfos[2],
									new Address(Integer.parseInt(subInfos[3]), subInfos[4], subInfos[5], subInfos[6]),
									Integer.parseInt(subInfos[7]),
									Integer.parseInt(subInfos[8]));
						}
					} else if (subInfos.length == 10) {
						if (fulltimeList[0] == null) {
							fulltimeList[0] = new FullTime(subInfos[0],
									subInfos[1], subInfos[2],
									new Address(Integer.parseInt(subInfos[3]), subInfos[4], subInfos[5], subInfos[6]),
									Integer.parseInt(subInfos[7]),
									Integer.parseInt(subInfos[8]), Double.parseDouble(subInfos[9]));}
						else {
							int N = fulltimeList.length;
							fulltimeList = Arrays.copyOf(fulltimeList, N + 1);
							fulltimeList[N] = new FullTime(subInfos[0],
									subInfos[1], subInfos[2],
									new Address(Integer.parseInt(subInfos[3]), subInfos[4], subInfos[5], subInfos[6]),
									Integer.parseInt(subInfos[7]),
									Integer.parseInt(subInfos[8]), Double.parseDouble(subInfos[9]));
						}
					} else {
						if (managerList[0] == null) {
							managerList[0] = new Manager(subInfos[0],
									subInfos[1], subInfos[2],
									new Address(Integer.parseInt(subInfos[3]), subInfos[4], subInfos[5], subInfos[6]),
									Integer.parseInt(subInfos[7]),
									subInfos[8], Integer.parseInt(subInfos[9]), Double.parseDouble(subInfos[10]));}
						else {
							int N = managerList.length;
							managerList = Arrays.copyOf(managerList, N + 1);
							managerList[N] = new Manager(subInfos[0],
									subInfos[1], subInfos[2],
									new Address(Integer.parseInt(subInfos[3]), subInfos[4], subInfos[5], subInfos[6]),
									Integer.parseInt(subInfos[7]),
									subInfos[8], Integer.parseInt(subInfos[9]), Double.parseDouble(subInfos[10]));

						}
					}
				} else {
					break;
				}
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Lỗi load file!");
		}
//		
	}
	
	public void ShowAllList () {
		for (PartTime c : parttimeList) {
			System.out.println(c);
		}
		for (FullTime c : fulltimeList) {
			System.out.println(c);
		}
		for (Manager c : managerList) {
			System.out.println(c);
		}
	}
	
	
	@Override
	public void WriteFile() {
		
		File file = new File("D:\\\\java\\\\DoAnOOP\\\\src\\\\fileNhanVien.txt");
		try {
			FileWriter fileWriter = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fileWriter);
			for(PartTime partTime : parttimeList) {
				bw.write(partTime.getMaNV() + ", "
						+ partTime.getName() + ", "
						+ partTime.getAge() + ", "
						+ partTime.getAddress() + ", "
						+ partTime.getBaseSalary() + ", "
						+ partTime.getCaLam() + "\n");
			}
			for(FullTime fullTime : fulltimeList) {
				bw.write(fullTime.getMaNV() + ", "
						+ fullTime.getName() + ", "
						+ fullTime.getAge() + ", "
						+ fullTime.getAddress() + ", "
						+ fullTime.getBaseSalary() + ", "
						+ fullTime.getExp() + ", "
						+ fullTime.getBonus() + "\n");
			}
			for(Manager manager : managerList) {
				bw.write(manager.getMaNV() + ", "
						+ manager.getName() + ", "
						+ manager.getAge() + ", "
						+ manager.getAddress() + ", "
						+ manager.getBaseSalary() + ", "
						+ manager.getChucVu() + ", "
						+ manager.getExp() + ", "
						+ manager.getBonus() + "\n");
			}
			bw.close();
			System.out.println("Ghi File Thành Công");
		} catch (Exception e) {
			System.out.println("Lỗi");
		}
		
	}
	
	@Override
	public void addEmployee(Object person) {
		if (person instanceof PartTime) {
	        if (parttimeList[0] == null) {
	            parttimeList[0] = (PartTime) person;
	        } else {
	            int n = parttimeList.length;
	            parttimeList = Arrays.copyOf(parttimeList, n + 1);
	            parttimeList[n] = (PartTime) person;
	        }
	    } else if (person instanceof FullTime) {
	        if (fulltimeList[0] == null) {
	            fulltimeList[0] = (FullTime) person;
	        } else {
	            int n = fulltimeList.length;
	            fulltimeList = Arrays.copyOf(fulltimeList, n + 1);
	            fulltimeList[n] = (FullTime) person;
	        }
	    } else if (person instanceof Manager) {
	        if (managerList[0] == null) {
	            managerList[0] = (Manager) person;
	        } else {
	            int n = managerList.length;
	            managerList = Arrays.copyOf(managerList, n + 1);
	            managerList[n] = (Manager) person;
	        }
	    } else {
	        System.out.println("Dữ liệu truyền vào không phù hợp");
	    }
	}
	
	@Override
	public void editEmployee(String ID) {
		int n;
		int index = 0;
		if (ID.startsWith("PT")) {
			for (PartTime c : parttimeList) {
				if (c.getMaNV().equals(ID)) {
					break;
				}
				index++;
			}
			if (index == parttimeList.length) {
				System.out.println("Không có nhân viên trong danh sách!");
				return;
			}
			System.out.println("----------------------------------------------------");
			System.out.println("|            Mời bạn chọn chế độ:                  |");
			System.out.println("|     1:   Sửa Mã Nhân Viên                        |");
			System.out.println("|     2:   Sửa Tên Nhân Viên                       |");
			System.out.println("|     3:   Sửa Tuổi Nhân Viên                      |");
			System.out.println("|     4:   Sửa Địa Chỉ Nhân Viên                   |");
			System.out.println("|     5:   Sửa Lương Nhân Viên                     |");
			System.out.println("|     6:   Sửa Ca Làm Việc Của Nhân Viên           |");
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
						System.out.print("Nhập mã nhân viên thay thế: ");
						parttimeList[index].setMaNV(sc.nextLine());
						break;
					case 2:
						System.out.print("Nhập tên nhân viên thay thế: ");
						parttimeList[index].setName(sc.nextLine());
						break;
					case 3:
						System.out.print("Nhập tuổi nhân viên thay thế: ");
						parttimeList[index].setAge(sc.nextLine());
						break;
					case 4:
						System.out.println("Nhâp địa chỉ nhân viên thay thế:");
						System.out.print("+Số nhà: ");
						int sonha = Integer.parseInt(sc.nextLine());
						System.out.print("+Tên đường: ");
						String street = sc.nextLine();
						System.out.print("+Quận/huyện: ");
						String district = sc.nextLine();
						System.out.print("Thành phố/Tỉnh: ");
						String city = sc.nextLine();
						Address tmpAddress = new Address(sonha, street, district, city);
						parttimeList[index].setAddress(tmpAddress);
						break;
					case 5:
						System.out.print("Sửa lương: ");
						parttimeList[index].setBaseSalary(Integer.parseInt(sc.nextLine()));
						break;
					case 6:
						System.out.print("Sửa ca làm: ");
						parttimeList[index].setCaLam(Integer.parseInt(sc.nextLine()));
						break;
					default:
						break;
				}
				n /= 10;

			}

		} else if (ID.startsWith("FT")) {
			for (FullTime c : fulltimeList) {
				if (c.getMaNV().equals(ID)) {
					break;
				}
				index++;
			}
			if (index == fulltimeList.length) {
				System.out.println("Không có nhân viên trong danh sách!");
				return;
			}
			System.out.println("----------------------------------------------------");
			System.out.println("|            Mời bạn chọn chế độ:                  |");
			System.out.println("|     1:   Sửa Mã Nhân Viên                        |");
			System.out.println("|     2:   Sửa Tên Nhân Viên                       |");
			System.out.println("|     3:   Sửa Tuổi Nhân Viên                      |");
			System.out.println("|     4:   Sửa Địa Chỉ Nhân Viên                   |");
			System.out.println("|     5:   Sửa Lương Nhân Viên                     |");
			System.out.println("|     6:   Sửa Số Năm Kinh Nghiệm Của Nhân Viên    |");
			System.out.println("|     7:   Sửa Thưởng Thêm Của Nhân Viên           |");
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
						System.out.print("Nhập mã nhân viên thay thế: ");
						fulltimeList[index].setMaNV(sc.nextLine());
						break;
					case 2:
						System.out.print("Nhập tên nhân viên thay thế: ");
						fulltimeList[index].setName(sc.nextLine());
						break;
					case 3:
						System.out.print("Nhập tuổi nhân viên thay thế: ");
						fulltimeList[index].setAge(sc.nextLine());
						break;
					case 4:
						System.out.println("Nhâp địa chỉ nhân viên thay thế:");
						System.out.print("+Số nhà: ");
						int sonha = Integer.parseInt(sc.nextLine());
						System.out.print("+Tên đường: ");
						String street = sc.nextLine();
						System.out.print("+Quận/huyện: ");
						String district = sc.nextLine();
						System.out.print("Thành phố/Tỉnh: ");
						String city = sc.nextLine();
						Address tmpAddress = new Address(sonha, street, district, city);
						fulltimeList[index].setAddress(tmpAddress);
						break;
					case 5:
						System.out.print("Sửa lương: ");
						fulltimeList[index].setBaseSalary(Integer.parseInt(sc.nextLine()));
						break;
					case 6:
						System.out.print("Sửa số năm kinh nghiệm: ");
						fulltimeList[index].setExp(Integer.parseInt(sc.nextLine()));
						break;
					case 7:
						System.out.print("Sửa thưởng thêm: ");
						fulltimeList[index].setBonus(Double.parseDouble(sc.nextLine()));
						break;
					default:
						break;
				}
				n /= 10;

			}

		} else if (ID.startsWith("MN")) {
			for (Manager c : managerList) {
				if (c.getMaNV().equals(ID)) {
					break;
				}
				index++;
			}
			if (index == managerList.length) {
				System.out.println("Không có nhân viên trong danh sách!");
				return;
			}
			System.out.println("----------------------------------------------------");
			System.out.println("|            Mời bạn chọn chế độ:                  |");
			System.out.println("|     1:   Sửa Mã Nhân Viên                        |");
			System.out.println("|     2:   Sửa Tên Nhân Viên                       |");
			System.out.println("|     3:   Sửa Tuổi Nhân Viên                      |");
			System.out.println("|     4:   Sửa Địa Chỉ Nhân Viên                   |");
			System.out.println("|     5:   Sửa Lương Nhân Viên                     |");
			System.out.println("|     6:   Sửa Số Năm Kinh Nghiệm Của Nhân Viên    |");
			System.out.println("|     7:   Sửa Thưởng Thêm Của Nhân Viên           |");
			System.out.println("|     8:   Sửa Chức Vụ Của Nhân Viên               |");
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
						System.out.print("Nhập mã nhân viên thay thế: ");
						managerList[index].setMaNV(sc.nextLine());
						break;
					case 2:
						System.out.print("Nhập tên nhân viên thay thế: ");
						managerList[index].setName(sc.nextLine());
						break;
					case 3:
						System.out.print("Nhập tuổi nhân viên thay thế: ");
						managerList[index].setAge(sc.nextLine());
						break;
					case 4:
						System.out.println("Nhâp địa chỉ nhân viên thay thế:");
						System.out.print("+Số nhà: ");
						int sonha = Integer.parseInt(sc.nextLine());
						System.out.print("+Tên đường: ");
						String street = sc.nextLine();
						System.out.print("+Quận/huyện: ");
						String district = sc.nextLine();
						System.out.print("Thành phố/Tỉnh: ");
						String city = sc.nextLine();
						Address tmpAddress = new Address(sonha, street, district, city);
						managerList[index].setAddress(tmpAddress);
						break;
					case 5:
						System.out.print("Sửa lương: ");
						managerList[index].setBaseSalary(Integer.parseInt(sc.nextLine()));
						break;
					case 6:
						System.out.print("Sửa số năm kinh nghiệm: ");
						managerList[index].setExp(Integer.parseInt(sc.nextLine()));
						break;
					case 7:
						System.out.print("Sửa thưởng thêm: ");
						managerList[index].setBonus(Double.parseDouble(sc.nextLine()));
						break;
					case 8:
						System.out.print("Sửa chức vụ: ");
						managerList[index].setChucVu(sc.nextLine());
						break;
					default:
						break;
				}
				n /= 10;

			}
		} else {
			System.out.println("Mã Nhân Viên chỉnh sửa không hợp lệ!");
		}
	}
	@Override
	public void deleteEmployee(String ID) {
	    if (ID.startsWith("PT")) {
	        for (int i = 0; i < parttimeList.length; i++) {
	            if (ID.equalsIgnoreCase(parttimeList[i].getMaNV())) {
	                parttimeList[i] = null;
	                break;
	            }
	        }
	        int N = parttimeList.length - 1;
	        PartTime pt[] = new PartTime[N];
	        int j = 0;
	        for (PartTime p : parttimeList) {
	            if (p != null) {
	                pt[j] = p;
	                j++;
	            }
	        }
	        parttimeList = Arrays.copyOf(pt, N);
	    } else if (ID.startsWith("FT")) {
	        for (int i = 0; i < fulltimeList.length; i++) {
	            if (ID.equalsIgnoreCase(fulltimeList[i].getMaNV())) {
	                fulltimeList[i] = null;
	                break;
	            }
	        }
	        int N = fulltimeList.length - 1;
	        FullTime ft[] = new FullTime[N];
	        int j = 0;
	        for (FullTime f : fulltimeList) {
	            if (f != null) {
	                ft[j] = f;
	                j++;
	            }
	        }
	        fulltimeList = Arrays.copyOf(ft, N);
	    } else if (ID.startsWith("MN")) {
	        for (int i = 0; i < managerList.length; i++) {
	            if (ID.equalsIgnoreCase(managerList[i].getMaNV())) {
	                managerList[i] = null;
	                break;
	            }
	        }
	        int N = managerList.length - 1;
	        Manager mn[] = new Manager[N];
	        int j = 0;
	        for (Manager m : managerList) {
	            if (m != null) {
	                mn[j] = m;
	                j++;
	            }
	        }
	        managerList = Arrays.copyOf(mn, N);
	    } else {
	        System.out.println("Mã Nhân Viên xóa không hợp lệ!");
	    }

	    for (PartTime c : parttimeList) {
	        if (c != null) {
	            System.out.println(c);
	        }
	    }
	    for (FullTime c : fulltimeList) {
	        if (c != null) {
	            System.out.println(c);
	        }
	    }
	    for (Manager c : managerList) {
	        if (c != null) {
	            System.out.println(c);
	        }
	    }
	}

	public FullTime[] getFullTimeList () {
		return this.fulltimeList;
	}
	
	public PartTime[] getPartTimeList () {
		return this.parttimeList;
	}
	
	public Manager[] getManagerList () {
		return this.managerList;
	}
	

}
