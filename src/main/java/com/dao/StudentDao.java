package com.dao;

import com.entities.Student;
import org.springframework.orm.hibernate5.HibernateTemplate;

import javax.transaction.Transactional;
import java.util.List;

public class StudentDao {

    private HibernateTemplate hibernateTemplate;


    //Save students(create)
    @Transactional
    public int insert(Student student){
        Integer i=(Integer) this.hibernateTemplate.save(student); // i return unique id of the data inserted
        return i;
    }

    //Get the single data(read)
    public Student getStudent(int studentId){
       Student student= this.hibernateTemplate.get(Student.class,studentId);
return student;
    }

    //get all rows(multiple)

    public List<Student> getAllStudents(){
        List<Student> students=this.hibernateTemplate.loadAll(Student.class);
        return students;
    }

    //Delete the data
    @Transactional
    public void deleteStudent(int studentId){
        Student student=this.hibernateTemplate.get(Student.class,studentId);
        this.hibernateTemplate.delete(student);

    }
    //Update data
    @Transactional
    public void updateStudent(Student student){
        this.hibernateTemplate.update(student);

    }

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

}
