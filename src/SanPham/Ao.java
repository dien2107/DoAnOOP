package SanPham;

public class Ao extends Product {

	private String size;
	
	public Ao(String maHang, String ten, String descript, String color, long gia, int soluong, String size) {
		super(maHang, ten, descript, color, gia, soluong);
		this.size = size;
	}


	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}
	
	@Override
	public String toString() {
		return "Ao [ MaHang=" + super.getMaHang() + ", ten=" + super.getTen() + ", descript=" + super.getDescript() + ", color="
				+ super.getColor() + ", gia=" + super.getGia() + ", size=" + this.getSize() + ", soluong=" + super.getSoluong() +  "]";
	}
	
	
	
}
