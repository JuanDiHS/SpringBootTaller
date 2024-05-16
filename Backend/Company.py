"""This class represents the companies availables on the application

   Authors Juan Diego Hernández Sierra <juandhernandezs@udistrital.edu.co>
        David Santiago Garcia Galeano <>
"""
from pydantic import BaseModel
from Users import Employer

class Company(BaseModel):
    """This class represents the companies asociated to the job offers"""
    employer: Employer
    company_Name: str
    category: str
    description: str
    available_vacant: int
    # TODO Do methods to associating classes
    