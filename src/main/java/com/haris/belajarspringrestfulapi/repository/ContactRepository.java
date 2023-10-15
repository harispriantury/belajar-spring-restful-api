package com.haris.belajarspringrestfulapi.repository;

import com.haris.belajarspringrestfulapi.entity.Contact;
import com.haris.belajarspringrestfulapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContactRepository extends JpaRepository<Contact, String>, JpaSpecificationExecutor<Contact> {
    Optional<Contact> findFirstByUserAndId(User user, String id);
}
