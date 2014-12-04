<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register</title>
</head>
<body>
	<s:form >
	    <s:textfield name="employee.email" label="Email" id="email" />
		<s:password name="employee.password" label="Password" id="password" />
		<s:textfield name="employee.firstname" label="First Name" id="firstname" />
		<s:textfield name="employee.lastname" label="Last Name" id="lastname" />
		<s:textarea name="employee.address" label="Address" id="address" />
		<s:textarea name="employee.tel" label="Tel" id="tel" />
		<s:submit />
	</s:form>
</body>
</html>