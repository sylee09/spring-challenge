package sparta.firstevent.application.ports.out;

import org.springframework.data.repository.Repository;
import sparta.firstevent.domain.event.Event;

import java.util.List;
import java.util.Optional;

public interface EventRepository extends Repository<Event, Long> {
    Event save(Event event);

    Optional<Event> findById(Long id);

    List<Event> findAll();
}
