package validator;

import proc.DirectoryService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class DirectoryFieldUniqueValidator implements ConstraintValidator <DirectoryFieldUnique, String>{
	
private String message = DirectoryFieldUnique.MESSAGE;
    
    @Autowired
    DirectoryService directoryService;
 
    public void initialize(DirectoryFieldUnique constraintAnnotation) {
        this.message = constraintAnnotation.message();      
    }
 
    public boolean isValid(String value, ConstraintValidatorContext context) {
        try {
            boolean matches=(null == directoryService.findByName(value) );    //вот так надо было правильно поставить условие.
            if (!matches){                   
                String msg=this.message;                
                if( this.message==null || "".equals(this.message) || DirectoryFieldUnique.MESSAGE.equals( this.message ) ){     
                    msg="This directory already exists";     //сообщение об ошибке(любая бла-бла-логия).
                }
                
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate(msg).addConstraintViolation();
            }    
            
            return matches;
        } 
        
        catch (final Exception e) {       
            e.printStackTrace();
        }
        
        return true;
    }
}
