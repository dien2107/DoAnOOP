package SanPham;

public class Product {
	
	private String MaHang;
	private String ten;
	private String descript;
	private String color;
	private long gia;
	private int soluong;
	
	public Product(String maHang, String ten, String descript, String color, long gia, int soluong) {
		super();
		this.MaHang = maHang;
		this.ten = ten;
		this.descript = descript;
		this.color = color;
		this.gia = gia;
		this.soluong = soluong;
	}

	public String getMaHang() {
		return this.MaHang;
	}

	public void setMaHang(String maHang) {
		this.MaHang = maHang;
	}

	public String getTen() {
		return this.ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getDescript() {
		return this.descript;
	}

	public void setDescript(String descript) {
		this.descript = descript;
	}

	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public long getGia() {
		return this.gia;
	}

	public void setGia(long gia) {
		this.gia = gia;
	}

	public int getSoluong() {
		return this.soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	
}
