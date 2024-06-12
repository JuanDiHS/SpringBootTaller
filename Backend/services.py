from fastapi import FastAPI, HTTPException, Depends
from pydantic import BaseModel
from passlib.context import CryptContext
from typing import List 
from datetime import datetime, timedelta

app = FastAPI()


# Service to retrieve a list of job offers.
@app.get('/ofertas') 
async def obtener_ofertas_de_trabajo(): 
    return ofertas_de_trabajo 


# Service to apply for a job offer.
@app.post('/aplicar') 
async def aplicar_a_oferta(oferta_id: int): 
    for oferta in ofertas_de_trabajo: 
        if oferta["id"] == oferta_id: 
            # Add the applied offer to the applicant's profile.
            perfil_aspirante["ofertas_aplicadas"].append(oferta) 
            return {"message": f"Has aplicado a la oferta: {oferta['titulo']}"} 
    raise HTTPException(status_code=404, detail="Oferta de trabajo no encontrada")


# Service for user login.
@app.post('/login') 
async def login(usuario: Usuario): 
    if usuario.username in usuarios and usuarios[usuario.username] == usuario.password: 
        return {'message': 'Inicio de sesión exitoso'} 
    else: 
        raise HTTPException(status_code=401, detail='Usuario o contraseña incorrectos')


# Service for user registration.
@app.post('/registro') 
async def registro(usuario: Usuario): 
    if usuario.username in usuarios: 
        raise HTTPException(status_code=400, detail='El usuario ya existe') 
    usuarios[usuario.username] = usuario.password 
    return {'message': 'Usuario registrado exitosamente'}


# Service to edit user profile.
@app.post("/editar-perfil")
async def editar_perfil(nombre: str, apellido: str, correo: str, carrera: str, edad: int, ciudad: str, descripcion: str, foto: UploadFile = File(...)):
    # Logic to process form information and photo.
    # For now, just print received data.
    return {"nombre": nombre, "apellido": apellido, "correo": correo, "carrera": carrera, "edad": edad, "ciudad": ciudad, "descripcion": descripcion}


# Service to get the login form.
@app.get("/loginform")
async def get_form():
    with open("form.html", "r") as file:
        return HTMLResponse(content=file.read(), status_code=200)


# Service to create a user profile.
@app.post("/crear-perfil")
async def crear_perfil(user_profile: UserProfile = Body(...)):
    # Logic to save the profile in a database or perform other necessary actions.
    return {"mensaje": "Perfil creado exitosamente", "perfil": user_profile}


# Service to login a user.
@app.post("/login")
async def login(user_login: UserLogin):
    user = fake_users_db.get(user_login.nombre_usuario)
    if not user or user["contraseña"] != user_login.contraseña:
        raise HTTPException(status_code=401, detail="Credenciales inválidas")   
    return {"token": user_login.nombre_usuario}


# Service to retrieve available jobs based on user's skills.
@app.get("/empleos-disponibles")
async def empleos_disponibles(usuario: UserInfo):
    empleos_filtrados = []
    for job in jobs_db:
        if all(aptitud in job["aptitudes_requeridas"] for aptitud in usuario.aptitudes):
            empleos_filtrados.append(job)
    return {"empleos_disponibles": empleos_filtrados}


# Service to apply for a job.
@app.post("/aplicar-empleo/{usuario_id}/{trabajo_id}")
async def aplicar_empleo(usuario_id: int, trabajo_id: int):
    if trabajo_id < 0 or trabajo_id >= len(jobs_db):
        raise HTTPException(status_code=404, detail="Trabajo no encontrado")
    if usuario_id < 0:
        raise HTTPException(status_code=400, detail="ID de usuario inválido")    
    # Get user and job information.
    usuario = UserInfo(**fake_users_db[usuario_id])
    trabajo = JobInfo(**jobs_db[trabajo_id])    
    # Add the application to the list of applications.
    applications_db.append({"usuario": usuario, "trabajo": trabajo})    
    # Notify the user about the application.
    notification = Notification(usuario=usuario, trabajo=trabajo, estado=ApplicationStatus.admision)
    return {"mensaje": "Aplicación enviada correctamente", "notificacion": notification.dict()}


# Service to get notifications for a user.
@app.get("/notificaciones/{usuario_id}")
async def obtener_notificaciones(usuario_id: int):
    if usuario_id < 0:
        raise HTTPException(status_code=400, detail="ID de usuario inválido")
    # Filter user notifications.
    user_notifications = [notification for notification in notifications_db if notification["usuario"]["id"] == usuario_id]
    return {"notificaciones": user_notifications}


# Service to publish a job offer.
@app.post("/publicar-oferta")
async def publicar_oferta(job_post: JobPost):
    job_posts_db.append(job_post)
    return {"mensaje": "Publicación de oferta creada correctamente"}


# Service to retrieve job offers.
@app.get("/ofertas-laborales")
async def obtener_ofertas_laborales():
    return {"ofertas_laborales": job_posts_db}


# Service to publish a job offer (alternative).
@app.post("/publicar-oferta-trabajo")
async def publicar_oferta_trabajo(job_offer: JobOffer):
    job_offers_db.append(job_offer)
    return {"mensaje": "Oferta de trabajo publicada correctamente"}


# Service to retrieve job offers (alternative).
@app.get("/ofertas-trabajo")
async def obtener_ofertas_trabajo():
    return {"ofertas_trabajo": job_offers_db}


# Service to accept or reject a job application.
@app.put("/aceptar-rechazar-aplicacion")
async def aceptar_rechazar_aplicacion(aplicacion: JobApplication):
    for app in job_applications_db:
        if app.usuario == aplicacion.usuario and app.trabajo == aplicacion.trabajo:
            app.estado = aplicacion.estado
            return {"mensaje": f"Estado de la aplicación para el usuario {aplicacion.usuario} actualizado correctamente"}
    raise HTTPException(status_code=404, detail="Aplicación no encontrada")


# Service to retrieve job applications.
@app.get("/aplicaciones-trabajo")
async def obtener_aplicaciones_trabajo():
    return {"aplicaciones_trabajo": job_applications_db}


# Service to retrieve job applications (alternative).
@app.get("/aplicaciones-trabajo")
async def obtener_aplicaciones_trabajo():
    return {"aplicaciones_trabajo": job_applications_db}
    

# Service to get statistics about job applications.
@app.get("/estadisticas-aplicaciones")
async def obtener_estadisticas_aplicaciones():
    total_aplicaciones = len(job_applications_db)
    total_admitidos = sum(1 for app in job_applications_db if app.estado == "aceptado")
    total_rechazados = sum(1 for app in job_applications_db if app.estado == "rechazado")
    
    promedio_admision = total_admitidos / total_aplicaciones if total_aplicaciones > 0 else 0
    promedio_rechazo = total_rechazados / total_aplicaciones if total_aplicaciones > 0 else 0
    return {
        "total_aplicaciones": total_aplicaciones,
        "total_admitidos": total_admitidos,
        "total_rechazados": total_rechazados,
        "promedio_admision": promedio_admision,
        "promedio_rechazo": promedio_rechazo
    }
        "total_admitidos": total_admitidos,
        "total_rechazados": total_rechazados,
        "promedio_admision": promedio_admision,
        "promedio_rechazo": promedio_rechazo
    }
