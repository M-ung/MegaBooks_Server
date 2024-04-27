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

}
