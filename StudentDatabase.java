package Assignment3;

import java.util.Comparator;
import java.util.Scanner;
import java.util.Vector;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.OutputStream;
import java.io.PrintWriter;

public class StudentDatabase
{
    Student [] Students;
    int NumStudents;
    

    public StudentDatabase(int num)
    {
        if(num > 10)
        {
            System.out.println("Too many students");
            System.exit(0);
        }

        NumStudents = num;
        Students = new Student[NumStudents];
        for(int i =0; i < NumStudents; i++)
        {
            Students[i] = new Student();
        }
        
        /*you need to update NumStudents
        when you add,remove Students.
        Also, you need to make sure NumStudents doesn’t exceed 10.
        */
    }
  	int numOfdata;
    public Scanner AddStudent(Scanner scan)
    {
        // not more than 10 Students in the database allowed   
        numOfdata = 0;
        boolean isFull = true;;
        for(int i = 0; i < NumStudents; i++)
        {
            if(Students[i].getName().isEmpty())
            {
                isFull = false;
            }
            else   
                numOfdata++;

        }

        if (!isFull)
        {
            System.out.println("How many students would you like to enter: ");
            int numb = scan.nextInt();
        
            while((numb + numOfdata) > 10)
            {
                System.out.println("Too many students in the database");
                
                System.out.println("How many students would you like to enter, (" + (NumStudents - numOfdata) + "-10 Slots available):");
                numb = scan.nextInt();
        
            }

            if(numOfdata == 0)
            {
                for (int i = 0; i < numb; i++)
                {
                    if(Students[i].getName().isEmpty())
                    {
                        System.out.println("Enter " + (i+1) + " st/nd/rd/th students name: ");
                        //nm = scan.nextLine();                        
                        Students[i].setName(scan.next());                       

                        //----------------------------------------------------------------------------
                        System.out.println("Enter " + (i+1) + " st/nd/rd/th students GPA: ");      
                        Double gpa= scan.nextDouble();
                        while(gpa.isNaN() || gpa > 5)  //validation
                        {   
                            System.out.println("Enter " + (i+1) + " st/nd/rd/th students GPA (0-5.0): ");      
                            gpa= scan.nextDouble();
                        }
                        Students[i].setGpa(gpa);

                        //----------------------------------------------------------------------------

                        System.out.println("Enter " + (i+1) + " st/nd/rd/th students unique ID Number: ");
                        int id = scan.nextInt(); 
                        boolean unique = true;   

                        for(int j = 0; j < NumStudents; j++)
                        {
                            if(Students[j].idNumber == id)
                            {
                                unique = false;
                            }
                        }
                                                           
                        while(!unique)  //validation, make_unique?
                        {   
                            
                            System.out.println("Enter " + (i+1) + " st/nd/rd/th students UNIQUE ID: ");      
                            id= scan.nextInt();
                            
                            unique = true;
                            for(int j = 0; j < numOfdata; j++)
                            {
                                if(Students[j].getidNumber() == id)
                                {
                                    unique = false;
                                }
                                
                            }   
                        }
                        Students[i].setidNumber(id);

                        numOfdata++;
                    }

                    if(i > NumStudents)
                    {
                        NumStudents = i;
                    }
                }
            }
            else
            {
                for (int i = 0; i < (numb + numOfdata); i++) //incase there is already data
                {
                    if(Students[i].getName().isEmpty())
                    {
                        System.out.println("Enter " + (i+1) + " st/nd/rd/th students name: ");
                        //nm = scan.nextLine();                        
                        Students[i].setName(scan.next());    
                        //----------------------------------------------------------------------------


                        System.out.println("Enter " + (i+1) + " st/nd/rd/th students GPA: ");      
                        Double gpa= scan.nextDouble();
                        while(gpa.isNaN() || gpa > 5)  //validation
                        {   
                            System.out.println("Enter " + (i+1) + " st/nd/rd/th students GPA (0-5.0): ");      
                            gpa= scan.nextDouble();
                        }
                        Students[i].setGpa(gpa);
                        //----------------------------------------------------------------------------

                        System.out.println("Enter " + (i+1) + " st/nd/rd/th students unique ID Number: ");
                        int id = scan.nextInt(); 
                        boolean unique = true;   

                        for(int j = 0; j < NumStudents; j++)
                        {
                            if(Students[j].idNumber == id)
                            {
                                unique = false;
                            }
                        }
                                                           
                        while(!unique)  //validation, make_unique?
                        {   
                            
                            System.out.println("Enter " + (i+1) + " st/nd/rd/th students UNIQUE ID: ");      
                            id= scan.nextInt();
                            
                            unique = true;
                            for(int j = 0; j < numOfdata; j++)
                            {
                                if(Students[j].getidNumber() == id)
                                {
                                    unique = false;
                                }
                                
                            }   
                        }
                        Students[i].setidNumber(id);
                        
                    }

                    if(i > NumStudents)
                    {
                        NumStudents = i;
                        
                    }
                }
                
            }

            numOfdata += numb;
            //NumStudents = numOfdata;
            
            
        }
        else
            System.out.println("Too many students in the database");
        return scan;

    }     
        

 
    
    
    public void AddStudents(String StudentsFile, Scanner scan)
    {
        // Max of 10 Students in the database allowed
        // Hence, read up to max of 10 lines in the file.
        //int numOFlines = countLines(StudentsFile);
        try
        {
            scan = new Scanner (new File(StudentsFile));
            scan.useDelimiter(",");
        }
        catch(Exception e)
        {
            System.out.println("Error, file not found ");
        }

        String nm =" ";
        Double gpa = 0.0;
        int j= 0;
        if(numOfdata > 0)
          j = 10 - numOfdata;
        

       
        while(scan.hasNext() && j < 10)
        {
                  

          for(int i = 0; i < NumStudents & scan.hasNext(); i++)
          {
            if(Students[i].getName().isEmpty())
            {
              nm = scan.next();
              Students[i].setName(nm);
              System.out.println(nm);
               

              if(scan.hasNextDouble())
                {
                  gpa = scan.nextDouble();
                  System.out.println(gpa);
                  Students[i].setGpa(gpa);
                }

              int num = 0;// = scan.nextInt();
              //System.out.println(scan.next());

              if(scan.hasNextInt())
              {
                num = scan.nextInt();
                System.out.println(num);

              }
              if(isUnique(num, scan, nm))
              {
                Students[i].setidNumber(num);
                
              }
            }
          }
          j++;
          numOfdata++;
        }
       
    }

   
    private boolean isUnique(int x, Scanner scann, String name)
    {
      
        boolean unique = true; 
          

        for(int j = 0; j < NumStudents; j++)
        {
          if(Students[j].idNumber == x)
          {
           unique = false;
          }
        } 
                                                           
        while(!unique)  //validation, NotUnique?
        {   
                            
          System.out.println(name + "'s ID from file is either not an integer or not unique (is taken), Enter " +  name + "'s new UNIQUE ID: ");      
          x = scann.nextInt();
          unique = true; //assume it is unique
          for(int j = 0; j < NumStudents; j++)
          {
            if(Students[j].getidNumber() == x)
            {
              unique = false; //not unique 
            }
          }
            
          
        }   
    
      return unique;
    }

    public void DisplayStudents()
    {
        //display all students in decending order of gpa
      
        for(int i = 0; i < NumStudents; i++)
        {
            for (int j = 1 + i; j < NumStudents; j++)
            {
                if(Students[i].getGpa() < Students[j].getGpa())
                {
                    swap(Students, i, j);

                }
            }
        }

        for(int i = 0; i < NumStudents; i++)
        {
            System.out.println(Students[i].toString());
        }
    
    }
    
    public void swap(Student []s, int i, int j)
    {
        Student temp = new Student(s[i]);
        s[i] = new Student(s[j]);
        s[j] = new Student(temp);
    }


    public Student SearchStudentsByName(String StudentName)
    {
        for(int i = 0; i < NumStudents; i++)
        {
            if(Students[i].getName().equals(StudentName))
            {
                Student temp = new Student(Students[i]);
                return temp;
                                
            }
            
        }
        System.out.println("Student not found");
        Student temp = new Student();
        return temp;

        
        
    }

    public Student SearchStudentsByIdNumber(int StudentIdNumber)
    {
        for(int i = 0; i < NumStudents; i++)
        {
            if(Students[i].getidNumber() == StudentIdNumber)
            {
                Student temp = new Student(Students[i]);
                return temp;
                              
            }                        
                            
        }
        System.out.println("Student not found");
        Student temp = new Student();
        return temp;            
    }

    public Student[] SearchStudentsByGpa(double StudentGpa)
    {
        
        Student[] Studentss = null; 
        Vector<Integer> vec = new Vector<Integer>(); 
        for(int i = 0; i < NumStudents; i++)
        {
            if(Students[i].getGpa() >= StudentGpa)
            {
                vec.add(i);                
            }                
                     
        }
        
        if(vec.size() < 1)
        {
            Studentss = new Student[1];
        }
        else
        {
            Studentss = new Student[vec.size()];
            for(int j =0; j < vec.size(); j++)
            {
                Studentss[j] = new Student(Students[vec.get(j)]);
            }
        }

       return Studentss;
    }

    public void RemoveStudentByName(String StudentName)
    {
        boolean found = false;
         //System.out.println("here1" + numOfdata);
        for(int i = 0; i < NumStudents; i++)
        {
            if(Students[i].getName().equalsIgnoreCase(StudentName) )
            {
                Students[i].setName("");
                Students[i].setGpa(0.0);
                Students[i].setidNumber(0); 
                  
                System.out.println("Removed, Remaining Students are: ");
                for(int j = 0; j < NumStudents; j++)
                {
                  System.out.println(Students[j].toString());
                  NumStudents = 10;
                }                
                numOfdata--;
                break;             
            }    
                    
               
        }        

        if(found)
        {
            System.out.println("Error, Student not found.");
        }
        

    }

    
}