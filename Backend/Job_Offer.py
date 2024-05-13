"""This class contains the attributes and methods for create a job offer on the application

Authors Juan Diego Hernández Sierra <juandhernandezs@udistrital.edu.co>
        David Santiago Garcia Galeano <>
"""

from pydantic import BaseModel

class job_Offer(BaseModel):
    offer_Name: str
    offer_requirements: str
    minimum_age: int
    maximum_age: int
    offer_salary: float
    schedule: str
    Contract_type: str
    # TODO Method to create the job offer