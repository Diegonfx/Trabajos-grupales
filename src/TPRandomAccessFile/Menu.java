package TPRandomAccessFile;

import java.io.*;

/**
 * Created by Tomás Iturralde on 10/12/17.
 * Materia: AyED.
 */
public class Menu {
//    public static void create(){
//        try{
//            StudentFile studentFile = new StudentFile("studentFile");
//            studentFile.write(new Student("Florencia", 'F', 12345678));
//            studentFile.write(new Student("Martin", 'M', 12654678));
//            studentFile.write(new Student("Agustin", 'M', 15432378));
//            studentFile.write(new Student("Marcos", 'M', 65421324));
//            studentFile.close();
//        }
//        catch(IOException e){
//            Visa.out.println(e.getMessage());
//        }
//    }

    public static void main(String[] args) throws IOException {
        StudentFile studentFile = new StudentFile("studentFile");
        //studentFile.write(new Student("Florencia", 'F', 12345678));
        //studentFile.write(new Student("Martin", 'M', 12654678));
        //studentFile.write(new Student("Agustin", 'M', 15432378));
        //studentFile.write(new Student("Marcos", 'M', 65421324));
//        studentFile.close();

//        File fileChosen = null;
//        fileChosen = new File(main.archivos.Scanner.getString("File name: "));

        int option = 0;
        while (option != 6){
            option = Scanner.getInt(" 1. Add new element. \n 2. Delete an element. \n 3. Modify an element. \n" +
                    " 4. Consultation. \n 5. Inform. \n 6. Exit. \n Choose an option: ");
            switch (option){
                case 1:
                    addNewElement(studentFile);
                    break;
                case 2:
                    deleteElement(studentFile);
                    break;
                case 3:
                    modifyElement(studentFile);
                    break;
                case 4:
                    consultation(studentFile);
                    break;
                case 5:
                    inform(studentFile);
                    break;
                case 6:
                    studentFile.close();
                    break;
                default:
                    System.out.println("Please enter a valid option.");
                    break;
            }
        }
    }


    private static void addNewElement(StudentFile studentFile) throws IOException {
        int enrollmentId = (Scanner.getInt("Enter student enrollment id: [8 int]"));
        char gender = (Scanner.getChar("Enter gender char: [F or M]"));
        int year = (Scanner.getInt("Enter student year: [1 int, 1 < year < 6]"));
        studentFile.write(new Student(enrollmentId, gender, year));
    }

    private static void deleteElement(StudentFile studentFile) throws IOException {
        try {
            int code = Scanner.getInt("Enter student code: ");
            if (studentFile.delete(code))
                System.out.println("Deleting successful.");
            else{
                System.out.println("Wrong code.");
            }
            //studentFile.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    private static void modifyElement(StudentFile studentFile) throws IOException {
        try {
            int code = Scanner.getInt("Enter student code: ");
            Student student = studentFile.search(code);
            int option = Scanner.getInt("Enter option: \n 1.Change student enrollment id.  \n 2.Change student" +
                    " year. \n");
            long place = studentFile.replace(code);
            if (place >= 0) {
                switch (option) {
                    case 1:
                        studentFile.goTo(place);
                        studentFile.write(new Student(Scanner.getInt("Enter enrollment id: "),student.getGender(),
                                student.getYear()));
                        break;
                    case 2:
                        studentFile.goTo(place);
                        studentFile.write(new Student(student.getEnrollmentId(),student.getGender(),
                                Scanner.getInt("Enter year: ")));
                        break;
                    default:
                        System.out.println("Wrong option");
                }
                studentFile.close();
            }
        }

        catch(Exception e){
            System.out.println(e.getMessage());
        }

    }


    private static void consultation(StudentFile studentFile) throws IOException {
        int option;
        option = Scanner.getInt("Choose an option: \n 1. Student data. \n 2. Amount of students. \n " +
                "3. Amount of female students. \n 4. Amount of male students. ");
        switch (option){
            case 1:
                getStudentData(studentFile);
                break;
            case 2:
                System.out.println("Amount of students: " + studentFile.amountOfRegisters());
                break;
            case 3:
                getFemaleAmount(studentFile);
                break;
            case 4:
                getMaleAmount(studentFile);
                break;
            default:
                System.out.println("Wrong option");
                break;
        }
    }

    private static void getFemaleAmount(StudentFile studentFile) throws IOException {
        System.out.println("Amount of female student: " + studentFile.amountOfFemale());
    }

    private static void getMaleAmount(StudentFile studentFile) throws IOException {
        System.out.println("Amount of male student: " + studentFile.amountOfMale());
    }

    private static void getStudentData(StudentFile studentFile) throws IOException {
        int code = Scanner.getInt("Enter student code: ");
        Student student = studentFile.search(code);
        System.out.println("Enrollment id: " + student.getEnrollmentId());
        System.out.println("Gender: " + student.getGender());
        System.out.println("Year: " + student.getYear());
    }


    private static void inform(StudentFile studentFile) throws IOException {
        int option;
        option = Scanner.getInt("Choose an option: \n 1. All students data. \n " +
                "2. All female students. \n 3. All male students. ");
        switch (option) {
            case 1:
                studentFile.printEveryStudent();
                break;
            case 2:
                studentFile.printEveryFemale();
                break;
            case 3:
                studentFile.printEveryMale();
                break;
            default:
                System.out.println("Wrong option");
                break;
        }
    }

}
