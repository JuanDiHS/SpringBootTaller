"""This class contains attributes and methods for those users that applies at a job offer

Authors Juan Diego Hernández Sierra <juandhernandezs@udistrital.edu.co>
        David Santiago Garcia Galeano <>
"""
from pydantic import BaseModel
from Users import Applicant
class job_Application(BaseModel):
    """This class represents when an candidant tries to apply to a job offer"""
    applicant: Applicant
    name: str
    description: str

    def make_publication(self, applicant:Applicant, name:str, description:str):
        """This method allows that an applicant post a job where describes his skills
        Args:
        applicant(Applicant): Information about applicants
        name(str): Name of the publication
        description(str): Description of the application
        """
        applicant.name = Applicant.name
        applicant.lastname = Applicant.lastname
        applicant.email = Applicant.email
        applicant.password = Applicant.password
        applicant.age = Applicant.age
        applicant.city = Applicant.city
        name = input("Enter the name of the publication: ")
        description = input("Enter the description of the publication: ")
       # TODO Finish method





    