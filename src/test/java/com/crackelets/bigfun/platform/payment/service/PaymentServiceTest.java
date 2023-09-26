package com.crackelets.bigfun.platform.payment.service;

import com.crackelets.bigfun.platform.payment.domain.model.Payment;
import com.crackelets.bigfun.platform.payment.domain.persistence.PaymentRepository;
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

import javax.xml.validation.Validator;
import java.util.HashSet;
import java.util.List;
import java.util.Arrays;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
public class PaymentServiceTest {
    @InjectMocks
    private PaymentServiceImpl paymentService;

    @Mock
    private PaymentRepository paymentRepository;

    @Mock
    private Validator paymentValidator;
    @Test
    @DisplayName("Get All - Ok")
    public void testGetAllPayments() {
        List<Payment> expected = Arrays.asList(new Payment(), new Payment());
        when(paymentRepository.findAll()).thenReturn(expected);
        List<Payment> actual = paymentService.getAll();
        Assertions.assertEquals(expected.size(), actual.size());
    }

    @Test
    @DisplayName("Get All Pageable - Ok")
    public void testGetAllPageablePayments() {
        Page<Payment> expected = new PageImpl<>(Arrays.asList(new Payment(), new Payment()));
        when(paymentRepository.findAll(any(Pageable.class))).thenReturn(expected);
        Page<Payment> actual = paymentService.getAll(Pageable.unpaged());
        Assertions.assertEquals(expected, actual);
    }
    @Test
    @DisplayName("Get by Id - Ok")
    public void testGetByIdPayments() {
        Payment expected = new Payment();
        when(paymentRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(expected));
        Payment actual = paymentService.getById(1L);
        Assertions.assertEquals(expected, actual);
    }
    @Test
    @DisplayName("Create Payment - Ok")
    public void createPayment() {
        Payment expected = new Payment();
        when(paymentRepository.save(any(Payment.class))).thenReturn(expected);
        Payment actual = paymentService.create(new Payment());
        Assertions.assertEquals(expected, actual);
    }
}
