package sparta.firstevent.application.ports.in;

import sparta.firstevent.adapter.dto.EventRequestDto;
import sparta.firstevent.domain.event.Event;

public interface EventManageUseCase {
    Event regist(EventRequestDto dto);

    Event update(Long id, EventRequestDto eventRequestDto);
}
