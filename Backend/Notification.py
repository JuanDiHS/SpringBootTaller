"""This class contains the attributes and methods that compose a notification on the application

Authors Juan Diego Hernández Sierra <juandhernandezs@udistrital.edu.co>
        David Santiago Garcia Galeano <>
"""
from pydantic import BaseModel
from Users import Applicant, Employer, Administrator
import os
from email.message import EmailMessage
import ssl
import smtplib
class Notification (BaseModel):
    """This class contains the information correspondent to Notification"""
    trasnmitter_email: str
    receiver_email: str
    affair: str
    message: str
    def send_email(self, notification: Notification):
        email_sender = transmitter_email
        password = "tiqg kyul felm aevx"
        email_receiver = receiver_email
        subject = affair
        body = message

        em = EmailMessage()
        em["From"] = email_sender
        em["To"] = email_receiver
        em["Subject"] = subject
        em.set_content(body)

        context = ssl.create_default_context()

        with smtplib.SMTP_SSL("smtp.gmail.com",465, context= context) as smtp:
           smtp.login(email_sender, password)
           smtp.sendmail(email_sender, email_receiver, em.as_string())
    # TODO Finish method to send notification to email
