<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%if(request.getAttribute("by").equals("id")) {%>
json:${json }
<%}else if(request.getAttribute("by").equals("all")) {
	String[] jsons=(String[])request.getAttribute("json");
for(int i=0;i<jsons.length;i++)
{
	out.println(jsons[i]+"<br>");
}
} %>
</body>
</html>