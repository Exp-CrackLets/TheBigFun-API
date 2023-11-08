package com.crackelets.bigfun.platform.booking.service;

import com.crackelets.bigfun.platform.booking.domain.model.Event;
import com.crackelets.bigfun.platform.booking.domain.model.EventPayment;
import com.crackelets.bigfun.platform.booking.domain.persistence.EventPaymentRepository;
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
public class EventPaymentServiceTest {

    @InjectMocks
    private  EventPaymentServiceImpl eventPaymentService;

    @Mock
    private EventPaymentRepository eventPaymentRepository;

    @Mock
    private EventRepository eventRepository;

    @Test
    public void testGetAll() {
        List<EventPayment> mockEventPayments = Arrays.asList(new EventPayment(), new EventPayment());
        when(eventPaymentRepository.findAll()).thenReturn(mockEventPayments);
        List<EventPayment> result = eventPaymentService.getAll();
        assertEquals(2, result.size());
    }

    @Test
    public void testGetAllPaymentByEventId() {
        long eventId = 1L;
        Event mockEvent = new Event();
        mockEvent.setId(eventId);
        List<EventPayment> mockEventPayments = Arrays.asList(new EventPayment(), new EventPayment());
        when(eventRepository.findById(eventId)).thenReturn(Optional.of(mockEvent));
        when(eventPaymentRepository.findAllByEvent(Optional.of(mockEvent))).thenReturn(mockEventPayments);
        List<EventPayment> result = eventPaymentService.getAllPaymentByEventId(eventId);
        assertEquals(2, result.size());
    }

}
