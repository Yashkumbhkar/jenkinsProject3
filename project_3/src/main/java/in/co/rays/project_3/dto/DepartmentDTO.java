package in.co.rays.project_3.dto;

public class DepartmentDTO extends BaseDTO {
	
	 private String department ;

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return department;
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return department;
	}

}
