package com.test.ContactBook.services;

import com.test.ContactBook.entities.*;
import com.test.ContactBook.repositories.PhoneNumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneNumberServiceImpl implements PhoneNumberService {
    @Autowired
    PhoneNumberRepository phoneNumberRepository;
    @Override
    public List<PhoneNumber> getAllById(Long contactId) {
        return phoneNumberRepository.getAllByContactId(contactId);
    }

    @Override
    public void savePhoneNumber(PhoneNumber phoneNumber) {
        phoneNumberRepository.save(phoneNumber);
    }

}
