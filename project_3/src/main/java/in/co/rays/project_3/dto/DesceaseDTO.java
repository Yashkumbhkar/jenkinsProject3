package in.co.rays.project_3.dto;

public class DesceaseDTO extends BaseDTO {
	
	 public String getDesCeaseDTO() {
		return desCeaseDTO;
	}

	public void setDesCeaseDTO(String desCeaseDTO) {
		this.desCeaseDTO = desCeaseDTO;
	}

	private String desCeaseDTO ;

	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return desCeaseDTO;
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return desCeaseDTO;
	} 

}
