package com;

import com.dao.StudentDao;
import com.entities.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("com/ormconfig.xml");
        StudentDao studentDao = context.getBean("studentDao", StudentDao.class);

//        Student student = new Student(2234, "Durgesh Tiwari", "Lucknow");
//        int result = studentDao.insert(student);
//        System.out.println("Done " + result);
//    }
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();

        boolean go = true;
        while (go) {
            System.out.println("Press  1 for add new Student");
            System.out.println("Press  2 for display all Student");
            System.out.println("Press  3 for get detail of single Student");
            System.out.println("Press  4 for add delete Student");
            System.out.println("Press  5 for  update Student");
            System.out.println("Press  6 for exit ");
            try {
                 input = sc.nextInt();
                switch (input) {
                    case 1:
                        //Add std

                        System.out.println("Enter Student ID:");
                        int uId = sc.nextInt();

                        sc.nextLine(); // consume the newline
                        System.out.println("Enter Student Name:");
                        String uName = sc.nextLine();

                        System.out.println("Enter Student City:");
                        String uCity = sc.nextLine();

                        Student s = new Student(uId,uName,uCity);
                        s.setStudentId(uId);
                        s.setStudentName(uName);
                        s.setStudentCity(uCity);

                      //calling insert func of stdDao
                        int r = studentDao.insert(s);
                        System.out.println("Student added successfully, result: " + r);
                        System.out.println("*******************************");
                        break;

                    case 2:
                        //Display std
                        System.out.println("**************************************");
                        List<Student> allStudents=studentDao.getAllStudents();
                        for(Student st:allStudents){
                            System.out.println("Student ID = " + st.getStudentId());
                            System.out.println("Student Name = " + st.getStudentName());
                            System.out.println("Student City = " + st.getStudentCity());
                            System.out.println("______________________________________");

                        }
                        System.out.println("******************************************");

                        break;
                    case 3:
                        //get detail

                        System.out.println("Enter Student ID:");
                        int userId = sc.nextInt();
                        Student std=studentDao.getStudent(userId);

                        System.out.println("Student ID = " + std.getStudentId());
                        System.out.println("Student Name = " + std.getStudentName());
                        System.out.println("Student City = " + std.getStudentCity());
                        System.out.println("______________________________________");
                        System.out.println("******************************************");

                        break;
                    case 4:
                        //delete std
                        System.out.println("Enter Student ID:");
                        int id = sc.nextInt();
                        studentDao.deleteStudent(id);
                        System.out.println("******************************************");
                        System.out.println("Student with Id-- " +id+ " Deleted Successfully");
                        System.out.println("******************************************");
                        break;


                    case 5:
                        // Update a student
                        System.out.println("Enter Student ID to update:");
                        int updateId = sc.nextInt();
                        sc.nextLine(); //  newline
//
//                        System.out.println("Enter New ID:");
//                        int newId = sc.nextInt();              //Id is primary key ,cant be updated
//                        sc.nextLine(); // newline

                        System.out.println("Enter New Name:");
                        String newName = sc.nextLine();

                        System.out.println("Enter New City:");
                        String newCity = sc.nextLine();

                        // Fetch the student to update
                        Student studentToUpdate = studentDao.getStudent(updateId);
                        if (studentToUpdate != null) {
                            // Set new values
                            // studentToUpdate.setStudentId(newId);
                            studentToUpdate.setStudentName(newName);
                            studentToUpdate.setStudentCity(newCity);

                            // Update in database
                            studentDao.updateStudent(studentToUpdate);
                            System.out.println("Student updated successfully.");
                        } else {
                            System.out.println("Student with ID " + updateId + " not found.");
                        }
                        break;

                    case 6:
                        //exit
                        go = false;
                        break;

                }
            }
            catch (Exception e) {
                System.out.println("Invalid input !!");
                System.out.println(e.getMessage());
            }
        }
            System.out.println("Thank You for using my application");
            System.out.println("See u soon");
        }
}