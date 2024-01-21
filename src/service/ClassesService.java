package service;

import dao.ClassesDAO;
import java.util.List;
import model.Classes;
import model.Member;

public class ClassesService {

    private ClassesDAO classesDAO;

    public ClassesService() {
        classesDAO = new ClassesDAO();
    }

    public List<Classes> getListClasses() {
        return classesDAO.getListClasses();
    }

    public List<Classes> getListClassesByTeacher(int id) {
        return classesDAO.getListClassesByTeacher(id);
    }

    public void UpdateClassesService(Classes classes) {
        classesDAO.updateClasses(classes);
    }

    public void AddNewClassesService(Classes classes) {
        classesDAO.addNewClasses(classes);
    }

    public List<Member> getListClassesInRoleSTU(int idAcc) {
        return classesDAO.getListClassesInRoleSTU(idAcc);
    }

    public List<Classes> deleteClasses(String id) {
        return classesDAO.deleteClasses(id);
    }
}
