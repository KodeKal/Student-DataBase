package Assignment3;

public class Student
{

    String Name; 
    Double Gpa;
    int idNumber;

    public Student()
    {
        Name = "";
        Gpa = 0.0;
        idNumber = 0;
    }

    public Student(String newname, double newgpa, int newidNumber)
    {
        Name = new String(newname);
        Gpa = new Double(newgpa);
        idNumber = new Integer(newidNumber);
    }
    
    
    public Student(Student S)
    {
        this.Name = S.Name;
        this.Gpa = S.Gpa;
        this.idNumber = S.idNumber;
    }

    public void setName(String name)
    {
        this.Name = name;
    }

    public void setGpa(Double gpa)
    {
        this.Gpa = gpa;
    }

    public void setidNumber(int Id)
    {
        this.idNumber = Id;
    }

    public Double getGpa()
    {
        return Gpa;
    }

    public int getidNumber()
    {
        return idNumber;
    }

    public String getName()
    {
        return Name;
    }

    public String toString()
    {
        return (Name + ", " + Gpa +", " + idNumber);
    }


}

