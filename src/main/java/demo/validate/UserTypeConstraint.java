package demo.validate;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * 用户类型自定义约束注释
 *
 * @author Alex
 */
@Documented
@Constraint(validatedBy = UserTypeValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UserTypeConstraint {
    String message() default "无效的用户类型";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}