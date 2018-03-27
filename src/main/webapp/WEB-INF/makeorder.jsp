<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
            <form name="order" action="FrontController" method="GET">
                <input type="hidden" name="command" value="makeorder">
                <input type="text" name="id" value="height">
                <input type="submit" value="Submit">
            </form>
    </body>
</html>
