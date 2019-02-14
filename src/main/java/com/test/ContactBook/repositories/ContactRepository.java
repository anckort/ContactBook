package com.test.ContactBook.repositories;

import com.test.ContactBook.entities.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact,Long> {
    Contact getContactById(Long id);
}
