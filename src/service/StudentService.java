package service;

import dao.StudentDAO;
import java.util.List;
import model.StudentInClass;

public class StudentService {
    private  StudentDAO studentDAO;
    
    public StudentService(){
        studentDAO = new StudentDAO();
    }
    
    public List<StudentInClass> getListSTU(){
        return studentDAO.getListSTU();
    }
}