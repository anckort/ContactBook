package com.test.ContactBook.repositories;

import com.test.ContactBook.entities.PhoneNumber;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PhoneNumberRepository extends JpaRepository<PhoneNumber,Long> {
    List<PhoneNumber> getAllByContactId(Long contactId);
}
