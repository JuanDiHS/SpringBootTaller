// Add event listener to the edit form
document.getElementById("edit-form").addEventListener("submit", function(event) {
    event.preventDefault(); // Prevent the form from being submitted
    // Get the values from the input fields
    var nombre = document.getElementById("nombre").value;
    var apellido = document.getElementById("apellido").value;
    var correo = document.getElementById("correo").value;
    var carrera = document.getElementById("carrera").value;
    var edad = document.getElementById("edad").value;
    var ciudad = document.getElementById("ciudad").value;
    var descripcion = document.getElementById("descripcion").value;
    // Update the profile information with the new values
    // This could include an HTTP request to the backend to save the changes
    console.log("Nombre: " + nombre);
    console.log("Apellido: " + apellido);
    console.log("Correo: " + correo);
    console.log("Carrera: " + carrera);
    console.log("Edad: " + edad);
    console.log("Ciudad: " + ciudad);
    console.log("Descripción: " + descripcion);
    // Simply print the values to the console for now
});
