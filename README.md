Hospital Management System
Commands to run the program : 
1. Open the terminal where the code file has been saved (Hospitalmanagement.java)
2. Next compile the code file with the command javac Hospitalmanagement.java
3. And after successful compilation run the code by using the command java Hospitalmanagement.
4. After which the GUI of the hospital management system.


# Code Description :
This Java program implements a Hospital Management System, designed to simulate various operations within a hospital environment using object-oriented principles and a simple graphical user interface (GUI). Let's walk through the code step by step to understand its structure, functionality, and how it mimics a real-world hospital system.

# 1. Class Overview
The program consists of several classes, each representing a specific entity or functionality in the hospital. Here's a brief overview of each class:

Person Class
The Person class serves as the foundational class for all individuals in the hospital, whether they are doctors, patients, or receptionists. It contains basic personal details like:
Name
Age
Gender
Contact Information
This class provides methods to retrieve these details and return them in a formatted string, which will later be useful for displaying information in the GUI.

Doctor Class
The Doctor class extends the Person class, meaning it inherits the basic attributes (name, age, etc.) from the Person class. However, it adds more specialized attributes related to the doctor's role:
Specialization (e.g., cardiology, orthopedics)
Doctor ID
Salary
Assigned Patients: A list of patients assigned to the doctor.
Methods in this class allow assigning and removing patients from the doctor's list and prescribing medications to the patients.

Patient Class
Like the Doctor class, the Patient class extends the Person class, but it represents a patient in the hospital system. It adds attributes specific to patients:
Patient ID
Prescribed Medications: A list of medications assigned to the patient.
Assigned Doctor: The doctor currently responsible for the patient’s care.
Medical Records: A list of medical records for the patient.
Methods here allow adding medications, assigning a doctor, and adding medical records to a patient's file.

Receptionist Class
The Receptionist class, another extension of the Person class, represents the hospital receptionist. It adds attributes specific to the receptionist role:
Employee ID
Shift Timings
Though not directly used in this code, the receptionist class could be responsible for scheduling appointments or handling patient registrations in a more fully developed system.

Appointment Class
The Appointment class represents an appointment between a doctor and a patient. It contains:
Appointment ID
Doctor
Patient
Appointment Date
It also includes methods for scheduling and canceling appointments, updating the doctor’s assigned patients.

Hospital Class
The Hospital class encapsulates the entire hospital. It holds general hospital information such as:
Hospital Name
Address
Departments: A list of hospital departments (though not used directly in the GUI).
Doctors: A list of all doctors in the hospital.
Patients: A list of all patients.
This class allows adding and removing doctors, patients, and departments, which simulates the management of personnel and patients.

Department Class
The Department class represents a hospital department (e.g., Cardiology, Pediatrics). It contains:
Department Name
Doctors in that Department
Patients in that Department
It provides methods to add or remove doctors and patients from the department, offering flexibility in managing hospital resources.

Billing Class
The Billing class models the billing system, allowing the generation of medical bills for patients. It stores:
Bill ID
Patient
Amount
It includes a method to print out the bill for a patient, showing the bill ID, patient's name, and the total amount.

Medicalrecord Class
The Medicalrecord class is used to store a patient’s medical history, including:
Record ID
Diagnosis
Treatment
It provides a method to update medical records with new diagnoses or treatments.

# 2. Graphical User Interface (GUI) and Functionality
The Hospitalmanagement class is the GUI interface of the application. It extends JFrame and provides a window with buttons to interact with the hospital system. Here's how the interface works:

Layout: The GUI uses a BorderLayout, where the left side (West) holds a panel with various buttons (for adding doctors, patients, scheduling appointments, etc.), and the right side (Center) holds a JTextArea that displays information about the hospital’s current status (like newly added doctors, patients, etc.).

Buttons: There are several buttons in the GUI, each linked to specific actions. For example:
Add Doctor: Prompts the user to input details about a doctor, then adds the doctor to the hospital and updates the display area.
Add Patient: Prompts the user for patient details, adds the patient to the system, and updates the display area.
Assign Doctor to Patient: Allows the user to assign a specific doctor to a patient.
Schedule Appointment: Schedules an appointment between a patient and a doctor on a given date.
Generate Bill: Generates a bill for a patient by specifying the amount due.
Each button uses JOptionPane to interact with the user, collecting necessary data like names, IDs, contact information, and medical details. After the data is entered, the system updates the JTextArea to reflect the changes (e.g., "Added Patient: John Doe").

# 3. Key Methods
Add Doctor/Patient: Methods like addDoctor() and addPatient() prompt the user to input details about a doctor or a patient, then create instances of the corresponding class and add them to the hospital.
Assign Doctor to Patient: The assignDoctor() method allows the user to assign a doctor to a patient by entering their IDs. The system checks if both the patient and doctor exist, then links them together.
Schedule Appointment: The scheduleAppointment() method allows the user to create an appointment between a doctor and a patient, specifying the date and scheduling it.
Generate Bill: The generateBill() method creates a bill for a patient by entering an amount, then prints the bill details in the console.

# 4. Overall Structure and Flow
User Interaction: The user interacts with the system through the GUI, using buttons to perform different actions (e.g., adding a doctor, scheduling an appointment).
Data Handling: Data about doctors, patients, appointments, etc., is handled using object instances. These instances are created and modified based on user input.
Display Updates: After any action is performed (such as adding a doctor or scheduling an appointment), the JTextArea is updated to reflect the new information about the hospital’s status.
Data Persistence: The program does not implement any kind of persistent storage (e.g., a database). All data is stored temporarily in memory, meaning that once the program is closed, all information is lost.
# 5. Final Thoughts
This Hospital Management System is a simplified simulation of the real-world operations in a hospital. It demonstrates how various entities—such as doctors, patients, and appointments—can interact with each other through well-defined object-oriented design. The GUI allows for easy interaction with the system, providing a straightforward way to add and manage hospital staff and patients.


This system serves as a foundational structure for more complex hospital management applications, with room for further enhancements and features.
