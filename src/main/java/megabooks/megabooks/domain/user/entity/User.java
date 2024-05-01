package megabooks.megabooks.domain.user.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import megabooks.megabooks.global.common.BaseEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Entity
@Getter
@Builder
@Table(name = "member")
public class User extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;
    private String role = "ROLE_USER";
    private String userEmail;
    private String userPassword;
    private String userName;
    private String userImg;



    /** ======================== 메소드 ======================== **/
    public List<String> getRoleList() {
        if (this.role.length() > 0) {
            return Arrays.asList(this.role.split(","));
        }
        return new ArrayList<>();
    }

    /** ======================== 생성자 ======================== **/
    public User() {

    }

    public User(Long id, String role, String userEmail, String userPassword, String userName, String userImg) {
        this.id = id;
        this.role = role;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userName = userName;
        this.userImg = userImg;
    }

    public User(BaseEntityBuilder<?, ?> b, Long id, String role, String userEmail, String userPassword, String userName, String userImg) {
        super(b);
        this.id = id;
        this.role = role;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userName = userName;
        this.userImg = userImg;
    }
}
