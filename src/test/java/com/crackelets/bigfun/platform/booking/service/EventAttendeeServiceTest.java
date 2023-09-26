package com.crackelets.bigfun.platform.booking.service;

import com.crackelets.bigfun.platform.booking.domain.model.Event;
import com.crackelets.bigfun.platform.booking.domain.model.EventAttendee;
import com.crackelets.bigfun.platform.booking.domain.persistence.EventAttendeeRepository;
import com.crackelets.bigfun.platform.booking.domain.persistence.EventRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EventAttendeeServiceTest {
    @InjectMocks
    private EventAttendeeServiceImpl eventAttendeeService;
    @Mock
    private EventAttendeeRepository eventAttendeeRepository;
    @Mock
    private EventRepository eventRepository;
    @Test
    public void testGetAll() {
        List<EventAttendee> mockEventAttendees = Arrays.asList(new EventAttendee(), new EventAttendee());
        when(eventAttendeeRepository.findAll()).thenReturn(mockEventAttendees);
        List<EventAttendee> result = eventAttendeeService.getAll();
        assertEquals(2, result.size());
    }
    @Test
    public void testGetAllAttendeesByEventId() {
        long eventId = 1L;
        Event mockEvent = new Event();
        mockEvent.setId(eventId);
        List<EventAttendee> mockEventAttendees = Arrays.asList(new EventAttendee(), new EventAttendee());
        when(eventRepository.findById(eventId)).thenReturn(Optional.of(mockEvent));
        when(eventAttendeeRepository.findAllByEvent(Optional.of(mockEvent))).thenReturn(mockEventAttendees);
        List<EventAttendee> result = eventAttendeeService.getAllAttendeesByEventId(eventId);
        assertEquals(2, result.size());
    }

}
