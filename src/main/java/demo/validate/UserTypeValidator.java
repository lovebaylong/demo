package demo.validate;

import demo.model.User;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 用户类型自定义约束验证器
 *
 * @author Alex
 */
public class UserTypeValidator implements ConstraintValidator<UserTypeConstraint, Integer> {
    @Override
    public void initialize(UserTypeConstraint constraintAnnotation) {
    }

    @Override
    public boolean isValid(Integer userType, ConstraintValidatorContext constraintValidatorContext) {
        return null != userType && (userType == User.TYPE_ADMIN || userType == User.TYPE_NORMAL);
    }
}
