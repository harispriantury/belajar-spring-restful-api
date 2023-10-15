package com.haris.belajarspringrestfulapi.controller;


import com.haris.belajarspringrestfulapi.entity.User;
import com.haris.belajarspringrestfulapi.model.ContactResponse;
import com.haris.belajarspringrestfulapi.model.CreateContactRequest;
import com.haris.belajarspringrestfulapi.model.WebResponse;
import com.haris.belajarspringrestfulapi.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {
    @Autowired
    private ContactService contactService;
    
    @PostMapping(
            path = "/api/contacs",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    
    public WebResponse<Object> create(User user, @RequestBody CreateContactRequest request) {
        ContactResponse contactResponse = contactService.create(user, request);
        return WebResponse.builder().data(contactResponse).build();
    }
}
