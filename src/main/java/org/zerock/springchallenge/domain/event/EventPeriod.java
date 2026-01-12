package org.zerock.springchallenge.domain.event;

import java.time.LocalDateTime;

public class EventPeriod {
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    @Override
    public String toString() {
        return
                "startDate=" + startDate +
                        ", endDate=" + endDate;
    }

    public boolean isPossible(LocalDateTime currentDate) {
        if(currentDate.isAfter(startDate)&&currentDate.isBefore(endDate)) {
            return true;
        }
        return false;
    }
}
