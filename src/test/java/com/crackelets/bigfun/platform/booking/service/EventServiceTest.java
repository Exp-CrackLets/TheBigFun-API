package com.crackelets.bigfun.platform.booking.service;
import com.crackelets.bigfun.platform.booking.domain.model.Event;
import com.crackelets.bigfun.platform.booking.domain.persistence.EventRepository;
import com.crackelets.bigfun.platform.shared.exception.ResourceNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import javax.validation.Validator;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
public class EventServiceTest {
    @InjectMocks
    private EventServiceImpl eventService;

    @Mock
    private EventRepository eventRepository;

    @Mock
    private Validator validator;

    @Test
    public void testGetAll() {
        List<Event> mockEvents = Arrays.asList(new Event(), new Event());
        when(eventRepository.findAll()).thenReturn(mockEvents);
        List<Event> result = eventService.getAll();
        assertEquals(2, result.size());
    }
    @Test
    public void testGetById(){
        long eventId = 1L;
        Event mockEvent = new Event();
        when(eventRepository.findById(eventId)).thenReturn(Optional.of(mockEvent));
        Event result = eventService.getById(eventId);
        assertNotNull(result);
    }
    @Test
    public void testUpdateEventNotFound() {
        long eventId = 1L;
        Event updatedEvent = new Event();
        updatedEvent.setId(eventId);
        updatedEvent.setName("Updated Event");
        when(eventRepository.findById(eventId)).thenReturn(Optional.empty());
        assertThrows(ResourceNotFoundException.class, () -> {
            eventService.update(eventId, updatedEvent);
        });
    }
    @Test
    public void testCreate() {
        Event event = new Event();
        event.setName("New Event");
        event.setDate(new Date());
        event.setAddress("123 Main Street");
        event.setCost(100);
        event.setImage("https://example.com/image.jpg");
        event.setCapacity(100);
        when(eventRepository.save(event)).thenReturn(event);
        Event result = eventService.create(event);
        assertEquals(event, result);
    }
    @Test
    public void testDelete() {
        Event event = new Event();
        event.setId(1L);
        event.setName("New Event");
        event.setDate(new Date());
        event.setAddress("123 Main Street");
        event.setCost(100);
        event.setImage("https://example.com/image.jpg");
        event.setCapacity(100);
        when(eventRepository.findById(event.getId())).thenReturn(Optional.of(event));
        eventRepository.save(event);
        eventService.delete(event.getId());
        assertTrue(eventRepository.findById(event.getId()).isPresent());
    }

}


