        document.getElementById("login-form").addEventListener("submit", async function (event) { 

            event.preventDefault(); // Prevent the form from being submitted 

  

            var username = document.getElementById("username").value; 

            var password = document.getElementById("password").value; 

  

            try { 

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

  

                if (response.ok) { 

                    console.log('Login successful'); 

                    // Redirect to another page or perform other actions upon successful login 

                } else { 

                    console.error('Error in login:', response.statusText); 

                    // Handle login error, e.g., display error message to the user 

                } 

            } catch (error) { 

                console.error('Error in login:', error); 

            } 

        }); 

  

        document.getElementById("edit-form").addEventListener("submit", function (event) { 

            event.preventDefault(); // Prevent the form from being submitted 

  

            var nombre = document.getElementById("nombre").value; 

            var apellido = document.getElementById("apellido").value; 

            var correo = document.getElementById("correo").value; 

            var carrera = document.getElementById("carrera").value; 

            var edad = document.getElementById("edad").value; 

            var ciudad = document.getElementById("ciudad").value; 

            var descripcion = document.getElementById("descripcion").value; 

  

            console.log("Name: " + nombre); 

            console.log("Last Name: " + apellido); 

            console.log("Email: " + correo); 

            console.log("Career: " + carrera); 

            console.log("Age: " + edad); 

            console.log("City: " + ciudad); 

            console.log("Description: " + descripcion); 

        }); 

  

        document.getElementById("registro-btn").addEventListener("click", function () { 

            var nombre = document.getElementById("nombre").value; 

            var apellido = document.getElementById("apellido").value; 

            var correo = document.getElementById("correo").value; 

            var carrera = document.getElementById("carrera").value; 

            var edad = document.getElementById("edad").value; 

            var ciudad = document.getElementById("ciudad").value; 

            var contrasena = document.getElementById("contrasena").value; 

  

            console.log("Name: " + nombre); 

            console.log("Last Name: " + apellido); 

            console.log("Email: " + correo); 

            console.log("Career: " + carrera); 

            console.log("Age: " + edad); 

            console.log("City: " + ciudad); 

            console.log("Password: " + contrasena); 

        }); 
