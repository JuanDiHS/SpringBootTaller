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
    role: str

    @staticmethod
    def login(email: str, password: str):
        """This method allows that an user login into the application
        Args:
        Email (str): The email of the user
        Password (Str): The password of the user
        """
        email = input("Enter your email: ")
        password = input("Enter your password: ")
        for email in User_List:
            if email == User.email:
                if password == User.password:
                    print("Log in successfully")
                else: 
                    print("Wrong password")
            else: 
                print("Email doesn´t exist, try again")
        # TODO Finish method
    
    def create_profile(self, user: User, role: str):
        """This method allows that an user create a profile into the application
        Args:
        user(User): Attributes of the user like name, lastname, email and password
        Role (str): Role of the user
        """
        User.name = input("Enter your name: ")
        User.lastname = input("Enter your lastname: ")
        User.email = input("Enter your email: ")
        for email in User_List:
            if User.email == email:
                print("This email is already registered, try again")
        User.password = input("Enter your password: ")
        User.role = input("Seleccione su rol: ")
        # TODO Finish method
        
    def modify_profile(self, user: User):
        """This method is for change or modify some characteristics of the user
        Args:
        user(User): Attributes of the user
        """
        User.email = input("Enter your new email: ")
        User.password = input("Enter your new password: ")
    # TODO Finish method




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
        Applicant.age = input("Enter your age: ")
        if Applicant.age < 18 or age > 100:
            print("Enter a valid age.")
        Applicant.city = input("Enter your city of residence: ")
        # TODO finish method



class Employer(User):
    """This class is a specialization of the class User"""
    def __init__(self, name:str, lastname:str, email: str, password: str, 
                 phone_number: int, company: Company):
        super().__init__(name = name, lastname= lastname,email= email, password= password, Company= company)
        self.phone_number = phone_number
        self.available_offers = []
        # TODO Create and definite the restant attributes
    def show_lists(self, applicant: Applicant):
        """This method shows a list with the amount of persons that applies to the jobs.
        Args:
        applicant(Applicant): Attributes of the applicant.
        """
        # TODO Do the method
    
class Administrator(User):
    """This class is a specialization of the class User"""
    def __init__(self, name: str, lastname: str, email: str, password:str, is_Administrator: bool):
        super.__init__(name= name, lastname= lastname, email= email, password= password)
        self.is_administrator = is_Administrator
        self.available_companies = []
        # TODO Create and definite the restant attributes
        
    def generate_statistics(self, applicant: Applicant, employer: Employer, job_offer:job_Offer):
        """This method allows that the administrator generate statistics about the application
        Args:
        applicant(Applicant): Attributes of the applicant.
        employer(Employer): Attributes of the employer.
        job_offer(Job_offer): Information about the job´s offers availables into the application
        """
        # TODO Do the method