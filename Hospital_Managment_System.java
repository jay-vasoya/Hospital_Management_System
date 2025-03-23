import java.util.*;

//doctor class 
class doctor {
    Scanner sc = new Scanner(System.in);
    String name, docID;
    int age, joiningYear, expOfDoc, birthYear;
    double salary;
    String address;
    String catagory;
    String availability = "Available";

    // set doctor's information.
    void setData() {
        System.out.println("\n===============================================\n");
        System.out.print("Enter Doctor's name : ");
        name = sc.nextLine();
        System.out.print("Enter joining year : ");
        joiningYear = sc.nextInt();
        System.out.print("Enter doctor's birth year : ");
        birthYear = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter doctor's address : ");
        address = sc.nextLine();
        System.out.print("Enter doctor's age : ");
        age = sc.nextInt();
        System.out.print("Enter salary : ");
        salary = sc.nextDouble();
        sc.nextLine();
        // calculating Experience.
        expOfDoc = joiningYear - 2024;
        System.out.print("Enter doctor's catagory(Basic, Normal, High) : ");
        catagory = sc.nextLine();
        // generating Doctor's id.
        generateDocId();
        System.out.println("\n===============================================\n");
    }

    void generateDocId() {// for generate Doctor's id.
        String Name[] = name.split(" ");
        docID = Name[0] + birthYear;
        System.out.println("Doc ID is : " + docID);
    }

    void aprisalForDoc(doctor doc[]) {// for salary increase.
        if (expOfDoc >= 20) {
            salary = salary + (salary * 0.15) + 1500;
        } else if (expOfDoc >= 10) {
            salary = salary + (salary * 0.1);
        } else if (expOfDoc <= 5) {
            salary = salary + (salary * 0.05);
        }
    }

    void getData() {// print data.
        System.out.println("\n===============================================\n");
        System.out.println("Doctor's name : " + name);
        System.out.println("Doctor's joining year : " + joiningYear);
        System.out.println("Doctor's age : " + age);
        System.out.println("salary : " + salary);
        System.out.println("Doctor's address : " + address);
        System.out.println("Doctor's catagory : " + catagory);
        System.out.println("Doctor's availability : " + availability);
        System.out.println("Doc ID is : " + docID);
        System.out.println("\n===============================================\n");
    }

    void removeDoc() {// for removing doctor's data.
        name = null;
        docID = null;
        age = 0;
        birthYear = 0;
        expOfDoc = 0;
        joiningYear = 0;
        salary = 0;
        address = null;
        catagory = null;
        availability = null;
    }

    int search(doctor doc[]) {// for search perticular doctor.
        System.out.println("\n===============================================\n");
        System.out.print("Enter doctor's Id : ");
        String checkId = sc.nextLine();
        int idx = (-1);
        for (int i = 0; i < doc.length; i++) {
            // If doctor ID matches return it's idex.
            if (checkId.equals(doc[i].docID)) {
                idx = i;
                break;
            }
        }
        // IF doctor ID not matches than return -1.
        return idx;
    }

    // for sorting doc by salary high to low
    void sortDocBySalaryHighToLow(doctor doc[]) {
        doctor temp = new doctor();
        for (int i = 0; i < doc.length; i++) {
            for (int j = i; j < doc.length; j++) {
                if (doc[i].salary < doc[j].salary) {
                    temp = doc[i];
                    doc[i] = doc[j];
                    doc[j] = temp;
                }
            }
        }
    }

    // for sorting doc by salary low to high
    void sortDocBySalaryLowToHigh(doctor doc[]) {
        doctor temp = new doctor();
        for (int i = 0; i < doc.length; i++) {
            for (int j = i; j < doc.length; j++) {
                if (doc[i].salary > doc[j].salary) {
                    temp = doc[i];
                    doc[i] = doc[j];
                    doc[j] = temp;
                }
            }
        }
    }

    // For update doctor's information.
    void updateData(doctor doc[]) {
        // For finding doctor for update his information.
        int idx = search(doc);
        if (idx == (-1)) {
            System.out.println("No such doctor found.");
        } else {
            int choice;
            do {
                System.out.println("\n===============================================\n");
                System.out.println(
                        " Press 1 for change name. \n Press 2 for change age. \n Press 3 for change address. \n Press 4 for change joining date. \n Press 5 for changing birth year. \n Press 6 for exit.");
                System.out.print("Enter your choice : ");
                choice = sc.nextInt();
                System.out.println("\n===============================================\n");
                switch (choice) {
                    case 1:
                        System.out.print("Enter new name : ");
                        doc[idx].name = sc.nextLine();
                        // for generating new doctor ID.
                        generateDocId();
                        break;
                    case 2:
                        System.out.print("Enter new age : ");
                        doc[idx].age = sc.nextInt();
                        break;
                    case 3:
                        System.out.print("Enter new address : ");
                        doc[idx].address = sc.nextLine();
                        break;
                    case 4:
                        System.out.print("Enter new joining date : ");
                        doc[idx].joiningYear = sc.nextInt();
                        break;
                    case 5:

                        System.out.print("Enter new birth year : ");
                        doc[idx].birthYear = sc.nextInt();
                        // for generating new doctor's ID.
                        generateDocId();
                        break;
                    case 6:
                        break;
                    default:
                        System.out.println("Enter valid choice.");
                        break;
                }
            } while (choice != 6);
        }
    }

    // checking that doctor is available at emergency time.
    void isAvailable(doctor doc[]) {
        int idxForDocAvailable = search(doc);
        if (idxForDocAvailable != (-1)) {
            System.out.println("Doctor is : " + availability);
        } else {
            System.out.println("No such doctor found.");
        }
    }

    // changing doctor's availability.
    void changeAvailability(doctor doc[]) {
        int idx = search(doc);
        if (idx == (-1)) {
            System.out.println("No such doctor found.");
        } else {
            if (doc[idx].availability.equals("Available")) {
                doc[idx].availability = "Not Available";
            } else {
                doc[idx].availability = "Available";
            }
        }
    }
}

class patient {
    Scanner sc = new Scanner(System.in);
    String name, disease, drName, admitDate;
    int age, roomNo;
    double fees;
    long contactNo;

    // set data for patient.
    void setData(patient p[]) {
        System.out.println("\n===============================================\n");
        System.out.print("Enter patient name : ");
        name = sc.nextLine();
        System.out.print("Enter patient age : ");
        age = sc.nextInt();
        System.out.print("Enter patient contact no. : ");
        contactNo = sc.nextLong();
        sc.nextLine();
        System.out.print("Enter disease name : ");
        disease = sc.nextLine();
        System.out.print("Enter doctor name who treat : ");
        drName = sc.nextLine();
        System.out.print("Enter admit date(DD/MM/YYYY) : ");
        admitDate = sc.nextLine();
        System.out.print("Enter total hospital fees : ");
        fees = sc.nextDouble();

        // Asking that patient need to admint at hospital.
        System.out.print("Does patient need's to admit if yes press(Y/y) else (N/n) : ");
        char isNeedAdmit = sc.next().charAt(0);
        if (isNeedAdmit == 'Y' || isNeedAdmit == 'y') {
            roomNo = assignRoom(p);
            if (roomNo == (-1)) {
                // if no.
                System.out.println("No room available.");
            } else {
                // if yes than allot room for patient.
                System.out.println("Allocated Room is : " + roomNo);
            }
        }
        System.out.println("\n===============================================\n");
    }

    // For hospital
    void paidFees() {
        System.out.print("Enter amount of fees that paid : ");
        double paidFee = sc.nextDouble();
        fees = fees - paidFee;
    }

    // for printing patient's detail.
    void getData() {
        System.out.println("\n===============================================\n");
        System.out.println("Patient name : " + name);
        System.out.println("Patient age : " + age);
        System.out.println("Patient disease : " + disease);
        System.out.println("Patient Room No. : " + roomNo);
        System.out.println("Patient contact No. : " + contactNo);
        System.out.println("Doctor name : " + drName);
        System.out.println("Patient's pending fees : " + fees);
        System.out.println("Admit date : " + admitDate);
        System.out.println("\n===============================================\n");
    }

    // for find perticular patient.
    int searchPatient(patient p[]) {
        System.out.print("Enter patient name : ");
        String pName = sc.nextLine();
        for (int i = 0; i < p.length; i++) {
            if (p[i].name.equals(pName)) {
                return i;
            }
        }
        return (-1);
    }

    // for removing patient.
    void remove() {
        if (fees != 0) {
            System.out.println("Fees are not paid yet. So that you can not remove patient.");
        } else {
            name = null;
            drName = null;
            age = 0;
            roomNo = 0;
            contactNo = 0;
            admitDate = null;
            disease = null;
        }
    }

    // for assigning room to patient.
    int assignRoom(patient p[]) {
        // for checking room is available or not.
        boolean check = true;
        for (int i = 101; i <= 110; i++) {
            check = true;
            for (int j = 0; j < p.length; j++) {
                if (i == p[j].roomNo) {
                    check = false;
                    break;
                }
            }
            if (check == true) {
                return i;
            }
        }
        // if room is not available than return -1.
        return (-1);
    }

    // for update patient detail.
    void update() {
        int choice;
        do {
            System.out.println("\n===============================================\n");
            System.out.println(
                    " Press 1 for change patient name. \n Press 2 for change disease name. \n Press 3 for change doctor name. \n Press 4 for change age. \n Press 5 for change Room no. \n Press 6 for change contact No. \n Press 7 for exir.");
            System.out.print("Enter your choice : ");
            choice = sc.nextInt();
            System.out.println("\n===============================================\n");
            switch (choice) {
                case 1:
                    sc.nextLine();
                    System.out.print("Enter new name : ");
                    name = sc.nextLine();
                    break;
                case 2:
                    sc.nextLine();
                    System.out.print("Enter new disease name : ");
                    disease = sc.nextLine();
                    break;
                case 3:
                    sc.nextLine();
                    System.out.print("Enter new Doctor name : ");
                    drName = sc.nextLine();
                    break;
                case 4:
                    System.out.print("Enter new age : ");
                    age = sc.nextInt();
                    break;
                case 5:
                    System.out.print("Enter new Room No. : ");
                    roomNo = sc.nextInt();
                    break;
                case 6:
                    System.out.print("Enter new contact no. : ");
                    contactNo = sc.nextLong();
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Enter valid choice.");
                    break;
            }
        } while (choice != 7);
    }
}

class staff {
    Scanner sc = new Scanner(System.in);
    String name, staffID;
    int age;
    double salary;
    int dateOfBirth, joiningYear, Experience;

    // for set staff's data.
    void setData() {

        System.out.println("\n===============================================\n");
        System.out.print("Enter name : ");
        name = sc.nextLine();
        System.out.print("Enter age : ");
        age = sc.nextInt();
        System.out.print("Enter year of Birth : ");
        dateOfBirth = sc.nextInt();
        System.out.print("Enter year of joining : ");
        joiningYear = sc.nextInt();
        System.out.print("Enter salary : ");
        salary = sc.nextDouble();
        sc.nextLine();
        // calculating experience
        Experience = 2024 - joiningYear;
        // generating staff ID.
        generateID();
        System.out.println("\n===============================================\n");
    }

    // Printing staff data.
    void getData() {
        System.out.println("\n===============================================\n");
        System.out.println("Name : " + name);
        System.out.println("Age : " + age);
        System.out.println("Date of birth : " + dateOfBirth);
        System.out.println("Joining year : " + joiningYear);
        System.out.println("Salary : " + salary);
        System.out.println("Experience : " + Experience);
        System.out.println("Staff ID : " + staffID);
        System.out.println("\n===============================================\n");
    }

    // generating staff ID.
    void generateID() {
        String[] name1 = name.split(" ");
        // use first name and year of birth.
        staffID = name1[0] + dateOfBirth;
        System.out.println("Staff ID : " + staffID);
    }

    // for find perticuler pateint.
    int searchStaff(staff s[]) {
        System.out.print("Enter Staff ID : ");
        String id = sc.nextLine();
        for (int i = 0; i < s.length; i++) {
            if (s[i].staffID.equals(id)) {
                return i;
            }
        }
        // if staff not found than return -1. that means staff not found.
        return (-1);
    }

    // for removing staff
    void removeStaff() {
        name = null;
        staffID = null;
        age = 0;
        salary = 0;
        dateOfBirth = 0;
        joiningYear = 0;
    }

    // for update staff information.
    void updateStaffData() {
        int choice;
        do {
            System.out.println("\n===============================================\n");
            System.out.println(
                    " Press 1 for update name. \n Press 2 for age. \n Press 3 for date of birth. \n Press 4 for joining year. \n Press 5 for exit.");
            System.out.print("Enter your choice : ");
            choice = sc.nextInt();
            System.out.println("\n===============================================\n");
            switch (choice) {
                case 1:
                    sc.nextLine();
                    System.out.print("Enter new name : ");
                    name = sc.nextLine();
                    generateID();
                    System.out.println("New staff ID : " + staffID);
                    break;

                case 2:
                    System.out.print("Enter new age : ");
                    age = sc.nextInt();
                    break;
                case 3:
                    System.out.print("Enter new date of birth :");
                    dateOfBirth = sc.nextInt();
                    generateID();
                    System.out.println("New staff ID : " + staffID);
                    break;
                case 4:
                    System.out.print("Enter new joining date : ");
                    joiningYear = sc.nextInt();
                    Experience = joiningYear - 2024;
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Enter valid number.");
                    break;
            }
        } while (choice != 5);
    }

    // calculating salary increase.
    void aprisal() {
        if (Experience >= 20) {
            salary = salary + (salary * 0.1);
        } else if (Experience >= 15) {
            salary = salary + (salary * 0.05) + 1000;
        } else if (Experience <= 5) {
            salary = salary + (salary * 0.05);
        }
    }

    // sorting staff by salary low to high.
    void sortSalaryLowToHigh(staff s[]) {
        staff staffForSort = new staff();
        for (int i = 0; i < s.length; i++) {
            for (int j = i; j < s.length; j++) {
                if (s[i].salary > s[j].salary) {
                    staffForSort = s[i];
                    s[i] = s[j];
                    s[j] = staffForSort;
                }
            }
        }
    }

    // sorting staff by salary high to low.
    void sortSalaryHighToLow(staff s[]) {
        staff staffForSort = new staff();
        for (int i = 0; i < s.length; i++) {
            for (int j = i; j < s.length; j++) {
                if (s[i].salary < s[j].salary) {
                    staffForSort = s[i];
                    s[i] = s[j];
                    s[j] = staffForSort;
                }
            }
        }
    }
}

class hospital {
    Scanner sc = new Scanner(System.in);

    // useDoc method for use doctor class various method.
    void useDoc(doctor doc[]) {
        doctor doc1 = new doctor();
        int choice, countDoc = 0;
        do {
            System.out.println("\n===============================================\n");
            System.out.println(
                    " Press 1 for set doctor's data. \n Press 2 for Print doctor's data. \n Press 3 for search doctor. \n Press 4 for update doctor's information. \n Press 5 for change doctor's availability. \n Press 6 for do apraisal. \n Press 7 for remove doctor. \n Press 8 for sort doctor by higher to lower salary. \n Press 9 for sort doctor by Lower to higher salary. \n Press 10 for checking doctor's availability. \n Press 11 for exit.");
            System.out.print("Enter your choice : ");
            choice = sc.nextInt();
            sc.nextLine();
            System.out.println("\n===============================================\n");
            switch (choice) {
                case 1:
                    // for checking any vacant available or not.
                    boolean isEmotySlot = false;
                    if (countDoc != doc.length) {
                        // when vacant is not full.
                        doc[countDoc].setData();
                    } else {
                        // when vacant is full check that that any doctor leave the hospital then add
                        // new doctor.
                        for (int i = 0; i < doc.length; i++) {
                            if (doc[i].name == null) {
                                doc[i].setData();
                                isEmotySlot = true;
                                break;
                            }
                        }
                    }
                    // when vacant is full and no doctor leaves hospital.
                    if (isEmotySlot == false) {
                        System.out.println("There is no vacant available for doctor.");
                    }
                    break;
                case 2:
                    for (int i = 0; i < doc.length; i++) {
                        if (doc[i].name == null) {
                        } else {
                            doc[i].getData();
                        }
                    }
                    break;
                case 3:
                    int idx = doc1.search(doc);
                    if (idx == (-1)) {
                        System.out.println("No such doctor found.");
                    } else {
                        doc[idx].getData();
                    }
                    break;
                case 4:
                    doc1.updateData(doc);
                    break;
                case 5:
                    doc1.changeAvailability(doc);
                    break;
                case 6:
                    doc1.aprisalForDoc(doc);
                    break;
                case 7:
                    int idxForRemove = doc1.search(doc);
                    if (idxForRemove != (-1)) {
                        doc[idxForRemove].removeDoc();
                    } else {
                        System.out.println("No such doctor available.");
                    }
                    break;
                case 8:
                    doc1.sortDocBySalaryHighToLow(doc);
                    break;
                case 9:
                    doc1.sortDocBySalaryLowToHigh(doc);
                    break;
                case 10:
                    doc1.isAvailable(doc);
                    break;
                case 11:
                    break;
                default:
                    System.out.println("Enter valid choice.");
                    break;
            }

        } while (choice != 11);
    }

    // usePatientClass method has various method of patient class.
    void usePatientClass(patient p[]) {
        patient p1 = new patient();
        int choice, count = 0;
        do {
            System.out.println("\n===============================================\n");
            System.out.println(
                    " Press 1 for add patient data. \n Press 2 for print all patient data. \n Press 3 for remove patient. \n Press 4 for search Patient. \n Press 5 for update patient data. \n Press 6 for payment.\n Press 7 for exit.");
            System.out.print("Enter your choice : ");
            choice = sc.nextInt();
            System.out.println("\n===============================================\n");
            switch (choice) {
                case 1:
                    if (count != p.length) {
                        // when patient slot is not full.
                        p[count].setData(p);
                        count++;
                    } else {
                        // for checking patient slot is available ot not.
                        boolean flag = false;
                        for (int i = 0; i < p.length; i++) {
                            // When patient slot is full and some patient get recovered(means removed) than
                            // add new patient at that patient's place.
                            if (p[i].name == null) {
                                p[i].setData(p);
                                flag = true;
                            }
                        }
                        if (flag == false) {
                            // when patient slot is full and no available any slot.
                            System.out.println("You already reach limit to add patient.");
                        }
                    }
                    break;
                case 2:
                    for (int i = 0; i < p.length; i++) {
                        if (p[i].name == null) {
                        } else {
                            p[i].getData();
                        }
                    }
                    break;
                case 3:
                    int idx = p1.searchPatient(p);
                    if (idx != (-1)) {
                        p[idx].remove();
                    } else {
                        System.out.println("No such patient found");
                    }
                    break;
                case 4:
                    int searchIdx = p1.searchPatient(p);
                    if (searchIdx != (-1)) {
                        p[searchIdx].getData();
                    } else {
                        System.out.println("No such patient found");
                    }
                    break;
                case 5:
                    int idxForUpdate = p1.searchPatient(p);
                    if (idxForUpdate != (-1)) {
                        p[idxForUpdate].update();
                    } else {
                        System.out.println("No such patient found");
                    }
                    break;
                case 6:
                    int idxForPayment = p1.searchPatient(p);
                    if (idxForPayment != (-1)) {
                        p[idxForPayment].paidFees();
                    } else {
                        System.out.println("No such patient found.");
                    }
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Enter valid choice.");
                    break;
            }
        } while (choice != 7);
    }

    // useStaffClass method for use various staff class method.
    void useStaffClass(staff s[]) {
        int choice, countForStaff = 0;
        staff s1 = new staff();
        do {
            System.out.println("\n===============================================\n");
            System.out.println(
                    " Press 1 for add staff. \n Press 2 for update staff info. \n Press 3 for remove staff member. \n Press 4 for Print all staff detail. \n Press 5 for search staff. \n Press 6 for count aprisal. \n Press 7 for sort staff by it's salary low to high. \n Press 8 forsort staff by it's salary high to low. \n Press 9 for exit.");
            System.out.println("\n===============================================\n");
            System.out.print("Enter your choice : ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    sc.nextLine();
                    if (countForStaff != s.length) {
                        // when vacant is not full.
                        s[countForStaff].setData();
                        countForStaff++;
                    } else {
                        // for checking any vacant is available.
                        boolean checkEmptySlot = false;
                        for (int i = 0; i < s.length; i++) {
                            if (s[i].name == null) {
                                // When vacant is full and any staff leaves hospital(means removed) than add new
                                // staff member at that place.
                                s[i].setData();
                                checkEmptySlot = true;
                                break;
                            }
                        }
                        // when no vacant is available.
                        if (checkEmptySlot == false) {
                            System.out.println("There is no vacant for staff.");
                        }
                    }
                    break;
                case 2:
                    int staffIDX = s1.searchStaff(s);
                    if (staffIDX != (-1)) {
                        s[staffIDX].updateStaffData();
                    } else {
                        System.out.println("No such staff sound.");
                    }
                    break;
                case 3:
                    int IDX = s1.searchStaff(s);
                    if (IDX != (-1)) {
                        s[IDX].removeStaff();
                    } else {
                        System.out.println("No such staff found.");
                    }
                    break;
                case 4:
                    boolean isStaff = false;
                    for (int i = 0; i < s.length; i++) {
                        if (s[i].name != null) {
                            isStaff = true;
                            s[i].getData();
                        }
                    }
                    if (isStaff == false) {
                        System.out.println("You have not added satff yet.");
                    }
                    break;
                case 5:
                    int searchIdx = s1.searchStaff(s);
                    if (searchIdx != (-1)) {
                        s[searchIdx].getData();
                    } else {
                        System.out.println("No such staff found");
                    }
                    break;
                case 6:
                    for (int i = 0; i < s.length; i++) {
                        s[i].aprisal();
                    }
                    break;
                case 7:
                    s1.sortSalaryLowToHigh(s);
                    break;
                case 8:
                    s1.sortSalaryHighToLow(s);
                    break;
                case 9:
                    break;
                default:
                    System.out.println("Enter valid choice.");
                    break;
            }
        } while (choice != 9);
    }
}

// acess class is use for using various classes.
class acess {
    void acessClass(doctor doc[], patient p[], staff s[], hospital h) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n===============================================\n");
            System.out.println(
                    " Press 1 for use doctor's data class. \n Press 2 for use patient class. \n Press 3 for use staff class.");
            System.out.println("\n===============================================\n");
            System.out.print("Enter your choice : ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    h.useDoc(doc);
                    break;
                case 2:
                    h.usePatientClass(p);
                    break;
                case 3:
                    h.useStaffClass(s);
                    break;
                default:
                    break;
            }
        } while (choice != 4);
    }
}

class Hospital_Managment_System {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n=================Welcome to hospital managment system=================\n");
        System.out.print("Enter no. of doctor you want to add : ");
        int noOfDoc = sc.nextInt();
        doctor doc[] = new doctor[noOfDoc];
        System.out.print("Enter no of patient you want to add : ");
        int noOfPatient = sc.nextInt();
        patient p[] = new patient[noOfPatient];
        System.out.print("Enter no of staff ypu want to add : ");
        int noOfStaff = sc.nextInt();
        staff s[] = new staff[noOfStaff];
        hospital h = new hospital();
        acess ac = new acess();
        for (int i = 0; i < doc.length; i++) {
            doc[i] = new doctor();
        }
        for (int i = 0; i < p.length; i++) {
            p[i] = new patient();
        }
        for (int i = 0; i < s.length; i++) {
            s[i] = new staff();
        }
        ac.acessClass(doc, p, s, h);
        System.out.println("\n=================Thanks for using=================\n");
    }
}
