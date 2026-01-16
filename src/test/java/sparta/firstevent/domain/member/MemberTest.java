package sparta.firstevent.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sparta.firstevent.exception.NoRightToChangeRoleException;

import static org.junit.jupiter.api.Assertions.*;

class MemberTest {
    Member member1;
    Member member2;
    Member admin;

    @BeforeEach
    void setUp() {
        member1 = Member.enroll("email@gmail.com", "1234", "member1");
        member2 = Member.enroll("email@gmail.com", "1234", "member1");
        admin = Member.createAdmin();
    }

    @Test
    void enroll() {
        // 회원가입 완료
        Assertions.assertThat(member1).isNotNull();
        // 비밀번호 암호화 됨
        Assertions.assertThat(member1.getPassword()).isNotEqualTo("1234");
    }

    @Test
    void resign() {
        // 탈퇴시 상태를 resign으로 변경
        member1.resign();
        Assertions.assertThat(member1.getStatus()).isEqualTo(MemberStatus.RESIGNED);
    }

    @Test
    void changeRole() {
        Assertions.assertThatThrownBy(() -> member1.changeRole(member2, MemberRole.ADMIN)).isInstanceOf(NoRightToChangeRoleException.class);
        admin.changeRole(member2, MemberRole.ADMIN);
        Assertions.assertThat(member2.getRole()).isEqualTo(MemberRole.ADMIN);
    }
}