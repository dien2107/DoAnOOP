package DiaChi;

public class Address {
	
	private int aNumber;
	private String street;
	private String district;
	private String city;
	
	public Address(int aNumber, String street, String district, String city) {
		this.aNumber = aNumber;
		this.street = street;
		this.district = district;
		this.city = city;
	}
	
	public String output () {
		return "Địa chỉ: " + aNumber + "/ " + street + "/ " + district + "/ " + city ;
	}

	@Override
	public String toString() {
		return aNumber + ", " + street + ", " + district + ", " + city ;
	}

}
