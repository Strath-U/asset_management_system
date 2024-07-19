PROJECT: Asset Management System

BRIEF: The goal of this system is to help in the management of assets such as land and real estate and vehicles the user owns.

MEMBERS: Allan Tom
         Abraham Kuol
         Peter Karagu
         Brian Mutuma
         Gioko Kioko
         Brian Mbogo
         
DESCRIPRION: The asset management system shows how the basic principles of OOP helps in establishing a cleanly, sustainably, and expandibly designed application. Thus, with the help of such principles as encapsulation, abstraction, division into components, etc, used within the program based on the principles of OOP, the program guarantees that every element is independent, reusable, and comprehensible for further creation and adjusting. 
 
OOP PRINCIPLES:
 1. Encapsulation: 
 Userdetails. Java hides user data by using ‘private’ access modifier on the fields username, password, email; access to these fields’ values are facilitated by ‘get’ and ‘set’ methods. This ensures that the internal state of the object can only be changed through these methods only thus enhancing the protection of the data. 
 2. Abstraction: 
 What is noteworthy is that the program shields the user from the complications of data base, user’s authentication and forms. For example, Databaseconnection. java shields the developer from the low-level complexities of connecting to a database, and Authentication. java just encapsulates the sign in and sign out procedures. 
 3. Separation of Concerns:
 Every class in the program conforms to the principle of SOC, where each class performs only one operation/functions. For example, Authentication. java is limited to only user authentication, database connection. java manages the database connections and the GUI of User Signup. java controls the main graphical view used to sign up new users. 
 4. Modularity: 
 The program is divided into distinguishable modules (classes) where each of those is dedicated to portraying a specific functionality. Although this modular design is highly conducive to the factor of maintainability as well as scalability of the application. 
 5. Reusability: 
 To an extent, reusability is achieved and demonstrated through the classes such as Authentication class, Databaseconnection class, and Userdetails class. These classes can be re-used throughout the application, or even in other applications with similar functionality. 
 6. Loose Coupling: 
 When designing the classes of the program, the focus is made on limiting the degree of interconnectivity of classes. For instance, Userlogin. java depends on Authentication. java for login functionality but doesn’t need to have explicit know how of how the code for authentication has been written.

CLASSES:
 1 Authentication.java: It is responsible for the control of the login and logout procedures from an application with checking of credentials and termination of session procedures. 
 2  Databaseconnection.java: Controls the creation of the links to the database, giving the way to communicates with the database. 
 3  Registrationform.java: Responsible for presenting the user registration form and for validating the users input in the form. 
 4  Userdetailretriver.java: It is used to fetch user details where the username is provided, helping in identifying the user or provide further details about him. 
 5  Userdetails.java: Fields: user; getter/setter methods for fields username, password and email. 
 6  Userlogin.java: Responsible for the user logging in and out process, which activates other methods from the Authentication class. 
 7  Userregistration.java: Supports the registration of the user in that it registers the details inputted by the user to the database. 
 8  UserSignupGUI.java: Develops the interface for actual signup of a user by providing a registration form where the user can key in his information and submit. 
 9  AssetManagementSystem.java: It is the first instance created about the application and is also responsible for launching the application.
