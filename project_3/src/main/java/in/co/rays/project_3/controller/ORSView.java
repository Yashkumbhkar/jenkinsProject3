package in.co.rays.project_3.controller;

public interface ORSView {
	public String APP_CONTEXT = "/project_3";

	public String PAGE_FOLDER = "/jsp";

	public String JAVA_DOC_VIEW = APP_CONTEXT + "/doc/index.html";

	public String ERROR_VIEW = PAGE_FOLDER + "/ErrorView404.jsp";
	public String Employee_VIEW = PAGE_FOLDER + "/EmployeeView.jsp";
	public String Employee_LIST_VIEW = PAGE_FOLDER + "/EmployeeListView.jsp";
	
	public String PATIENT_VIEW = PAGE_FOLDER + "/PatientView.jsp";
	public String PATIENT_LIST_VIEW = PAGE_FOLDER + "/PatientListView.jsp";


	public String BANK_VIEW = PAGE_FOLDER + "/BankView.jsp";
	public String BANK_LIST_VIEW = PAGE_FOLDER + "/BankListView.jsp";
	public String MARKSHEET_VIEW = PAGE_FOLDER + "/MarksheetView.jsp";

	public String MARKSHEET_LIST_VIEW = PAGE_FOLDER + "/MarksheetListView.jsp";
	public String GET_MARKSHEET_VIEW = PAGE_FOLDER + "/GetMarksheetView.jsp";
	public String USER_VIEW = PAGE_FOLDER + "/UserView.jsp";
	public String USER_LIST_VIEW = PAGE_FOLDER + "/UserListView.jsp";
	public String COLLEGE_VIEW = PAGE_FOLDER + "/CollegeView.jsp";
	public String COLLEGE_LIST_VIEW = PAGE_FOLDER + "/CollegeListView.jsp";
	public String STUDENT_VIEW = PAGE_FOLDER + "/StudentView.jsp";
	public String STUDENT_LIST_VIEW = PAGE_FOLDER + "/StudentListView.jsp";
	public String ROLE_VIEW = PAGE_FOLDER + "/RoleView.jsp";
	public String ROLE_LIST_VIEW = PAGE_FOLDER + "/RoleListView.jsp";
	public String USER_REGISTRATION_VIEW = PAGE_FOLDER + "/UserRegistrationView.jsp";
	public String LOGIN_VIEW = PAGE_FOLDER + "/LoginView.jsp";
	public String WELCOME_VIEW = PAGE_FOLDER + "/Welcome.jsp";
	public String CHANGE_PASSWORD_VIEW = PAGE_FOLDER + "/ChangePasswordView.jsp";
	public String MY_PROFILE_VIEW = PAGE_FOLDER + "/MyProfileView.jsp";
	public String FORGET_PASSWORD_VIEW = PAGE_FOLDER + "/ForgetPasswordView.jsp";
	public String MARKSHEET_MERIT_LIST_VIEW = PAGE_FOLDER + "/MarksheetMeritListView.jsp";

	public String FACULTY_VIEW = PAGE_FOLDER + "/FacultyView.jsp";
	public String FACULTY_LIST_VIEW = PAGE_FOLDER + "/FacultyListView.jsp";
	public String COURSE_VIEW = PAGE_FOLDER + "/CourseView.jsp";
	public String COURSE_LIST_VIEW = PAGE_FOLDER + "/CourseListView.jsp";
	public String TIMETABLE_VIEW = PAGE_FOLDER + "/TimeTableView.jsp";
	public String TIMETABLE_LIST_VIEW = PAGE_FOLDER + "/TimeTableListView.jsp";
	public String SUBJECT_VIEW = PAGE_FOLDER + "/SubjectView.jsp";
	public String SUBJECT_LIST_VIEW = PAGE_FOLDER + "/SubjectListView.jsp";
	public String ORDER_VIEW = PAGE_FOLDER + "/OrderView.jsp";
	public String ORDER_LIST_VIEW = PAGE_FOLDER + "/OrderListView.jsp";
	public String LESSION_VIEW = PAGE_FOLDER + "/LessionView.jsp";
	public String LESSION_LIST_VIEW = PAGE_FOLDER + "/LessionListView.jsp";
	public String PRODUCT_VIEW = PAGE_FOLDER + "/ProductView.jsp";
	public String PRODUCT_LIST_VIEW = PAGE_FOLDER + "/ProductListView.jsp";
	public String CLIENT_VIEW = PAGE_FOLDER + "/ClientView.jsp";
	public String CLIENT_LIST_VIEW = PAGE_FOLDER + "/ClientListView.jsp";
	public String PRODUCT_DETAILS_VIEW = PAGE_FOLDER + "/ProductDetailsView.jsp";
	public String PRODUCT_DETAILS_LIST_VIEW = PAGE_FOLDER + "/ProductDetailsListView.jsp";
	
	public String INVENTORY_VIEW = PAGE_FOLDER + "/InventoryView.jsp";
	public String INVENTORY_LIST_VIEW = PAGE_FOLDER + "/InventoryListView.jsp";


	
	
	
	public String ERROR_CTL = APP_CONTEXT +"/ErrorCtl";
	public String Employee_CTL = APP_CONTEXT + "/ctl/EmployeeCtl";
	public String Employee_LIST_CTL = APP_CONTEXT + "/ctl/EmployeeListCtl";
	
	public String BANK_CTL = APP_CONTEXT + "/ctl/BankCtl";
	public String BANK_LIST_CTL = APP_CONTEXT + "/ctl/BankListCtl";
	public String MARKSHEET_CTL = APP_CONTEXT + "/ctl/MarksheetCtl";
	public String MARKSHEET_LIST_CTL = APP_CONTEXT + "/ctl/MarksheetListCtl";
	public String USER_CTL = APP_CONTEXT + "/ctl/UserCtl";
	public String USER_LIST_CTL = APP_CONTEXT + "/ctl/UserListCtl";
	public String COLLEGE_CTL = APP_CONTEXT + "/ctl/CollegeCtl";
	public String COLLEGE_LIST_CTL = APP_CONTEXT + "/ctl/CollegeListCtl";
	public String STUDENT_CTL = APP_CONTEXT + "/ctl/StudentCtl";
	public String STUDENT_LIST_CTL = APP_CONTEXT + "/ctl/StudentListCtl";
	public String ROLE_CTL = APP_CONTEXT + "/ctl/RoleCtl";
	public String ROLE_LIST_CTL = APP_CONTEXT + "/ctl/RoleListCtl";
	public String USER_REGISTRATION_CTL = APP_CONTEXT + "/UserRegistrationCtl";
	public String LOGIN_CTL = APP_CONTEXT + "/LoginCtl";
	public String WELCOME_CTL = APP_CONTEXT + "/WelcomeCtl";
	
	public String FACULTY_CTL = APP_CONTEXT + "/ctl/FacultyCtl";
	public String FACULTY_LIST_CTL = APP_CONTEXT + "/ctl/FacultyListCtl";
	public String COURSE_CTL = APP_CONTEXT + "/ctl/CourseCtl";
	public String COURSE_LIST_CTL = APP_CONTEXT + "/ctl/CourseListCtl";
	public String SUBJECT_CTL = APP_CONTEXT + "/ctl/SubjectCtl";
	public String SUBJECT_LIST_CTL = APP_CONTEXT + "/ctl/SubjectListCtl";
	public String TIMETABLE_CTL = APP_CONTEXT + "/ctl/TimeTableCtl";
	public String TIMETABLE_LIST_CTL = APP_CONTEXT + "/ctl/TimeTableListCtl";
	public String ORDER_CTL = APP_CONTEXT + "/ctl/OrderCtl";
	public String ORDER_LIST_CTL = APP_CONTEXT + "/ctl/OrderListCtl";  
	
	
	public String GET_MARKSHEET_CTL = APP_CONTEXT + "/ctl/GetMarksheetCtl";
	public String CHANGE_PASSWORD_CTL = APP_CONTEXT + "/ctl/ChangePasswordCtl";
	public String MY_PROFILE_CTL = APP_CONTEXT + "/ctl/MyProfileCtl";
	public String FORGET_PASSWORD_CTL = APP_CONTEXT + "/ForgetPasswordCtl";
	public String MARKSHEET_MERIT_LIST_CTL = APP_CONTEXT + "/ctl/MarksheetMeritListCtl";
	public String LESSION_CTL = APP_CONTEXT + "/ctl/LessionCtl";
	public String LESSION_LIST_CTL = APP_CONTEXT + "/ctl/LessionListCtl";
	public String PRODUCT_CTL = APP_CONTEXT + "/ctl/ProductCtl";
	public String PRODUCT_LIST_CTL = APP_CONTEXT + "/ctl/ProductListCtl"; 
	public String CLIENT_CTL= APP_CONTEXT + "/ctl/ClientCtl";
	public String CLIENT_LIST_CTL = APP_CONTEXT + "/ctl/ClientListCtl";
	public String PATIENT_CTL= APP_CONTEXT + "/ctl/PatientCtl";
	public String PATIENT_LIST_CTL = APP_CONTEXT + "/ctl/PatientListCtl";
	public String PRODUCT_DETAILS_CTL= APP_CONTEXT + "/ctl/ProductDetailsCtl";
	public String PRODUCT_DETAILS_LIST_CTL = APP_CONTEXT + "/ctl/ProductdetailsListCtl";

	public String INVENTORY_CTL= APP_CONTEXT + "/ctl/InventoryCtl";
	public String INVENTORY_LIST_CTL = APP_CONTEXT + "/ctl/InventoryListCtl";


}
