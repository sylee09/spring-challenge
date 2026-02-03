package sparta.firstevent.adapter.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sparta.firstevent.adapter.dto.ParticipantResponseDto;
import sparta.firstevent.application.ports.in.EventGetUseCase;
import sparta.firstevent.application.ports.in.ParticipantManageUseCase;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/events")
public class EventController {
    private final ParticipantManageUseCase participantManageUseCase;
    private final EventGetUseCase eventGetUseCase;

    @PostMapping("/{eventId}/participate/{memberId}")
    public ParticipantResponseDto participate(Long eventId, Long memberId) {
        return ParticipantResponseDto.from(participantManageUseCase.apply(eventId, memberId));
    }

    @GetMapping("/{eventId}/participateCount")
    public Long getParticipateCount(@PathVariable Long eventId) {
        return eventGetUseCase.getParticipantsCount(eventId);
    }
}
