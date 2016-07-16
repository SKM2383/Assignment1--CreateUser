# Assignment1--CreateUser
Prototype login system

Develop a sign up and authentication module to use in applications requiring users to create account and authenticate the user before accessing the applications.

Use the attached images for the guideline of this application.

Requirements:

1. You must create a Person class with the following attributes:

     first name

     last name

     SSN

     dob

     gender

2. You must create a user class, which is inherited from Person class with the following attributes:

     Username

     email

     phone number (country code + area code + phone number)

     password

     profile photo

3. Design User interface for Sign up with all the attributes from 1 and 2. You need to add confirm password field too.

4. Validate Sign up user input for each attribute according to the rules below:

     Required field: first name, lastname, dob, gender, username, password, confirm password

5. Validate password field to include at least 1 number, 1 upper case letter, 1 lower case letter, 1 special character

6. Validate email field to be an email format xxxx@mail.xxx

7. Validate password and confirm password field must be the same

8. Profile photo stores the path to the location of the photo. Use Browse button or add button for this field when designing Sing up GUI.

9. The application will not allow duplicate username. Making sure that you will choose appropriate data structure to store user information.
