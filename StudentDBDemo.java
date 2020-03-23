package Assignment3;

import java.util.Scanner;

public class StudentDBDemo
{
    public static void main(String[] args)
    {
        /*
        Testing the copy constructor of Student
        Student s1 = new Student(“Sam”,3.40,1900);
        Student s2 = new Student(p1);
        //setName() is a mutator method
        s1.setName(“John”);
        //getName() is an accessor method
        System.out.println(s1.getName() == s2.getName()); //should be false

        */
        char Choice1 = 'n';
        Scanner input = new Scanner(System.in);
        Scanner x = new Scanner(System.in);
        StudentDatabase Sim = new StudentDatabase(10);


		do{
            
            

            char Choice; 
        
            //Sim.SearchStudentsByName("John");

            System.out.println("What would you like to do from the following: ");
            System.out.println("Enter A ........ Add students manualy.");
            System.out.println("Enter B ........ Add Students from a file.");
            System.out.println("Enter C ........ Display List of student information.");
            System.out.println("Enter D ........ Remove a student by Name.");
            System.out.println("Enter E ........ Search by Name.");
            System.out.println("Enter F ........ Search by Id Number.");
            System.out.println("Enter G ........ Search by Gpa.");
            System.out.println("Enter H ........ Exit.");
            System.out.println("Enter Choice: ");

            Choice = input.next().charAt(0);
            Choice = Character.toUpperCase(Choice);

            while(!Character.isLetter(Choice) & Choice != 'A' & Choice != 'B' & Choice != 'C' & Choice != 'D' & Choice != 'E'& Choice != 'F' & Choice != 'G' )
            {
                System.out.println("invalid, Re-Enter Choice: ");

                Choice = input.next().charAt(0);
            }

            switch (Choice) {
            
                case 'A':
                    Sim.AddStudent(input);                              
                    break;
                        
                case 'B':
                    Sim.AddStudents("test.txt", input);
                   break;
                
                case 'H':
                    Sim.DisplayStudents();
                    System.exit(0);
                case 'C':
                    Sim.DisplayStudents();
                    break;

                case 'D':
                    System.out.println("Enter students name: ");
                    String StudentNm = input.next();
                    Sim.RemoveStudentByName(StudentNm);
                    break;
            
                case 'E':                
                    System.out.println("Enter students name: ");
                    String StudentName = input.next();
                    System.out.println(Sim.SearchStudentsByName(StudentName).toString());
                   break;

                case 'F':
                    System.out.println("Enter students Id#: ");
                    int StudentID = input.nextInt();
                    System.out.println(Sim.SearchStudentsByIdNumber(StudentID).toString()); //print the returned obj
                    break;

                case 'G':
                    System.out.println("Enter students GPA: ");
                    double StudentGPA = input.nextDouble();
                    Student[] cop = Sim.SearchStudentsByGpa(StudentGPA);

                    for(int i = 0; i < cop.length; i++)
                    {
                        System.out.println(cop[i].toString());
                    }
                        break;

                default:
                    break;
            
            }

            
            System.out.println("Go Again: Yes or No: ");
            Choice1 = x.next().charAt(0);
            Choice1 = Character.toUpperCase(Choice1); 
           
        }
        while(Choice1 == 'Y');

        input.close();
        x.close();

        /*2. Display number of Students in the database
        3. You should display all the Students in the database- their names, gpa and
        id numbers (one Student per line) in descending order of their gpas.

        
        4. Here you need to create a menu system that allows the user to select
        which option or method to invoke from the Class StudentDatabase. Also,
        provide an option to allow the user to exit from the menu. Everytime, the
        user choose to add or remove students, the details of the students should
        be displayed.

        /*
        5. If the user choose to exit from the menu system, display number of
        remaining Students in the database (their names, gpa and id numbers in the
        database) in descending order of their gpas.
        */
    }
}