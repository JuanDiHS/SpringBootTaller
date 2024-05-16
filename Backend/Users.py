"""This class contains the type of user that exists on the application and their methods

Authors: Juan Diego Hernández Sierra <juandhernandezs@udistrital.edu.co>
         David Santiago Garcia Galeano <>
"""
from pydantic import BaseModel
from Company import Company
from Job_Offer import job_Offer


class User(BaseModel):
    """This class is an abstraction for any kind of user on the application"""

    name: str
    lastname: str
    email: str
    password: str
    grants: dict

    @staticmethod
    def login(email: str, password: str):
        """This method allows that an user login into the application
        Args:
        Email (str): The email of the user
        Password (Str): The password of the user
        """

        # TODO: Do return
    def can_publish(self):
        """This method is used to know if the user can publish a job offer or a job application
        """
        return self.grants.get("publish")
    
    def create_profile(self, user: User, role: str):
        """This method allows that an user create a profile into the application
        Args:
        user(User): Attributes of the user like name, lastname, email and password
        Role (str): Role of the user
        """
        # TODO: Do the method
    def modify_profile(self, user: User):
        """This method is for change or modify some characteristics of the user
        Args:
        user(User): Attributes of the user
        """



class Applicant (User):
    """This class is a specialization of the class User"""
    def __init__(self, name: str, lastname: str, email: str, password: str, 
                age: int, city: str):
       super().__init__(name = name, lastname = lastname, email= email, password= password)
       self.age = age
       self.city = city
       self.applicated_jobs = []
    
    def create_description_profile(self, applicant: Applicant, Career: str, description: str, skills: str):
        """This method allows the user to create a description for their professional profile
        Args:
        applicant(Applicant): Applicant´s attributes
        Career(str): Career that the applicant courses
        description(str): A simple description of applicant´s profile
        skills(str): Skills that applicant develops like degrees, certificates, etc
        """
        # TODO: Do the method



class Employer(User):
    """This class is a specialization of the class User"""
    def __init__(self, name:str, lastname:str, email: str, password: str, 
                 phone_number: int, company: Company):
        super().__init__(name = name, lastname= lastname,email= email, password= password, Company= company)
        self.phone_number = phone_number
        self.available_offers = []
    def show_lists(self, applicant: Applicant):
        """This method shows a list with the amount of persons that applies to the jobs.
        Args:
        applicant(Applicant): Attributes of the applicant.
        """
    
class Administrator(User):
    """This class is a specialization of the class User"""
    def __init__(self, name: str, lastname: str, email: str, password:str, is_Administrator: bool):
        super.__init__(name= name, lastname= lastname, email= email, password= password)
        self.is_administrator = is_Administrator
        self.available_companies = []
    def generate_statistics(self, applicant: Applicant, employer: Employer, job_offer:job_Offer):
        """This method allows that the administrator generate statistics about the application
        Args:
        applicant(Applicant): Attributes of the applicant.
        employer(Employer): Attributes of the employer.
        job_offer(Job_offer): Information about the job´s offers availables into the application
        """