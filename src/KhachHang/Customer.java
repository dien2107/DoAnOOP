package KhachHang;

import DiaChi.Address;

public class Customer {

	private String MaKhachHang;
	private String ten;
	private String phoneNumber;
	private Address DiaChi;
	private int tuoi;
	private String LVKhachHang;

	public Customer() {

	}

	public Customer(String maKhachHang, String ten, String phoneNumber, Address diaChi, int tuoi, String LVKhachHang) {
		this.MaKhachHang = maKhachHang;
		this.ten = ten;
		this.phoneNumber = phoneNumber;
		this.DiaChi = diaChi;
		this.tuoi = tuoi;
		this.LVKhachHang = LVKhachHang;
	}

	public String getMaKhachHang() {
		return MaKhachHang;
	}

	public void setMaKhachHang(String maKhachHang) {
		this.MaKhachHang = maKhachHang;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Address getDiaChi() {
		return DiaChi;
	}

	public void setDiaChi(Address diaChi) {
		this.DiaChi = diaChi;
	}

	public int getTuoi() {
		return tuoi;
	}

	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}

	public String getLVKhachHang() {
		return LVKhachHang;
	}

	public void setLVKhachHang(String lVKhachHang) {
		this.LVKhachHang = lVKhachHang;
	}

	@Override
	public String toString() {
		return "Thông Tin Khách Hàng [" + this.MaKhachHang + ", " + this.ten + ", " + this.tuoi + ", "
				+ this.DiaChi.output() + ", " + this.phoneNumber + "Cấp Bậc: " + this.LVKhachHang + "]";
	}

}