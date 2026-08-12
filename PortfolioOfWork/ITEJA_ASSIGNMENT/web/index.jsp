<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <style>
            
            body {
                background: #f7f3fb; /* light lavender background */
                color: #333;
                min-height: 100vh;
                display: flex;
                flex-direction: column;
            }

            form {
                display: flex;
                flex-direction: column;
                gap: 1rem;
            }

            button {
                background: #6a1b9a;
                color: white;
                padding: 0.75rem;
                border: none;
                border-radius: 6px;
                font-size: 1rem;
                cursor: pointer;
                transition: background 0.3s;
            }

            button:hover {
                background: #9b30ff;
            }

        </style>
    </head>
    <body>
        <h2>Login into UniConnect</h2>

        <!-- Form post user info to login servlet -->
        <form action="login" method="post">
            <label for="username"> Username: </label>
            <input type="text" id="username" name="username" placeholder="Enter username" required><br><br>

            <label for="password"> Password: </label>
            <input type="password" id="password" name="password" placeholder="Enter password" required><br><br>

            <button type="submit">Login</button>
        </form>

        <p>Don't have an account?
            <a href="register.jsp">Register here!</a>
        </p>

        <!-- Show error message if the servlet sets one -->
        <p style="color:red;">
            ${error}
        </p>
    </body>
</html>