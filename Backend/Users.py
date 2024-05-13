"""This class contains the type of user that exists on the application and their methods

Authors: Juan Diego Hernández Sierra <juandhernandezs@udistrital.edu.co>
         David Santiago Garcia Galeano <>
"""
from pydantic import BaseModel
from Company import Company


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

class Applicant (User):
    """This class is a specialization of the class User"""
    def __init__(self, name: str, lastname: str, email: str, password: str, 
                 Career: str, age: int, city: str):
       super().__init__(name = name, lastname = lastname, email= email, password= password)
       self.Career = Career
       self.age = age
       self.city = city
       self.applicated_jobs = []

class Employer(User):
    """This class is a specialization of the class User"""
    def __init__(self, name:str, lastname:str, email: str, password: str, 
                 phone_number: int, company: Company):
        super().__init__(name = name, lastname= lastname,email= email, password= password, Company= company)
        self.phone_number = phone_number
        self.available_offers = []
    
class Administrator(User):
    """This class is a specialization of the class User"""
    def __init__(self, name: str, lastname: str, email: str, password:str, is_Administrator: bool):
        super.__init__(name= name, lastname= lastname, email= email, password= password)
        self.is_administrator = is_Administrator
        self.available_companies = []