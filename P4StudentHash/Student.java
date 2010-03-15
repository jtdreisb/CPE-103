/** * Student class to keep student ID and Name * provides a toString method
 * * @version cpe 103 section 4 * * @author Mathew Duhon and Jason Dreisbach * @version Program 4 */
 
public class Student 
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
    * overiden equals method
    *
    * @Pre-conditions: other != null
    * @Post-onditions: a 1 0 or -1 value representing the collation
    *
    */
   public boolean equals(Object other)
   {
      return this.id == ((Student)other).id;
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
   
   
   /**
    * Returns a formatted student string
    *
    * @Pre-conditions: none
    * @Post-conditions: Returns a string with id and name of student
    *
    */
   public int hashCode()
   {
      return new Long(id).hashCode();
   }
}
