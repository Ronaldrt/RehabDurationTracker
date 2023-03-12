# RehabDurationTracker

Launch procedure:
1) Clone git repository: https://github.com/Ronaldrt/RehabDurationTracker.git
2) Open the project in your preferred IDE (ex. IntelliJ/Eclipse)
3) Open MySQL Workbench and create a new schema named "rehabdurationtracker"
4) In the Java project, change the username and password to correspond with your MySQL database:
   (Java class HibernateUtil -> settings.put(Environment.USER, "username");settings.put(Environment.PASS, "password");
5) Run the program

Current features:
1) Adding a patient to the database
2) In the app: Gender field takes in char values M or F. Primary diagnosis field examples: stroke, myocardial infarction, pneumonia etc.. Time of admission field takes in a date in the format dd-MM-yyyy.
   Initial duration of rehab field should be 10, 14 or 21 (in a real world scenario)
   
To be implemented:
1) Database query logic and GUI
2) Make Gender and Initial duration of rehab fields a drop down menu or checkable boxes with given values.
3) Implement logic for querying the remaining time of rehab for a single patient or all patients in the database.

Bugs:
1) After entering patient data into the app, the Add patient button needs to be clicked twice for database insertion.
