package com.slanda.order_service.utils;

import com.slanda.order_service.services.IOrderStatusService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class InitialData implements CommandLineRunner {
    private final IOrderStatusService orderStatusService;

    public InitialData(IOrderStatusService orderStatusService) {
        this.orderStatusService = orderStatusService;
    }

    @Override
    public void run(String... args) {
        try {
            Arrays.asList(
                    GlobalVariables.PENDING_STATUS,
                    GlobalVariables.DELIVERED_STATUS,
                    GlobalVariables.CANCELED_STATUS)
            .forEach(statusName -> {
                if ( orderStatusService.findByName(statusName) == null ) {
                    orderStatusService.save(statusName);
                }
            });
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}
