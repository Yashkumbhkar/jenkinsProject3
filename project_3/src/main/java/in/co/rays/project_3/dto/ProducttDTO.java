package in.co.rays.project_3.dto;

public class ProducttDTO extends BaseDTO {
	 
	 private String laptop;
	 private String Box;
	 private String Mobile ;
	public String getLaptop() {
		return laptop;
	}
	public void setLaptop(String laptop) {
		this.laptop = laptop;
	}
	public String getBox() {
		return Box;
	}
	public void setBox(String box) {
		Box = box;
	}
	public String getMobile() {
		return Mobile;
	}
	public void setMobile(String mobile) {
		Mobile = mobile;
	}
	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return null;
	}

}
