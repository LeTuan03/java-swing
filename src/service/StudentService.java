package service;

import dao.StudentDAO;
import java.util.List;
import model.Account;
import model.Member;
import model.StudentInClass;

public class StudentService {

    private StudentDAO studentDAO;

    public StudentService() {
        studentDAO = new StudentDAO();
    }

    public List<StudentInClass> getListSTU() {
        return studentDAO.getListSTU();
    }
    
    public List<StudentInClass> getListTeacher() {
        return studentDAO.getListTeacher();
    }

    public List<Member> getListStuInClass(String id) {
        return studentDAO.getListStuInClass(id);
    }
    
    
    public Account getInforSTU(int idAcc) {
        return studentDAO.getInforSTU(idAcc);
    }
    
    public List<StudentInClass> deleteAcc(String idAcc) {
        return studentDAO.deleteAcc(idAcc);
    }
}
