package sparta.firstevent.application.service;

import org.springframework.stereotype.Service;
import sparta.firstevent.adapter.dto.EventRequestDto;
import sparta.firstevent.application.ports.in.EventManageUseCase;
import sparta.firstevent.application.ports.out.EventRepository;
import sparta.firstevent.domain.event.Event;

@Service
public class EventCommandService implements EventManageUseCase {
    private final EventRepository eventRepository;

    public EventCommandService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public Event regist(EventRequestDto requestDto) {
        return eventRepository.save(Event.regist(requestDto));
    }

    @Override
    public Event update(Long id, EventRequestDto eventRequestDto) {
        Event event = eventRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("id에 해당하는 이벤트가 없습니다."));
        event.update(eventRequestDto);
        return event;
    }
}
