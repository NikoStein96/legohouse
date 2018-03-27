
<html>
    <head>
        <title>JSP Order/title></title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="style.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>




    </head>
    <body>
        <h1>Insert the desiered size of your house!</h1>

        <form name="order" action="FrontController" method="GET">
            <input type="hidden" name="command" value="order">
            <input type="text" name="height" value="height">
            <input type="text" name="length" value="length">
            <input type="text" name="width" value="width">
            <input type="submit" value="Submit">





            <table id="brickTable" class="table table-striped" style="width:100%">
                <thead>
                    <tr>
                        <th> type <th>
                        <th>side 1</th>
                        <th>side 2</th> 
                        <th>side 3</th>
                        <th>side 4 </th>
                        <th> total </th>

                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>2X4</td>
                        <td> </td>
                        <td>${longbrick}</td> 
                        <td>${longbrick}</td>
                        <td>${longbrickw}</td>
                        <td>${longbrickw}</td>
                        <td>${finallongbrick}</td>
                    </tr>

                    <tr>

                        <td>2X2</td>
                        <td></td>
                        <td>${mediumbrick}</td> 
                        <td>${mediumbrick}</td>
                        <td>${mediumbrickw}</td>
                        <td>${mediumbrickw}</td>
                        <td>${finalmediumbrick}</td>


                    </tr>
                    <tr>
                        <td>2X1</td>
                        <td> </td>
                        <td>${shortbrick}</td> 
                        <td>${shortbrick}</td>
                        <td>${shortbrickw}</td>
                        <td>${shortbrickw}</td>
                        <td>${finalshortbrick}</td>
                    </tr>
                    
                    
                    
                </tbody>
            </table>
                    
                    
                    <a href="FrontController?command=test">Klik her for at gennemfore din ordre</a>



        </form>
    </body>
</html>