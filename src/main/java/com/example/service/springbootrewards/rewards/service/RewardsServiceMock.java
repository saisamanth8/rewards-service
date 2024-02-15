package com.example.service.springbootrewards.rewards.service;

import com.example.service.springbootrewards.entities.Customer;
import com.example.service.springbootrewards.entities.Transaction;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class RewardsServiceMock {

    private static List<Transaction> transactions = new ArrayList<Transaction>();
    private static long index;

    static {
        transactions.add(new Transaction(index++, new Customer(1, "Alex"), 100.0, "Order 1", new Date()));
        transactions.add(new Transaction(index++, new Customer(2, "Ram"), 50.0, "Order 2", new Date()));
        transactions.add(new Transaction(index++, new Customer(3, "Rahim"), 120.0, "Order 3", new Date()));
    }

    public List<Transaction> getAll() {
        return transactions;
    }

}
