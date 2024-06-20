package in.co.rays.project_3.dto;

public class StatusDTO extends BaseDTO {

	 
	 private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return status;
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return status;
	}
}
