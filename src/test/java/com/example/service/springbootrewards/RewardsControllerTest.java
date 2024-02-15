package com.example.service.springbootrewards;

import com.example.service.springbootrewards.entities.Customer;
import com.example.service.springbootrewards.rewards.controller.RewardsController;
import com.example.service.springbootrewards.rewards.service.RewardsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class RewardsControllerTest {

    @Mock
    private RewardsService rewardsService;

    @InjectMocks
    private RewardsController rewardsController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void findCustomerAll_ReturnsListOfCustomers() {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer(1, "John"));
        customers.add(new Customer(2, "Alice"));
        when(rewardsService.getCustomerAll()).thenReturn(customers);
        List<Customer> result = rewardsController.findCustomerAll();
        assertEquals(customers.size(), result.size());
        assertEquals(customers.get(0), result.get(0));
        assertEquals(customers.get(1), result.get(1));
        verify(rewardsService, times(1)).getCustomerAll();
    }

    @Test
    void getCustomer_WithValidId_ReturnsCustomer() {
        Customer customer = new Customer(1, "John");
        when(rewardsService.getCustomerById(1)).thenReturn(customer);
        ResponseEntity<Customer> responseEntity = rewardsController.getCustomer(1);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(customer, responseEntity.getBody());
        verify(rewardsService, times(1)).getCustomerById(1);
    }

    @Test
    void getCustomer_WithInvalidId_ReturnsNotFound() {
        when(rewardsService.getCustomerById(1)).thenReturn(null);
        ResponseEntity<Customer> responseEntity = rewardsController.getCustomer(1);
        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
        verify(rewardsService, times(1)).getCustomerById(1);
    }
}
