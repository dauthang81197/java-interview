package practice;




 class Employee {
    private String name;
    private double salary;
    public Employee(String name, double salary) { this.name = name; this.salary = salary; }
    public double getSalary() { return salary; }

 }

 abstract class Person {
    private String name;
    public Person(String name) { this.name = name; }
    public String getName() { return name; }

     public abstract void work();
 }

 class Employee2 extends Person {
    private double salary;
    public Employee2(String name, double salary) { super(name); this.salary = salary; }
    @Override public void work() { System.out.println("Employee2 working"); }
 }

 class Student extends Person {
    private double tuition;
    public Student(String name, double tuition) { super(name); this.tuition = tuition; }
    @Override public void work() { System.out.println("Student working"); }
 }

 class Manager extends Employee {
    private double bonus = 5000;
    public Manager(String name, double salary) { super(name, salary); }
    public void setBonus(double b) { bonus = b; }
    @Override public double getSalary() { return super.getSalary() + bonus; }
}

// The first class manager run, after that constructor of employee is run, the next



// Du lieu khong doi sau khi tao
// co the them thuoc tinh vao
public class oop {
    public static void main(String[] args) {
        Manager boss = new Manager("Thang", 1);
        Object o = new Manager("Thang", 1);

        Employee[] staff = new Employee[3];
        staff[0] = boss;   // staff[0] và boss trỏ CÙNG một đối tượng
        System.out.println(staff[0].getClass());
        System.out.println(boss.getClass());
        boss.setBonus(5000);       // ĐƯỢC: boss khai báo là Manager
     // LỖI: staff[0] khai báo là Employee

    }
}

