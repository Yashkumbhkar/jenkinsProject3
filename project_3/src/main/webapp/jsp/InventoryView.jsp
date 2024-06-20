<%@page import="java.util.HashMap"%>
<%@page import="in.co.rays.project_3.controller.InventoryCtl"%>
<%@page import="in.co.rays.project_3.util.HTMLUtility"%>
<%@page import="in.co.rays.project_3.controller.PatientCtl"%>
<%@page import="in.co.rays.project_3.util.ServletUtility"%>
<%@page import="java.util.List"%>
<%@page import="in.co.rays.project_3.util.DataUtility"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">



<script>
        function validateMobileNo(event) {
            const input = event.target;
            input.value = input.value.replace(/[^0-9.]/g, '');
            if (input.value.length > 0 && input.value[0] <= '5') {
               
                input.value = '';
            }
        }
        
         // on version veiw field write  onInput="validateVersion(event)"
        function validateVersion(event) {
            const input = event.target;
            input.value = input.value.replace(/[^0-9.]/g, '');
        }
    </script>

<script src="<%=ORSView.APP_CONTEXT%>/js/ValidateToInput.js"></script>

<style type="text/css">

i.css {
	border: 2px solid #8080803b;
	padding-left: 10px;
	 padding-bottom: 11px; 
	 background-color: #ebebe0;
}

.input-group-addon{
	/* box-shadow: 9px 8px 7px #001a33; */
background-image: linear-gradient(to bottom right, orange, black);
background-repeat: no repeat;
background-size: 100%;
padding-bottom: 11px;
}

.hm {
	background-image: url('<%=ORSView.APP_CONTEXT%>/img/unsplash.jpg');
	background-size: cover;
	padding-top: 6%;
}
</style>

</head>
<body class="hm">
	<div class="header">
		<%@include file="Header.jsp"%>
		<%@include file="calendar.jsp" %>
	</div>
	<div>

		<main>
		<form action="<%=ORSView.INVENTORY_CTL%>" method="post">
			<jsp:useBean id="dto" class="in.co.rays.project_3.dto.InventoryDTO"
				scope="request"></jsp:useBean>
			<div class="row pt-3">
				<!-- Grid column -->
				<div class="col-md-4 mb-4"></div>
				<div class="col-md-4 mb-4">
					<div class="card input-group-addon">
						<div class="card-body">

							<%
							  long id=DataUtility.getLong(request.getParameter("id"));
							
							
								if (dto.getId()!=null && id>0) {
							%>
							<h3 class="text-center default-text text-primary">Update Inventory</h3>
							<%
								} else {
							%>
							<h3 class="text-center default-text text-primary">Add Inventory</h3>
							<%
								}
							%>
							<!--Body-->
							<div>
								<%
								 List list = (List) request.getAttribute("mt");
							 HashMap map = (HashMap)	request.getAttribute("sm");
								%>

								<H4 align="center">
									<%
										if (!ServletUtility.getSuccessMessage(request).equals("")) {
									%>
									<div class="alert alert-success alert-dismissible">
										<button type="button" class="close" data-dismiss="alert">&times;</button>
										<%=ServletUtility.getSuccessMessage(request)%>
									</div>
									<%
										}
									%>
								</H4>

								<H4 align="center">
									<%
										if (!ServletUtility.getErrorMessage(request).equals("")) {
									%>
									<div class="alert alert-danger alert-dismissible">
										<button type="button" class="close" data-dismiss="alert">&times;</button>
											<%=ServletUtility.getErrorMessage(request)%>
									</div>
									<%
										}
									%>

								</H4>

								<input type="hidden" name="id" value="<%=dto.getId()%>">
								
							</div>

							<div class="md-form">
								
		<span class="pl-sm-5"><b> SupplierName</b>
		<span style="color: red;">*</span></span> </br>
		<div class="col-sm-12">
      <div class="input-group">
        <div class="input-group-prepend">
          <div class="input-group-text"><i class="fa fa-user-alt grey-text" style="font-size: 1rem;"></i> </div>
        </div>
        <input type="text" class="form-control" name="supplierName"  onkeypress="return validateInput(event)" placeholder="Enter SupplierName" value="<%=DataUtility.getStringData(dto.getSupplierName())%>">
      </div>
    </div>
	<font color="red" class="pl-sm-5"> <%=ServletUtility.getErrorMessage("supplierName", request)%></font></br>			
	
	<span class="pl-sm-5"><b>LastUpdatedDate</b>
	<span style="color: red;">*</span></span></br>
	<div class="col-sm-12">
      <div class="input-group">
        <div class="input-group-prepend">
          <div class="input-group-text"><i class="fa fa-calendar grey-text" style="font-size: 1rem;"></i> </div>
        </div>
        <input type="text" id="datepicker2" name="lastUpdatedDate" class="form-control" placeholder="lastUpdatedDate " readonly="readonly" value="<%=DataUtility.getDateString(dto.getLastUpatedDate()) %>">
      </div>
    </div>	
	<font color="red" class="pl-sm-5"> <%=ServletUtility.getErrorMessage("lastUpdatedDate", request)%></font></br>	<%-- 
								<%
								if (dto.getId()==null||id<=0) {
								%> --%>

<span class="pl-sm-5"><b>Quantity</b>
	<span style="color: red;">*</span></span></br>
	<div class="col-sm-12">
      <div class="input-group">
        <div class="input-group-prepend">
          <div class="input-group-text"><i class="fa fa-calendar grey-text"   style="font-size: 1rem;"></i> </div>
        </div>
        <input type="number" id="datepicker2" maxlength="100" name="quantity" class="form-control" placeholder="quantity"  value="<%=DataUtility.getStringData(dto.getQuantity()).equals("0") ? ""
				: DataUtility.getStringData(dto.getQuantity())%>">
    </div>	
	<font color="red" class="pl-sm-5"> <%=ServletUtility.getErrorMessage("quantity", request)%></font></br>
						
 	
	
							
									
	<span class="pl-sm-5"><b>Product</b><span style="color: red;">*</span></span> </br>
							 
	<div class="col-sm-12">
      <div class="input-group">
        <div class="input-group-prepend">
          <div class="input-group-text"><i class="fa fa-venus-mars grey-text" style="font-size: 1rem;"></i> </div>
        </div>
        
									<%
									String htmlList = HTMLUtility.getList("product", dto.getProduct(), map);
									%>
									<%=htmlList%></div>
      
    </div>		
	<font color="red" class="pl-sm-5"> <%=ServletUtility.getErrorMessage("product", request)%></font></br>					<%
								if (dto.getId()!=null&&id>0) {
							%>

							<div class="text-center">

								<input type="submit" name="operation" class="btn btn-success btn-md" style="font-size: 17px" value="<%=PatientCtl.OP_UPDATE%>"> 
									
									<input type="submit" name="operation" class="btn btn-warning btn-md" style="font-size: 17px" value="<%=PatientCtl.OP_CANCEL%>">

							</div>
							<%
								} else {
							%>
							<div class="text-center">

								<input type="submit" name="operation" class="btn btn-success btn-md" style="font-size: 17px" value="<%=InventoryCtl.OP_SAVE%>"> 
								
								<input type="submit" name="operation" class="btn btn-warning btn-md" style="font-size: 17px" value="<%=InventoryCtl.OP_RESET%>">
							</div>

						</div>
						<%
							}
						%>
					</div>
				</div>
		</form>
		</main>
          	<div class="col-md-4 mb-4"></div>

	</div>

</body>
<%@include file="FooterView.jsp"%>

</body>
</html>