package sparta.firstevent.domain.member;

import lombok.Getter;
import sparta.firstevent.config.PasswordEncoder;
import sparta.firstevent.exception.NoRightToChangeRoleException;

import java.time.LocalDateTime;

@Getter
public class Member {
    private String email;
    private String password;
    private String nickname;
    private MemberStatus status;
    private MemberRole role;
    private LocalDateTime registAt;
    private static PasswordEncoder passwordEncoder = new PasswordEncoder();

    private Member(String email, String password, String nickname) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.status = MemberStatus.ACTIVE;
        this.role = MemberRole.USER;
        registAt = LocalDateTime.now();
    }

    private Member(String email, String password, String nickname, MemberRole role) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.status = MemberStatus.ACTIVE;
        this.role = role;
        registAt = LocalDateTime.now();
    }

    public static Member createAdmin() {
        String password = passwordEncoder.encode("admin1234");
        return new Member("admin@gmail.com", password, "admin", MemberRole.ADMIN);
    }

    public static Member enroll(String email, String password, String nickname) {
        // 비밀번호는 저장시 암호화 되어야 한다.
        password = passwordEncoder.encode(password);
        return new Member(email, password, nickname);
    }

    public void resign() {
        this.status = MemberStatus.RESIGNED;
    }

    public void changeRole(Member member, MemberRole role) {
        if (this.role != MemberRole.ADMIN && role == MemberRole.ADMIN) {
            throw new NoRightToChangeRoleException("권한이 없습니다.");
        }
        member.role = role;
    }
}
