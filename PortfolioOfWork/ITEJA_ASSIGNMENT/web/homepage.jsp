

<%@page contentType="text/html" pageEncoding="UTF-8" language = "java"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Homepage</title>
        <style>

            a {
    color: #6a1b9a;
    text-decoration: none;
    font-weight: bold;
}

a:hover {
    text-decoration: underline;
}
        </style>   
    </head>
    <body>
        <!--display personalised message from HomeServlet -->
        <h2>${welclomeMessage}</h2>

        <p>Welcome to the UniConnect home page!</p>

        <nav>
            <ul>
                <li><a href="index.jsp">Logout</a></li>
                <li><a href="conversations.jsp">Chat</a></li>
            </ul>
        </nav>
    </body>
</html>
