@app.get('/ofertas') 

async def obtener_ofertas_de_trabajo(): 

    return ofertas_de_trabajo 

  

@app.post('/aplicar') 

async def aplicar_a_oferta(oferta_id: int): 

    for oferta in ofertas_de_trabajo: 

        if oferta["id"] == oferta_id: 

            # Agregar la oferta aplicada al perfil del aspirante 

            perfil_aspirante["ofertas_aplicadas"].append(oferta) 

            return {"message": f"Has aplicado a la oferta: {oferta['titulo']}"} 

    raise HTTPException(status_code=404, detail="Oferta de trabajo no encontrada") 

@app.post('/login') 

async def login(usuario: Usuario): 

    if usuario.username in usuarios and usuarios[usuario.username] == usuario.password: 

        return {'message': 'Inicio de sesión exitoso'} 

    else: 

        raise HTTPException(status_code=401, detail='Usuario o contraseña incorrectos') 

@app.post('/login') 

async def login(usuario: Usuario): 

    if usuario.username in usuarios and usuarios[usuario.username] == usuario.password: 

        return {'message': 'Inicio de sesión exitoso'} 

    else: 

        raise HTTPException(status_code=401, detail='Usuario o contraseña incorrectos') 

  

@app.post('/registro') 

async def registro(usuario: Usuario): 

    if usuario.username in usuarios: 

        raise HTTPException(status_code=400, detail='El usuario ya existe') 

    usuarios[usuario.username] = usuario.password 

    return {'message': 'Usuario registrado exitosamente'}

@app.post("/editar-perfil")
async def editar_perfil(nombre: str, apellido: str, correo: str, carrera: str, edad: int, ciudad: str, descripcion: str, foto: UploadFile = File(...)):
    # Aquí iría la lógica para procesar la información del formulario y la foto
    # Por ahora, solo imprimimos los datos recibidos
    return {"nombre": nombre, "apellido": apellido, "correo": correo, "carrera": carrera, "edad": edad, "ciudad": ciudad, "descripcion": descripcion}

@app.get("/")
async def get_form():
    with open("form.html", "r") as file:
        return HTMLResponse(content=file.read(), status_code=200)
