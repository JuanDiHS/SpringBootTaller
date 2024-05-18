"""This class is the abstraction for any publication made by the user or the employer

Authors Juan Diego Hernández Sierra <juandhernandezs@udistrital.edu.co>
        David Santiago Garcia Galeano <>
"""

from pydantic import BaseModel
from Users import Employer, Applicant
from Job_Offer import job_Offer
from Job_Application import job_Application

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

    def show_job_offer(self, job_offer: job_Offer, employer: Employer):
        """This method is to show a job offer created by a employer
        Args:
        job_offer(job_Offer): Attributes of the job offer that will be shown in the application
        employer(Employer): Attributes of the employer that posted the job offer
        """
        print(Employer.name)
        print(Employer.lastname)
        print(Employer.phone_number)
        print(Employer.company)
        print(job_Offer.offer_Name)
        print(job_Offer.offer_requirements)
        print(job_Offer.minimum_age)
        print(job_Offer.maximum_age)
        print(job_Offer.offer_salary)
        print(job_Offer.schedule)
        print(job_Offer.Contract_type)
        # TODO: Finish the method

class Applicant_Publication(Publication):
    """This is a specialization of class "Publication", allows that applicant create a post 
    """
    def __init__(self, publication_Name: str, description: str, category: str, applicant: Applicant, schedule: str, study_Level: str): 
        super().__init__(publication_Name= publication_Name, description= description, category= category, Applicant = applicant)
        self.schedule = schedule
        self.study_Level = study_Level
    
    def show_job_publication(self, job_Application: job_Application):
        """This method is to show a job application from an applicant
        Args:
        job_application(job_Application): Attributes of the job application of the applicant
        applicant(Applicant): Attribute of the user that create the publication.
        """
        print(job_Application.applicant)
        print(job_Application.name)
        print(job_Application.description)
        
    
        # TODO Finish method
