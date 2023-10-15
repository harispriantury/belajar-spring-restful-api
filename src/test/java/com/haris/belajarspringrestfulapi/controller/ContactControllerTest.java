package com.haris.belajarspringrestfulapi.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.haris.belajarspringrestfulapi.entity.User;
import com.haris.belajarspringrestfulapi.model.CreateContactRequest;
import com.haris.belajarspringrestfulapi.model.WebResponse;
import com.haris.belajarspringrestfulapi.repository.ContactRepository;
import com.haris.belajarspringrestfulapi.repository.UserRepository;
import com.haris.belajarspringrestfulapi.security.BCrypt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ContactControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {contactRepository.deleteAll();}

    @Test
    void createContactSuccess() throws Exception{
        User user = new User();
        user.setUsername("haris");
        user.setPassword(BCrypt.hashpw("priantury", BCrypt.gensalt()));
        user.setName("nama baru");
        user.setToken("token");
        user.setTokenExpiredAt(System.currentTimeMillis() + 100000000000L);
        userRepository.save(user);

        CreateContactRequest request = new CreateContactRequest();
        request.setFirstName("andi");
        request.setLastName("kurniawan");
        request.setEmail("andi@gmail.com");
        request.setPhone("0849384923849");

        mockMvc.perform(
                post("/api/contacts")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request))
        ).andExpectAll(
                status().isOk()
        ).andDo(result -> {
            WebResponse<String> response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
            });
            assertNull(response.getErrors());
        });
    }


}