package service;

import dao.ClassesDAO;
import java.util.List;
import model.Classes;


public class ClassesService {
    private  ClassesDAO classesDAO;
    
    public ClassesService(){
        classesDAO = new ClassesDAO();
    }
    
    public List<Classes> getListClasses(){
        return classesDAO.getListClasses();
    }
    public void UpdateClassesService(Classes classes){
       classesDAO.updateClasses(classes);
    }
}
