package entity;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.ANNOTATION_TYPE, ElementType.PARAMETER})
@Constraint(validatedBy = EnviromentalFriendlyValidator.class)
@Documented
public @interface EnviromentalFriendly {

    String messages() default "";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
