package SanPham;

public class Quan extends Product{
	private int size;
	
	public Quan(String maHang, String ten, String descript, String color, long gia, int soluong, int size) {
		super(maHang, ten, descript, color, gia, soluong);
		this.size = size;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	@Override
	public String toString() {
		return "Quan [ MaHang=" + super.getMaHang() + ", ten=" + super.getTen() + ", descript=" + super.getDescript() + ", color="
				+ super.getColor() + ", gia=" + super.getGia() + ", size=" + this.getSize() + ", soluong=" + super.getSoluong() +  "]";
	}
	
}
