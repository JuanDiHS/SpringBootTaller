"""This class is the abstraction for any publication made by the user or the employer

Authors Juan Diego Hernández Sierra <juandhernandezs@udistrital.edu.co>
        David Santiago Garcia Galeano <>
"""

from pydantic import BaseModel
from Users import Employer, Applicant

class Publication(BaseModel):
    """This class represents the attributes and methods for any kind of publication into the application
    """
    publication_Name: str
    description: str
    category: str
    # TODO make publication method

class Employer_Publication(Publication):
    """This is a specialization of class "Publication", allows that employer create a post 
    """
    def __init__(self, publication_Name: str, description: str, category: str, employer: Employer, contract_type: str, salary: float, schedule: str):
        super().__init__(publication_Name= publication_Name, description= description, category= category, Employer= employer)
        self.contract_type = contract_type
        self.salary = salary
        self.schedule = schedule

class Applicant_Publication(Publication):
    """This is a specialization of class "Publication", allows that applicant create a post 
    """
    def __init__(self, publication_Name: str, description: str, category: str, applicant: Applicant, schedule: str, study_Level: str): 
        super().__init__(publication_Name= publication_Name, description= description, category= category, Applicant = applicant)
        self.schedule = schedule
        self.study_Level = study_Level
