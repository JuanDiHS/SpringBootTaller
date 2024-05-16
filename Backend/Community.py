"""This class shows information like members according to the existing communities on the application

Authors Juan Diego Hernández Sierra <juandhernandezs@udistrital.edu.co>
        David Santiago Garcia Galeano <>
"""
from typing import List
from pydantic import BaseModel
from Users import Applicant, Employer

class Community(BaseModel):
    """This class shows the several communities or groups availables into the application"""
    Community_name: str
    creater: Employer
    members: List[Applicant]