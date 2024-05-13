"""This class contains the attributes and methods that compose a notification on the application

Authors Juan Diego Hernández Sierra <juandhernandezs@udistrital.edu.co>
        David Santiago Garcia Galeano <>
"""
from pydantic import BaseModel
from Users import Applicant, Employer, Administrator

class Notification (BaseModel):
    """This class contains the information correspondent to Notification"""
    transmitter_name: str
    receiver_name: str
    trasnmitter_email: str
    receiver_email: str
    message: str
    # TODO make method to send notification to email
    # TODO make method to verify if the notification was send
