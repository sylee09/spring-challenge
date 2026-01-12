package org.zerock.springchallenge.domain.member;

import lombok.Getter;


@Getter
public class Member {

    private Long id;
    private String name;
    private RoleType role;

    public Member(String name, RoleType role) {
        this.name = name;
        this.role = role;
    }

    public void assignAdminRole(Member member) {
        if(this.role == RoleType.MANAGER) {
            member.setRoleType(RoleType.MANAGER);
        }
    }

    private void setRoleType(RoleType role) {
        this.role = role;
    }
}
