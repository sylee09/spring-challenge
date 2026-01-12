package org.zerock.springchallenge.domain.event;

import lombok.Getter;
import org.zerock.springchallenge.domain.member.Member;

import java.time.LocalDateTime;

@Getter
public class Participation {
    private Long id;
    private Event event;
    private Member member;
    private LocalDateTime joinedAt;
    private boolean isWinner;

    public Participation(Event event, Member member, LocalDateTime joinedAt, boolean isWinner) {
        this.event = event;
        this.member = member;
        this.joinedAt = joinedAt;
        this.isWinner = isWinner;
    }
}
