"""This class contains the attributes and methods for create a job offer on the application

Authors Juan Diego Hernández Sierra <juandhernandezs@udistrital.edu.co>
        David Santiago Garcia Galeano <>
"""

from pydantic import BaseModel

class job_Offer(BaseModel):
    """This class represents when an employer post a job offer with his attributes"""
    offer_Name: str
    offer_requirements: str
    minimum_age: int
    maximum_age: int
    offer_salary: float
    schedule: str
    Contract_type: str

    def create_job_offer(self, job_Offer: job_Offer):
        """This method allows that employers create job´s offers
        Args:
        job_Offer(job_Offer): Required attributes to create a job offer.
        """
        # TODO Create method
     