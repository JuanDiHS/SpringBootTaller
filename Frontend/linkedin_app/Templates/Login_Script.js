// Add event listener to the login form
document.getElementById("login-form").addEventListener("submit", async function(event){ 
    event.preventDefault(); // Prevent the form from being submitted 

    // Get the username and password from the form
    var username = document.getElementById("username").value; 
    var password = document.getElementById("password").value; 

    // Send POST request to the backend
    const response = await fetch('/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            username: username,
            password: password
        })
    });

    // Handle the backend response
    if (response.ok) {
        // If the request was successful, display a successful login message
        console.log('Successful login');
    } else {
        // If the request failed, display an error message
        console.error('Error logging in:', response.statusText);
    }
});
