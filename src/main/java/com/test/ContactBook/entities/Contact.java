package com.test.ContactBook.entities;

import com.google.gson.annotations.Expose;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "contacts")
public class Contact {
    @Id
    @Column(name = "contacts_id")
    @SequenceGenerator(name = "contacts_seq", sequenceName = "contacts_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contacts_seq")
    @Expose
    private Long id;

    @Column(name = "last_name")
    @Expose
    private String lastName;

    @Column(name = "first_name")
    @Expose
    private String firstName;

    @Column(name = "email")
    @Expose
    private String email;

    @OneToMany(mappedBy = "contactId", fetch = FetchType.EAGER)
    @Expose
    private List<PhoneNumber> phoneNumbers;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public List <PhoneNumber> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List <PhoneNumber> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Contact{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", email='" + email + '\'');
        stringBuilder.append(",Phones{"+'\'');
        for(PhoneNumber number:phoneNumbers){
            stringBuilder.append(number.toString());
        }
        stringBuilder.append('}'+'}');
        return stringBuilder.toString();
    }
}
