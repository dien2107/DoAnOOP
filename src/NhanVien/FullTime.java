package NhanVien;

import DiaChi.Address;

public class FullTime extends Employee {

	private int exp;
	private double bonus;
	
	public FullTime() {
		
	}
	
	public FullTime(String maNV, String name, String age, Address address, int baseSalary, int exp,double bonus) {
		super(maNV, name, age, address, baseSalary);
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

	public int getExp() {
		return this.exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public double getBonus() {
		return this.bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

	@Override
	public String toString() {
		return "FullTime [" + "MaNV=" + super.getMaNV() + ", Name=" + super.getName() + ", Age=" + super.getAge()
				+ ", " + super.InAddress() + ", baseSalary=" + super.getBaseSalary() + ", exp=" + this.exp + ", bonus=" + this.bonus + ", tienLuong=" + this.getSalaryAfterCalculating() + "]";
	}	
	
	
}
