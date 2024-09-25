package demo;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

@Component
public class Doctor implements Staff , BeanNameAware{
    public String qualification;

    public void assist(){
        System.out.println("Doctor is Assisting");
    }
    public String getQualification(){
        return qualification;
    }
    public void setQualification(String qualification){
        this.qualification = qualification;
    }
    public void setBeanName(String name){
        System.out.println("setBeanName method called");
    }
}
