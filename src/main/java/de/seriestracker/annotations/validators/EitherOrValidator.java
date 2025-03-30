package de.seriestracker.annotations.validators;

import de.seriestracker.annotations.EitherOr;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

public class EitherOrValidator implements ConstraintValidator<EitherOr, Object> {

    private String[] fields;

    public void initialize(EitherOr constraintAnnotation) {
        this.fields = constraintAnnotation.fields();
    }

    public boolean isValid(Object value, ConstraintValidatorContext context) {

        int counter = 0;
        List<String> fieldValues = new ArrayList<String>();

        for (String field : fields) {
            Object propertyValue = new BeanWrapperImpl(value).getPropertyValue(field);
            if (ObjectUtils.isEmpty(propertyValue)) {
                fieldValues.add(null);
            } else {
                fieldValues.add(propertyValue.toString());
                counter++;
                if (counter > 1)
                    return false;
            }
        }
        if (counter == 0)
            return false;
        return true;
    }
}
