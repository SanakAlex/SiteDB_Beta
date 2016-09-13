package validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import static java.lang.annotation.ElementType.*;

@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })    // Аннотацией @Target указывается, какой элемент программы будет использоваться аннотацией.
@Retention(RUNTIME)                                                      
@Constraint(validatedBy = DirectoryFieldUniqueValidator.class)   //Этой аннотацией указывается, какой класс будет проверять на правильность данные.
@Documented
public @interface DirectoryFieldUnique {
	public static final String MESSAGE = "fields.notMatches";
	 
    String message() default MESSAGE;
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
 
    @Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
    @Retention(RUNTIME)
    @Documented
    @interface List {
        DirectoryFieldUnique[] value();
    }
}
