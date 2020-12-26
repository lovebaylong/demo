package demo.model;

import demo.validate.AdvanceInfo;
import demo.validate.BaseInfo;
import demo.validate.UserTypeConstraint;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Entity
@Data
public class User {
    public static final int TYPE_ADMIN = 1;
    public static final int TYPE_NORMAL = 2;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @UserTypeConstraint(groups = BaseInfo.class)
    private Integer type;

    @NotBlank(message = "{user.name.NotBlank.message}", groups = BaseInfo.class)
    private String name;

    @Min(value = 18, message = "年龄不能小于18岁", groups = BaseInfo.class)
    @Max(value = 150, message = "年龄不能大于150岁", groups = BaseInfo.class)
    @Positive(message = "年龄不能是负数", groups = BaseInfo.class)
    @NotNull(message = "年龄不能为null", groups = BaseInfo.class)
    private Integer age;

    @AssertTrue(message = "用户必须是活人", groups = BaseInfo.class)
    private Boolean isLive;

    @Pattern(regexp = "(\\d{6})(\\d{4})(\\d{2})(\\d{2})(\\d{3})([0-9]|X)$", message = "身份证号不合法", groups = AdvanceInfo.class)
    private String idCardNo;

    @NotEmpty(message = "电话不能为空", groups = AdvanceInfo.class)
    private String phone;

    @NotNull(message = "地址不能为null", groups = AdvanceInfo.class)
    private String address;

    @Email(message = "email无效", groups = AdvanceInfo.class)
    private String email;
}
