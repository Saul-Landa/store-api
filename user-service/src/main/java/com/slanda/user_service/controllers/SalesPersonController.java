package com.slanda.user_service.controllers;

import com.slanda.user_commons.models.SalesPerson;
import com.slanda.user_service.services.ISalesPersonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SalesPersonController {
    private final ISalesPersonService salesPersonService;

    public SalesPersonController(ISalesPersonService salesPersonService) {
        this.salesPersonService = salesPersonService;
    }

    @GetMapping("/sales-person")
    public SalesPerson findByUsername(@RequestParam String username) {
        return salesPersonService.findByUsername(username);
    }
}
