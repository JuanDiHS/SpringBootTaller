// Add event listener to the registration button
document.getElementById("registro-btn").addEventListener("click", function() {

    // Get the values from the input fields
    var nombre = document.getElementById("nombre").value;
    var apellido = document.getElementById("apellido").value;
    var correo = document.getElementById("correo").value;
    var carrera = document.getElementById("carrera").value;
    var edad = document.getElementById("edad").value;
    var ciudad = document.getElementById("ciudad").value;
    var contrasena = document.getElementById("contrasena").value;

    // Here you can add logic to send the registration data to the backend
    // For now, we just display the information in the console
    console.log("Nombre: " + nombre);
    console.log("Apellido: " + apellido);
    console.log("Correo: " + correo);
    console.log("Carrera: " + carrera);
    console.log("Edad: " + edad);
    console.log("Ciudad: " + ciudad);
    console.log("Contraseña: " + contrasena);
});
