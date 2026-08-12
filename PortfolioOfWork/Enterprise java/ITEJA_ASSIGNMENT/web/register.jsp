
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Register a UniConnect account</title>
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
        <h2>Create a Uniconnect account</h2>
        <form action = "register" method="post">

            <label for ="username">Create a username</label>
            <input type ="text" id ="username" name ="username" placeholder="Must be between 8-10 characters" required><br><br>

            <label for ="password">Create a password</label>
            <input type ="text" id ="password" name ="password" placeholder="Must be over 8 characters" required><br><br>


            <button type ="submit">Submit</button>


        </form>

        <hr>

        <p> Already have an account?
            <a href="index.jsp">login here!</a>
        </p>

    </body>
</html>

