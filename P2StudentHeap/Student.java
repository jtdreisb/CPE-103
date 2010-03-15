/** * Student class to keep student ID and Name * provides a toString method
 * * @version cpe 103 section 4 * * @author Mathew Duhon and Jason Dreisbach * @version Program 2 */
 
public class Student implements Comparable<Student>
{
   /* 
    * id holds the students id number
    * each student's id is unique
    */
   private long id;
   /*
    * Name holds a string without spaces representing the student
    */ 
   private String name;
   /**
    * Constructs a student with a id and a name
    *
    * @Pre-conditions: none
    * @Post-conditions: initialized student object
    *
    */
   public Student (long num, String lName)
   {
      id=num;
      name=lName;
   }
   /**
    * Implementation of Comparable interface
    *
    * @Pre-conditions: other != null
    * @Post-onditions: a 1 0 or -1 value representing the collation
    *
    */
   public int compareTo(Student other)
   {
      if(this.id < other.id)
         return -1;
      else if(this.id > other.id)
         return 1;
      else 
         return 0; 
   }
   /**
    * Returns a formatted student string
    *
    * @Pre-conditions: none
    * @Post-conditions: Returns a string with id and name of student
    *
    */
   public String toString()
   {
      return ("{ id: " + id + ", name: " + name+ " }");
   }
}
