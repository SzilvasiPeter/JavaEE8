package entity;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EnviromentalFriendlyValidator implements ConstraintValidator<EnviromentalFriendly, EngineType> {
    @Override
    public void initialize(EnviromentalFriendly constraintAnnotation) {

    }

    @Override
    public boolean isValid(EngineType engineType, ConstraintValidatorContext constraintValidatorContext) {
        return engineType == EngineType.ELECTRIC;
    }
}
