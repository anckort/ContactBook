package com.test.ContactBook.entities;

import com.google.gson.annotations.Expose;

import javax.persistence.*;

@Entity
@Table(name = "phone_numbers")
public class PhoneNumber {
    @Id
    @Column(name = "phone_numbers_id")
    @SequenceGenerator(name = "phone_numbers_seq", sequenceName = "phone_numbers_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "phone_numbers_seq")
    @Expose
    private Long id;

    @Column(name = "operator_name")
    @Expose
    private String operatorName;

    @Column(name = "number")
    @Expose
    private String number;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "contact_id")
    @Expose(serialize = false)
    private Contact contactId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Contact getContactId() {
        return contactId;
    }

    public void setContactId(Contact contactId) {
        this.contactId = contactId;
    }

    @Override
    public String toString() {
        return "PhoneNumber{" +
                ", operatorName='" + operatorName + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
