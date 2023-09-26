package com.crackelets.bigfun.platform.profile.service;

import com.crackelets.bigfun.platform.payment.domain.model.Payment;
import com.crackelets.bigfun.platform.payment.domain.persistence.PaymentRepository;
import com.crackelets.bigfun.platform.profile.domain.model.Attendee;
import com.crackelets.bigfun.platform.profile.domain.persistence.AttendeeRepository;
import com.crackelets.bigfun.platform.shared.exception.ResourceNotFoundException;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import javax.validation.Validator;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.skyscreamer.jsonassert.JSONAssert.assertEquals;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
public class AttendeeServiceTest {

    @InjectMocks
    private AttendeeServiceImpl attendeeService;

    @Mock
    private AttendeeRepository attendeeRepository;

    @Mock
    private Validator attendeeValidator;

    @Test
    @DisplayName("Get All Attendees- Ok")
    public void testGetAllAttendees() {
        List<Attendee> expected = Arrays.asList(new Attendee(), new Attendee());
        when(attendeeRepository.findAll()).thenReturn(expected);
        List<Attendee> actual = attendeeService.getAll();
        Assertions.assertEquals(expected.size(), actual.size());
    }

    @Test
    @DisplayName("Get All Pageable Attendees - Ok")
    public void testGetAllPageableAttendees() {
        Page<Attendee> expected = new PageImpl<>(Arrays.asList(new Attendee(), new Attendee()));
        when(attendeeRepository.findAll(any(Pageable.class))).thenReturn(expected);
        Page<Attendee> actual = attendeeService.getAll(Pageable.unpaged());
        Assertions.assertEquals(expected, actual);
    }


}
























