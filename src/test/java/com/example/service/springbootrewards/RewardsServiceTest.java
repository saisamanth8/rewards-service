package com.example.service.springbootrewards;

import com.example.service.springbootrewards.rewards.repository.CustomerRepository;
import com.example.service.springbootrewards.rewards.service.RewardsService;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class RewardsServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private RewardsService rewardsService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }
}
