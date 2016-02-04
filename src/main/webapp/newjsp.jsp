<%-- 
    Document   : newjsp
    Created on : 4-Feb-2016, 2:51:28 PM
    Author     : c0652847
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="dbsamp.dbsamp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1><%=dbsamp.getTable()%></h1>
    </body>
</html>
