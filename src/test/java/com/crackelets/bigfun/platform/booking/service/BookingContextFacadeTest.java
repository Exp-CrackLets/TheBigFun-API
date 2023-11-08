package com.crackelets.bigfun.platform.booking.service;


import com.crackelets.bigfun.platform.booking.api.internal.BookingContextFacade;
import com.crackelets.bigfun.platform.booking.domain.model.Event;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BookingContextFacadeTest {

    @InjectMocks
    private  BookingContextFacadeImpl bookingContextFacade;
    @Mock
    private EventServiceImpl eventService;

    @Test
    public void testGetAllEvents() {
        List<Event> mockEvents = Arrays.asList(new Event(), new Event());
        when(eventService.getAll()).thenReturn(mockEvents);
        BookingContextFacade bookingContextFacade = new BookingContextFacadeImpl(eventService);
        List<Event> result = bookingContextFacade.getAllEvents();
        assertEquals(2, result.size());
    }

}
