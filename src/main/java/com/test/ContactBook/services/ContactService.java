package com.test.ContactBook.services;

import com.test.ContactBook.entities.Contact;

import java.util.List;

public interface ContactService {
    List<Contact> getAll();
    void saveContact(Contact contact);
    Contact getContactById(Long id);
}
