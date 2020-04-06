package core.java.two.ObjectStream;



import core.java.two.textFile.Employee;
import core.java.two.textFile.Manager;

import java.io.*;

public class ObjectStreamTest {
    public static void main(String[] args) throws IOException , ClassNotFoundException {
        Employee harry = new Employee("Harry C",500,1981,10,1);
        Manager carl = new Manager("Carl",1000,1919,12,1);
        carl.setSec(harry);
        Manager tony = new Manager("tony",2000,1119,11,2);
        tony.setSec(harry);

        Employee[] staff = new Employee[3];
        staff[0] = carl;
        staff[1] = harry;
        staff[2] = tony;
        File file = new File("employee.dat");
        //file.createNewFile();
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))){
            out.writeObject(staff);//Object可以承接数组，包括对象数组
        }

        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))){
            Employee[] newStaff = (Employee[])in.readObject();
            newStaff[1].raiseSalary(10);

            for(Employee e : newStaff){
                if(e instanceof Manager)
                System.out.println(e.getName()+" 's sec is "+((Manager) e).getSec().getName()+" "+((Manager) e).getSec().getSalary());
            }
    }
}


}