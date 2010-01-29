public class Student implements Comparable<Student>
{
   private long id;
   private String name;
   
   public Student (long num, String lName)
   {
      id=num;
      name=lName;
   }
   
   public int compareTo(Student other)
   {
      if(this.id < other.id)
         return -1;
      else if(this.id > other.id)
         return 1;
      else 
         return 0; 
   }
   public String toString()
   {
      return ("{ id: " + id + ", name: " + name+ " }");
   }
}
