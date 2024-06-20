package in.co.rays.project_3.dto;

public class AddressDTO extends BaseDTO {

	 private String address ;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return address;
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return address;
	}
}
