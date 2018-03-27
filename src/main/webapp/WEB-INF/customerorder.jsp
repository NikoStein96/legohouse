<%@page import="java.util.ArrayList"%>
<%@page import="FunctionLayer.OrderSample"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>JSP Page</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="style.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body>
        
        
        <% ArrayList<OrderSample> list = null;%>
        
        <% list = (ArrayList)request.getAttribute( "list" );%>
        
        
        <table class="table table-striped" style="width:50%">
            <thead class="thead-dark" style="width:50%">
                <tr>
                    <td>Order ID</td>
                    <td>Height</td>
                    <td>Width</td>
                    <td>Length</td>
                </tr>
            </thead>
            <tbody>
        <%for (int i = 0; i < list.size(); i++) {%>
        <tr>
            <td><%= list.get(i).getId()%></td>
            <td><%= list.get(i).getHeigh()%></td>
            <td><%= list.get(i).getWidth()%></td>
            <td><%= list.get(i).getLength()%></td>
        </tr>
        <%}%>    
        </tbody>
        </table>
    </body>
</html>
