package NhanVien;

import java.util.Scanner;

import DiaChi.Address;

public abstract class Employee {

	private String MaNV;
	private String Name;
	private String Age;
	private Address address;
	private int baseSalary;
	Scanner sc = new Scanner(System.in);
	
	public Employee() {
		
	}
	
	
	public Employee(String maNV, String name, String age, Address address, int baseSalary) {
		this.MaNV = maNV;
		this.Name = name;
		this.Age = age;
		this.address = address;
		this.baseSalary = baseSalary;
	}	
	
	//Hàm này dùng để tính lương cuối cùng sau khi đã cộng các tiền ngoài (như: thưởng thêm, trợ cấp, bla bla, ...) nếu có
	public abstract double getSalaryAfterCalculating();

	public String getMaNV() {
		return MaNV;
	}

	public void setMaNV(String maNV) {
		this.MaNV = maNV;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		this.Name = name;
	}

	public String getAge() {
		return Age;
	}

	public void setAge(String age) {
		this.Age = age;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public int getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(int baseSalary) {
		this.baseSalary = baseSalary;
	}
	
	public String InAddress() {
		return this.address.output();
	}
	
}
