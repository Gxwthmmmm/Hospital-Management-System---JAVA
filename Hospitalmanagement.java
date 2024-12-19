import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
class Person{
    public String name;
    public int age;
    public String gender;
    public String contact;
    Person(String name,int age,String gender,String contact){
        this.name=name;
        this.age=age;
        this.gender=gender;
        this.contact=contact;
    }

    public String getpersonname(){
        return this.name;
    }

    public int getpersonage(){
        return this.age;
    }

    public String getpersongender(){
        return this.gender;
    }

    public String getpersoncontact(){
        return this.contact;
    }

    public String getdetails(){
        String str1=getpersonname();
        int str2=getpersonage();
        String str3=getpersongender();
        String str4=getpersoncontact();
        String res ="Name: "+str1+", Age: "+str2+", Gender: "+str3+", Contact: "+str4;
        return res;
    }
}

class Doctor extends Person{
    public String specialization;
    public String doctorid;
    public double salary;
    public ArrayList<Patient> assignedpatients;

    Doctor(String name,int age,String gender,String contact,String specialization,String doctorid,double salary){
        super(name,age,gender,contact);
        this.specialization=specialization;
        this.doctorid=doctorid;
        this.salary=salary;
        this.assignedpatients=new ArrayList<>();
    }

    public void assignpatient(Patient patient){
        assignedpatients.add(patient);
    }

    public void removepatient(Patient patient){
        assignedpatients.remove(patient);
    }

    public void prescribemedication(Patient patient, String medication){
        patient.addmedications(medication);
    }
}

class Patient extends Person{
    public String patientid;
    public ArrayList<String> prescribedmedications;
    public Doctor doctorassigned;
    public ArrayList<Medicalrecord> medicalRecords;

    Patient(String name,int age,String gender,String contact,String patientid){
        super(name,age,gender,contact);
        this.patientid=patientid;
        this.prescribedmedications=new ArrayList<>();
        this.medicalRecords=new ArrayList<>();
    }

    public void addmedications(String medication){
        this.prescribedmedications.add(medication);
    }

    public ArrayList<String> getprescription(){
        return this.prescribedmedications;
    }

    public void assigndoctor(Doctor doctor){
        this.doctorassigned=doctor;
    }

    public void addMedicalRecord(Medicalrecord record){
        this.medicalRecords.add(record);
    }
}

class Receptionist extends Person{
    public String employeeid;
    public String shifttimings;

    Receptionist(String name,int age,String gender,String contact,String employeeid,String shifttimings){
        super(name,age,gender,contact);
        this.employeeid=employeeid;
        this.shifttimings=shifttimings;
    }

    public void scheduleappointment(Doctor doctor,Patient patient,String date){
    }
}

class Appointment{
    public String appointmentid;
    public Doctor doctor;
    public Patient patient;
    public String appointmentdate;

    Appointment(String appointmentid,Doctor doctor,Patient patient,String appointmentdate){
        this.appointmentid=appointmentid;
        this.doctor=doctor;
        this.patient=patient;
        this.appointmentdate=appointmentdate;
    }

    public void schedule(){
        this.doctor.assignpatient(patient);
    }

    public void cancel(){
        this.doctor.removepatient(patient);
    }
}

class Hospital{
    private String hospitalname;
    private String address;
    private ArrayList<Department> departments;
    private ArrayList<Doctor> doctors;
    private ArrayList<Patient> patients;

    Hospital(String hospitalname,String address){
        this.hospitalname=hospitalname;
        this.address=address;
        this.departments=new ArrayList<>();
        this.doctors=new ArrayList<>();
        this.patients=new ArrayList<>();
    }

    public void adddepartment(Department department){
        departments.add(department);
    }

    public void adddoctor(Doctor doctor){
        doctors.add(doctor);
    }

    public void addpatient(Patient patient){
        patients.add(patient);
    }

    public void removedoctor(Doctor doctor){
        doctors.remove(doctor);
    }

    public void removepatient(Patient patient){
        patients.remove(patient);
    }

    public ArrayList<Doctor> getdoctors(){
        return this.doctors;
    }

    public ArrayList<Patient> getpatients(){
        return this.patients;
    }
}

class Department{
    private String departmentname;
    private ArrayList<Doctor> doctors;
    private ArrayList<Patient> patients;

    Department(String departmentname){
        this.departmentname=departmentname;
        this.doctors=new ArrayList<>();
        this.patients=new ArrayList<>();
    }

    public void adddoctor(Doctor doctor){
        this.doctors.add(doctor);
    }

    public void addpatient(Patient patient){
        this.patients.add(patient);
    }

    public void removedoctor(Doctor doctor){
        this.doctors.remove(doctor);
    }

    public void removepatient(Patient patient){
        this.patients.remove(patient);
    }

    public String getdepartmentname(){
        return this.departmentname;
    }
}

class Billing{
    public String billid;
    public Patient patient;
    public double amount;

    Billing(String billid,Patient patient,double amount){
        this.billid=billid;
        this.patient=patient;
        this.amount=amount;
    }
    public void printbill(){
        System.out.println("Bill ID: "+billid+", Patient: "+this.patient.name+", Amount: rupees"+this.amount);
    }
}

class Medicalrecord{
    public String recordid;
    public Patient patient;
    public String diagnosis;
    public String treatment;

    Medicalrecord(String recordid,Patient patient,String diagnosis,String treatment){
        this.recordid=recordid;
        this.patient=patient;
        this.diagnosis=diagnosis;
        this.treatment=treatment;
    }

    public void updateRecord(String diagnosis,String treatment){
        this.diagnosis=diagnosis;
        this.treatment=treatment;
    }
}

public class Hospitalmanagement extends JFrame{
    private Hospital hospital;
    private JTextArea displayArea;

    public Hospitalmanagement(){
        hospital=new Hospital("City Hospital", "123 Main St");
        displayArea=new JTextArea(20, 40);
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);
        setLayout(new BorderLayout());
        setTitle("Hospital Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel=new JPanel();
        panel.setLayout(new GridLayout(8, 1, 10, 10));
        JButton addDoctorButton = createButton("Add Doctor");
        addDoctorButton.addActionListener(e -> addDoctor());
        panel.add(addDoctorButton);
        JButton addPatientButton = createButton("Add Patient");
        addPatientButton.addActionListener(e -> addPatient());
        panel.add(addPatientButton);
        JButton assignDoctorButton = createButton("Assign Doctor to Patient");
        assignDoctorButton.addActionListener(e -> assigndoctor());
        panel.add(assignDoctorButton);
        JButton scheduleAppointmentButton = createButton("Schedule Appointment");
        scheduleAppointmentButton.addActionListener(e -> scheduleAppointment());
        panel.add(scheduleAppointmentButton);
        JButton generateBillButton = createButton("Generate Bill");
        generateBillButton.addActionListener(e -> generateBill());
        panel.add(generateBillButton);
        JButton addMedicalRecordButton = createButton("Add Medical Record");
        addMedicalRecordButton.addActionListener(e -> addMedicalRecord());
        panel.add(addMedicalRecordButton);
        JButton addReceptionistButton = createButton("Add Receptionist");
        addReceptionistButton.addActionListener(e -> addReceptionist());
        panel.add(addReceptionistButton);
        add(panel, BorderLayout.WEST);
        add(scrollPane, BorderLayout.CENTER);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JButton createButton(String text){
        JButton button=new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setPreferredSize(new Dimension(200, 50));
        return button;
    }

    private void addDoctor(){
        String name=JOptionPane.showInputDialog(this, "Enter Doctor's Name:");
        int age=Integer.parseInt(JOptionPane.showInputDialog(this, "Enter Doctor's Age:"));
        String gender=JOptionPane.showInputDialog(this, "Enter Doctor's Gender:");
        String contact=JOptionPane.showInputDialog(this, "Enter Doctor's Contact:");
        String specialization=JOptionPane.showInputDialog(this, "Enter Specialization:");
        String doctorid=JOptionPane.showInputDialog(this, "Enter Doctor's ID:");
        double salary=Double.parseDouble(JOptionPane.showInputDialog(this, "Enter Doctor's Salary:"));
        Doctor doctor=new Doctor(name, age, gender, contact, specialization, doctorid, salary);
        hospital.adddoctor(doctor);
        displayArea.append("Added Doctor: " + doctor.getdetails() + "\n");
    }

    private void addPatient(){
        String name=JOptionPane.showInputDialog(this, "Enter Patient's Name:");
        int age=Integer.parseInt(JOptionPane.showInputDialog(this, "Enter Patient's Age:"));
        String gender=JOptionPane.showInputDialog(this, "Enter Patient's Gender:");
        String contact=JOptionPane.showInputDialog(this, "Enter Patient's Contact:");
        String patientid=JOptionPane.showInputDialog(this, "Enter Patient's ID:");
        Patient patient=new Patient(name, age, gender, contact, patientid);
        hospital.addpatient(patient);
        displayArea.append("Added Patient: " + patient.getdetails() + "\n");
    }

    private void assigndoctor(){
        String patientID=JOptionPane.showInputDialog(this, "Enter Patient ID:");
        String doctorID=JOptionPane.showInputDialog(this, "Enter Doctor ID:");
        Patient patient=findPatientById(patientID);
        Doctor doctor=findDoctorById(doctorID);
        if (patient!=null && doctor!=null){
            patient.assigndoctor(doctor);
            doctor.assignpatient(patient);
            displayArea.append("Assigned Doctor: " + doctor.getpersonname() + " to Patient: " + patient.getpersonname() + "\n");
        } 
        else{
            displayArea.append("Patient or Doctor not found.\n");
        }
    }

    private void addMedicalRecord() {
        String patientID=JOptionPane.showInputDialog(this, "Enter Patient ID:");
        String diagnosis=JOptionPane.showInputDialog(this, "Enter Diagnosis:");
        String treatment=JOptionPane.showInputDialog(this, "Enter Treatment:");
        Patient patient=findPatientById(patientID);
        if (patient!=null){
            String recordID="MR"+System.currentTimeMillis();
            Medicalrecord record=new Medicalrecord(recordID,patient,diagnosis,treatment);
            patient.addMedicalRecord(record);
            displayArea.append("Added Medical Record for Patient: "+patient.getpersonname()+"\n");
        } 
        else{
            displayArea.append("Patient not found.\n");
        }
    }

    private void addReceptionist(){
        String name=JOptionPane.showInputDialog(this, "Enter Receptionist's Name:");
        int age=Integer.parseInt(JOptionPane.showInputDialog(this, "Enter Receptionist's Age:"));
        String gender=JOptionPane.showInputDialog(this, "Enter Receptionist's Gender:");
        String contact=JOptionPane.showInputDialog(this, "Enter Receptionist's Contact:");
        String employeeID=JOptionPane.showInputDialog(this, "Enter Receptionist's ID:");
        String shiftTimings=JOptionPane.showInputDialog(this, "Enter Receptionist's Shift Timings:");
        Receptionist receptionist=new Receptionist(name,age,gender,contact,employeeID,shiftTimings);
        displayArea.append("Added Receptionist: "+receptionist.getdetails() + "\n");
    }

    private Patient findPatientById(String patientID){
        for (Patient patient : hospital.getpatients()){
            if (patient.patientid.equals(patientID)){
                return patient;
            }
        }
        return null;
    }

    private Doctor findDoctorById(String doctorID){
        for (Doctor doctor : hospital.getdoctors()){
            if (doctor.doctorid.equals(doctorID)){
                return doctor;
            }
        }
        return null;
    }

    private void scheduleAppointment(){
        String appointmentID=JOptionPane.showInputDialog(this, "Enter Appointment ID:");
        String patientID=JOptionPane.showInputDialog(this, "Enter Patient ID:");
        String doctorID=JOptionPane.showInputDialog(this, "Enter Doctor ID:");
        String date=JOptionPane.showInputDialog(this, "Enter Appointment Date:");
        Patient patient=findPatientById(patientID);
        Doctor doctor=findDoctorById(doctorID);
        if (patient!=null && doctor!=null){
            Appointment appointment = new Appointment(appointmentID, doctor, patient, date);
            appointment.schedule();
            displayArea.append("Appointment Scheduled: " + appointment.appointmentdate + "\n");
        } 
        else{
            displayArea.append("Patient or Doctor not found.\n");
        }
    }

    private void generateBill(){
        String patientID=JOptionPane.showInputDialog(this, "Enter Patient ID:");
        Patient patient=findPatientById(patientID);
        if (patient!=null){
            String amountInput=JOptionPane.showInputDialog(this, "Enter Bill Amount:");
            double amount=Double.parseDouble(amountInput); 
            Billing bill=new Billing("BILL123", patient, amount);
            bill.printbill();
        } 
        else{
            displayArea.append("Patient not found.\n");
        }
    }

    public static void main(String[] args){
        new Hospitalmanagement();
    }
}
