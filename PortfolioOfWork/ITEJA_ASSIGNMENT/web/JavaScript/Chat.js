<script>
// Open the WebSocket connection
let socket = new WebSocket("ws://localhost:8080/ITEJA_ASSIGNMENT/chat");

// Handle incoming messages
socket.onmessage = function(event) {
    let chatWindow = document.getElementById("chat-window");
    let message = document.createElement("div");
    message.textContent = event.data;
    chatWindow.appendChild(message);
};

// Event when connection opens
socket.onopen = function() {
    console.log("Connected to chat server");
};

// Event when an error occurs
socket.onerror = function(error) {
    console.error("Error with WebSocket:", error);
};

// Function to handle sending messages
function sendMessage() {
    let messageInput = document.getElementById("message");
    let message = messageInput.value;
    console.log("Sending message:", message);
    
    // Ensure no empty messages are entered
    if (message.trim() !== "") {
        socket.send(message);
        messageInput.value = "";
    }
}

// Let user send message by pressing "Enter"
document.getElementById("message").addEventListener("keyup", function(event) {
    if (event.key === "Enter") {
        sendMessage();
    }
});
</script>