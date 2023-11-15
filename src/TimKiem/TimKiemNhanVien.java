package TimKiem;

import NhanVien.FullTime;
import NhanVien.ManagementSystem;
import NhanVien.Manager;
import NhanVien.PartTime;

public class TimKiemNhanVien {
	
	public static void SearchNhanVien(String s2) {
		ManagementSystem managementSystem = new ManagementSystem();
		PartTime[] NVPartTime = managementSystem.getPartTimeList();
		FullTime[] NVFullTime = managementSystem.getFullTimeList();
		Manager[] NVManager = managementSystem.getManagerList();
		while(true) {
			for(PartTime p : NVPartTime) {
				if(s2.equalsIgnoreCase(p.getName())) {
					System.out.println(p);
					return;
				}
			}
			for(FullTime f: NVFullTime) {
				if(s2.equalsIgnoreCase(f.getName())) {
					System.out.println(f);
					return;
				}
			}
			for(Manager m: NVManager) {
				if(s2.equalsIgnoreCase(m.getName())) {
					System.out.println(m);
					return;
				}
			}
			break;
		}
		System.out.println("Không có nhân viên bạn muốn tìm !");
	}

}
