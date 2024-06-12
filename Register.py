# Datos de usuarios (simulación) 

usuarios = { 

    "usuario1": "contraseña1", 

    "usuario2": "contraseña2", 

    # Puedes agregar más usuarios aquí 

} 

  

class Usuario(BaseModel): 

    username: str 

    password: str 
