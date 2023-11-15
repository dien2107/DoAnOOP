package NhanVien;

import DiaChi.Address;

public class PartTime extends Employee {
	
	private int caLamViec;
	
	public PartTime() {
		
	}

	public PartTime(String maNV, String name, String age, Address address, int baseSalary, int caLamViec) {
		super(maNV, name, age, address, baseSalary);
		this.caLamViec = caLamViec;
	}

	@Override
	public double getSalaryAfterCalculating() {
		return super.getBaseSalary() + (this.getCaLam()/100)*super.getBaseSalary();
	}

	public int getCaLam() {
		return caLamViec;
	}

	public void setCaLam(int caLam) {
		this.caLamViec = caLam;
	}

	@Override
	public String toString() {
		return "PartTime [" + "MaNV=" + super.getMaNV() + ", Name=" + super.getName() + ", Age=" + super.getAge()
		+ ", " + super.InAddress() + ", baseSalary=" + super.getBaseSalary() + ", caLamViec=" + this.caLamViec + ", tienLuong=" + this.getSalaryAfterCalculating() + "]";
	}
	
	
	
}
