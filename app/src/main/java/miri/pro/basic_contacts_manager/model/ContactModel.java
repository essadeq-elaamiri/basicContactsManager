package miri.pro.basic_contacts_manager.model;

import java.io.Serializable;

public class ContactModel implements Serializable {
    private String contactName;
    private String email;
    private String phoneNumber;
    private ContactType contactType;

    public ContactModel() {
    }

    public ContactModel(String contactName, String email, String phoneNumber, ContactType contactType) {
        this.contactName = contactName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.contactType = contactType;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public ContactType getContactType() {
        return contactType;
    }

    public void setContactType(ContactType contactType) {
        this.contactType = contactType;
    }
}
