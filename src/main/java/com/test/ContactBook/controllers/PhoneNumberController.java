package com.test.ContactBook.controllers;

import com.test.ContactBook.entities.Contact;
import com.test.ContactBook.services.ContactService;
import com.test.ContactBook.entities.PhoneNumber;
import com.test.ContactBook.services.PhoneNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "phoneNumber")
public class PhoneNumberController {
    @Autowired
    private PhoneNumberService phoneNumberService;
    private PhoneNumber phoneNumber;

    @Autowired
    ContactService contactService;

    @RequestMapping(value = "/savePhoneNumber", method = RequestMethod.POST)
    public @ResponseBody String savePhoneNumber(@RequestParam(name = "operator_name") String operatorName,
                                                @RequestParam(name = "number") String number,
                                                @RequestParam(name = "contact_id")Long contact_id){
        Contact contact = contactService.getContactById(contact_id);
        PhoneNumber phoneNumber = new PhoneNumber();
        phoneNumber.setContactId(contact);
        phoneNumber.setNumber(number);
        phoneNumber.setOperatorName(operatorName);

        phoneNumberService.savePhoneNumber(phoneNumber);
        return "ok";
    }

    @RequestMapping(value = "/updatePhoneNumber", method = RequestMethod.PATCH)
    public @ResponseBody String updatePhoneNumber(@RequestParam(name = "operator_name") String operatorName,
                                                  @RequestParam(name = "number") String number,
                                                  @RequestParam(name = "contact_id")Long contact_id,
                                                  @RequestParam(name = "phone_number_id") Long id){
        Contact contact = contactService.getContactById(contact_id);
        PhoneNumber phoneNumber = new PhoneNumber();
        phoneNumber.setContactId(contact);
        phoneNumber.setNumber(number);
        phoneNumber.setOperatorName(operatorName);
        phoneNumber.setId(id);
        phoneNumberService.savePhoneNumber(phoneNumber);
        return "ok";
    }

    @RequestMapping(value = "/getAllPhoneNumbers", method = RequestMethod.GET)
    public @ResponseBody
    String getAllPhoneNumbers(@RequestParam(name = "id") Long id){
        return phoneNumberService.getAllById(id).toString();
    }
}

