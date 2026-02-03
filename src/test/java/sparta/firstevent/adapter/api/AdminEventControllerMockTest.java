package sparta.firstevent.adapter.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import sparta.firstevent.adapter.dto.EventRequestDto;
import sparta.firstevent.application.ports.in.AdminEventGetUseCase;
import sparta.firstevent.application.ports.in.AdminEventManageUseCase;
import sparta.firstevent.application.ports.in.ParticipantGetUseCase;
import sparta.firstevent.domain.event.Event;
import sparta.firstevent.domain.event.EventFixture;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AdminEventController.class)
public class AdminEventControllerMockTest {

    @MockitoBean
    AdminEventManageUseCase adminEventManageUseCase;

    @MockitoBean
    AdminEventGetUseCase adminEventGetUseCase;

    @MockitoBean
    ParticipantGetUseCase participantGetUseCase;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void registEvent() throws Exception {

        // given
        Event event = EventFixture.registEvent();
        ReflectionTestUtils.setField(event, "id", 1L);

        EventRequestDto eventRequestDto = EventFixture.createEventRequestDto();
        given(adminEventManageUseCase.regist(any())).willReturn(event);

        // when & then
        mockMvc.perform(post("/api/admin/events")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(eventRequestDto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(event.getId()));

        verify(adminEventManageUseCase).regist(any());
    }


}
