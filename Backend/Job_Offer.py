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
    contract_type: str

    def create_job_offer(self, job_Offer: job_Offer):
        """This method allows that employers create job´s offers
        Args:
        job_Offer(job_Offer): Required attributes to create a job offer.
        """
        job_Offer.offer_Name = input("Enter the name of the offer: ")
        job_Offer.offer_requirements = input("Enter the requirements of the job: ")
        job_Offer.minimum_age = input("Enter the minimum age required: ")
        job_Offer.maximum_age = input("Enter the maximum age required: ")
        job_Offer.offer_salary = input("Enter the salary that you will offer: ")
        job_Offer.schedule = input("Enter the schedule for the job position: ")
        job_Offer.contract_type = input("Enter the type of contract that you will offer: ")


        # TODO Finishing the method
     