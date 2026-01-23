package sparta.firstevent.application.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import sparta.firstevent.adapter.dto.EventRequestDto;
import sparta.firstevent.application.ports.in.EventManageUseCase;
import sparta.firstevent.domain.event.Event;
import sparta.firstevent.domain.event.EventFixture;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class EventCommandServiceTest {

    @Autowired
    EventManageUseCase eventManageUseCase;

    @Test
    void regist() {
        EventRequestDto requestDto = EventFixture.createEventRequestDto();
        Event savedEvent = eventManageUseCase.regist(requestDto);

        assertThat(savedEvent.getId()).isNotNull();
        assertThat(savedEvent.getTitle()).isEqualTo(requestDto.getTitle());
    }

    @Test
    void modify() {
        String title = "modified title";
        EventRequestDto requestDto = EventFixture.createEventRequestDto();
        Event savedEvent = eventManageUseCase.regist(requestDto);

        Event updatedEvent = eventManageUseCase.update(savedEvent.getId(), EventFixture.createEventRequestDto(title));

        assertThat(updatedEvent.getTitle()).isEqualTo(title);
    }
}
