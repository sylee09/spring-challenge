package org.zerock.springchallenge.domain.event;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.zerock.springchallenge.domain.member.Member;

public class Event {
    private Long id;
    private String title;
    private EventPeriod eventPeriod;
    private int maxWinnerCount;
    private int currentWinnerCount;
    private List<Participation> participants = new ArrayList<>();

    public Event(String title, EventPeriod eventPeriod, int maxWinnerCount) {
        this.title = title;
        this.eventPeriod = eventPeriod;
        this.maxWinnerCount = maxWinnerCount;
    }

    public boolean isJoinable(LocalDateTime currentDate) {
        return eventPeriod.isPossible(currentDate);
    }

    public boolean hasSlot() {
        return currentWinnerCount < maxWinnerCount;
    }

    public void addWinner(Member member) {
        if (hasSlot()) {
            currentWinnerCount++;
            new Participation(this, member, LocalDateTime.now(), true);
        }
    }

    public void viewEvent() {
        System.out.println("참여자 수 : " + participants.size());
        System.out.println("당첨자수 : " + currentWinnerCount);
        System.out.println("이벤트 정보 : " + title + ", eventPeriod: " + eventPeriod);
    }

    public List<Member> getWinners() {
        return participants.stream()
                .filter(p -> p.isWinner())
                .map(p -> p.getMember())
                .toList();
    }

}
