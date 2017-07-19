package src.main.training;

 public class Employee {
	 
	 //instance variable
	 int id;
	String name ;
	 
	 public int printEmployee(int i ,String n){
		 
		 int count;
		 System.out.println("id of employee" + i +"Name of employee" + n);
		 
		 return 10;
		 
	 }
	 
	 public void sum(int num,int num2){}
	 
	 public void sum(double num1,double num2){}
	 
	 public void sum(int num1,int num2,int num3){}
	 
	 public static void main(String[] args) {
		Employee e = new Employee();
		e.id = 100;
		e.printEmployee(1200, "Mila");
	}
}
