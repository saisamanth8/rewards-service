package com.example.service.springbootrewards;

import com.example.service.springbootrewards.entities.Customer;
import com.example.service.springbootrewards.rewards.repository.CustomerRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@DataJpaTest
@Disabled
class CustomerRepositoryTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerRepository customerRepositoryImpl;

    @Test
    void testFindAll() {
        List<Customer> customers = Arrays.asList(
                new Customer(1, "John"),
                new Customer(2, "Alice")
        );
        when(customerRepository.findAll()).thenReturn(customers);
        List<Customer> result = customerRepositoryImpl.findAll();
        assertEquals(customers.size(), result.size());
        assertEquals(customers.get(0), result.get(0));
        assertEquals(customers.get(1), result.get(1));
        verify(customerRepository, times(1)).findAll();
    }

    @Test
    void testFindById_WithValidId() {
        Customer customer = new Customer(1, "John");
        when(customerRepository.findById(1)).thenReturn(Optional.of(customer));
        Optional<Customer> result = customerRepositoryImpl.findById(1);
        assertEquals(customer, result.orElse(null));
        verify(customerRepository, times(1)).findById(1);
    }

    @Test
    void testFindById_WithInvalidId() {
        when(customerRepository.findById(1)).thenReturn(Optional.empty());
        Optional<Customer> result = customerRepositoryImpl.findById(1);
        assertEquals(Optional.empty(), result);
        verify(customerRepository, times(1)).findById(1);
    }

}
