package com.test.ContactBook.controllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.test.ContactBook.entities.Contact;
import com.test.ContactBook.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
@RequestMapping(value = "contact")
public class ContactController {
    @Autowired
    private ContactService contactService;

    @RequestMapping(value = "/getAllContacts", method = RequestMethod.GET)
    public @ResponseBody
    String getAllContacts(){
        ArrayList<Contact> contacts = (ArrayList <Contact>) contactService.getAll();
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        StringBuilder builder = new StringBuilder();
        for(Contact contact:contacts) {
            builder.append(gson.toJson(contact));
        }
        return builder.toString();
    }

    @RequestMapping(value = "/saveContact", method = RequestMethod.POST)
    public @ResponseBody
    String saveContact(@RequestParam(name = "first_name") String firstName,
                       @RequestParam(name = "last_name") String lastName,
                       @RequestParam(name = "email") String email){
        Contact contact = new Contact();
        contact.setFirstName(firstName);
        contact.setEmail(email);
        contact.setLastName(lastName);
        contactService.saveContact(contact);
        return "ok";
    }
    @RequestMapping(value = "/updateContact", method = RequestMethod.PATCH)
    public @ResponseBody
    String updateContact(@RequestParam(name = "contact_id") Long id,
                        @RequestParam(name = "first_name") String firstName,
                       @RequestParam(name = "last_name") String lastName,
                       @RequestParam(name = "email") String email){
        Contact contact = new Contact();
        contact.setFirstName(firstName);
        contact.setEmail(email);
        contact.setLastName(lastName);
        contact.setId(id);
        contactService.saveContact(contact);
        return "ok";
    }
}
