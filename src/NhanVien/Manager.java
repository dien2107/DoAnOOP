package NhanVien;

import DiaChi.Address;

public class Manager extends Employee {
	
	private String ChucVu;
	private int exp;
	private double bonus;

	public Manager() {
		
	}
	
	public Manager(String maNV, String name, String age, Address address, int baseSalary, String chucVu, int exp,
			double bonus) {
		super(maNV, name, age, address, baseSalary);
		this.ChucVu = chucVu;
		this.exp = exp;
		this.bonus = bonus;
	}

	@Override
	public double getSalaryAfterCalculating() {
		if(this.getExp() <= 3) {
			return (super.getBaseSalary() + 300) * this.getExp();
		} else if(this.getExp() > 3 && this.getExp()<=6) {
			return (super.getBaseSalary() + 600) * this.getExp();
		} else if(this.getExp() > 6 && this.getExp()<=9) {
			return (super.getBaseSalary() + 900) * this.getExp();
		} else if(this.getExp() > 9 && this.getExp()<=12) {
			return (super.getBaseSalary() + 1200) * this.getExp();
		} else {
			return (super.getBaseSalary() + 1500) * this.getExp();
		}
	}

	public String getChucVu() {
		return ChucVu;
	}

	public void setChucVu(String chucVu) {
		this.ChucVu = chucVu;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

	@Override
	public String toString() {
		return "Manager [" + "MaNV=" + super.getMaNV() + ", Name=" + super.getName() + ", Age=" + super.getAge()
		+ ", " + super.InAddress() + ", baseSalary=" + super.getBaseSalary() + ", exp=" + this.exp + ", bonus=" + this.bonus + ", tienLuong=" + this.getSalaryAfterCalculating() + ", ChucVu=" + this.ChucVu + "]";
	}
	
	
	
		
}
