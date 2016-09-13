package validator;
import proc.LinkService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class UrlUniqueValidator implements ConstraintValidator <UrlUnique, String>{
private String message = DirectoryFieldUnique.MESSAGE;
    
    @Autowired
    LinkService linkService;
 
    public void initialize(UrlUnique constraintAnnotation) {
        this.message = constraintAnnotation.message();      
    }
 
    public boolean isValid(String value, ConstraintValidatorContext context) {
        try {
            boolean matches=(null == linkService.findLinkByUrl(value) );    //вот так надо было правильно поставить условие.
            if (!matches){                   
                String msg=this.message;                
                if( this.message==null || "".equals(this.message) || DirectoryFieldUnique.MESSAGE.equals( this.message ) ){     
                    msg="This url of link already exists";     //сообщение об ошибке(любая бла-бла-логия).
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
