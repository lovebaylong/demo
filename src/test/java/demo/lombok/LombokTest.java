package demo.lombok;

import lombok.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Base64Utils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Collections;

public class LombokTest {
    private static final Logger log = LoggerFactory.getLogger(LombokTest.class);

    @NonNull
    private String name;
    private String idNo;
    private String phone;

    public static void main(String[] args) throws IOException {
        log.info("Hello world!!!");
        String imageUrl = "https://cdn6.bypms.cn/show/rfile/505B2D0750BD8C7AAA70F524D5A3880C_400x400.jpg";
        BufferedImage bufferedImage = ImageIO.read(new URL(imageUrl));
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            ImageIO.write(bufferedImage, "jpg", outputStream);
            String encode = Base64Utils.encodeToString(outputStream.toByteArray());
            log.info("图片url：" + imageUrl + " 转换为base64字符串：" + encode);
        } finally {
            if (Collections.singletonList(outputStream).get(0) != null) outputStream.close();
        }
    }

    public LombokTest(@NonNull String name) {
        if (name == null) throw new NullPointerException("name is marked non-null but is null");
        this.name = name;
    }

    @NonNull
    public String getName() {
        return this.name;
    }

    public String getIdNo() {
        return this.idNo;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setName(@NonNull String name) {
        if (name == null) throw new NullPointerException("name is marked non-null but is null");
        this.name = name;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String toString() {
        return "LombokTest(super=" + super.toString() + ", name=" + getName() + ", idNo=" + getIdNo() + ", phone=" + getPhone() + ")";
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof LombokTest)) return false;
        LombokTest other = (LombokTest) o;
        if (!other.canEqual(this)) return false;
        Object this$name = getName();
        Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        Object this$idNo = getIdNo();
        Object other$idNo = other.getIdNo();
        if (this$idNo == null ? other$idNo != null : !this$idNo.equals(other$idNo)) return false;
        Object this$phone = getPhone();
        Object other$phone = other.getPhone();
        return this$phone == null ? other$phone == null : this$phone.equals(other$phone);
    }

    protected boolean canEqual(Object other) {
        return other instanceof LombokTest;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Object $name = getName();
        result = result * 59 + ($name == null ? 43 : $name.hashCode());
        Object $idNo = getIdNo();
        result = result * 59 + ($idNo == null ? 43 : $idNo.hashCode());
        Object $phone = getPhone();
        return result * 59 + ($phone == null ? 43 : $phone.hashCode());
    }
}