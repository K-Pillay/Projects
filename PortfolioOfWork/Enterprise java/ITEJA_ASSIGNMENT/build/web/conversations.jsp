

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>UniConnect - Join the chat!</title>
    <link rel="stylesheet" type="text/css" href="../styles.css">
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #2d0036;
            color: white;
            text-align: center;
        }

        #chat-window {
            border: 2px solid #6a0dad;
            border-radius: 8px;
            width: 60%;
            height: 300px;
            margin: 20px auto;
            padding: 10px;
            background: #3c004a;
            overflow-y: auto;
        }

        #message {
            width: 50%;
            padding: 10px;
            border-radius: 5px;
            border: none;
        }

        button {
            background: #6a0dad;
            color: white;
            padding: 10px 15px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            margin-left: 5px;
        }

        button:hover {
            background: #9b30ff;
        }
    </style>
</head>
<body>
    <h2>Live Chat Conversations</h2>

    <!-- Area for chat block -->
    <div id="chat-window"></div>

    <!-- Area that allows for chat input -->
    <input type="text" id="message" placeholder="Enter your message here...">
    <button onclick="sendMessage()">Send</button><br><br>

    <a href="homepage.jsp" style="color:#9b30ff;">Back to homepage</a>

    <script>
        // Open the WebSocket connection
        let socket = new WebSocket("ws://localhost:8080/ITEJA_ASSIGNMENT/chat");

        // Handle incoming messages
        socket.onmessage = function (event) {
            let chatWindow = document.getElementById("chat-window");
            let message = document.createElement("div");
            message.textContent = event.data;
            chatWindow.appendChild(message);
            chatWindow.scrollTop = chatWindow.scrollHeight; // Auto-scroll
        };

        // Event when connection opens
        socket.onopen = function () {
            console.log("Connected to chat server");
        };

        // Event when an error occurs
        socket.onerror = function (error) {
            console.error("Error with WebSocket:", error);
        };

        // Function that handles sending messages
        function sendMessage() {
            let messageInput = document.getElementById("message");
            let message = messageInput.value;

            if (message.trim() !== "") {
                //JSP injects username along with message
                socket.send(message);
                console.log("Message sent:", message);
                messageInput.value = "";
            }
        }

        // Lets users send message by pressing "Enter" on keyboard
        document.getElementById("message").addEventListener("keyup", function (event) {
            if (event.key === "Enter") {
                sendMessage();:
            }
        });
    </script>
</body>
</html>
