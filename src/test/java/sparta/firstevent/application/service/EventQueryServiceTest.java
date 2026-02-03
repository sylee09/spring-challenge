//package sparta.firstevent.application.service;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import sparta.firstevent.application.ports.in.EventManageUseCase;
//import sparta.firstevent.domain.event.EventFixture;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//@SpringBootTest
//public class EventQueryServiceTest {
//    @Autowired
//    EventManageUseCase eventManageUseCase;
//
//    @Autowired
//    GetEventUseCase eventGetUseCase;
//
//    @Test
//    void list() {
//        eventManageUseCase.regist(EventFixture.createEventRequestDto("title 1"));
//        eventManageUseCase.regist(EventFixture.createEventRequestDto("title 2"));
//        eventManageUseCase.regist(EventFixture.createEventRequestDto("title 3"));
//
//        assertThat(eventGetUseCase.getAll()).hasSize(3);
//    }
//}
