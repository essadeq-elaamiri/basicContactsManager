package miri.pro.basic_contacts_manager.model;

import java.util.HashMap;
import java.util.List;

public class ContactsBook {
    private HashMap<String, ContactModel> contactModelHashMap = new HashMap<>();

    public ContactModel getContact(String nom){
        return this.contactModelHashMap.get(nom);
    }

    public void addContact(ContactModel contactModel){
        this.contactModelHashMap.put(contactModel.getContactName(), contactModel);
    }

    public boolean isContactExist(ContactModel contactModel){
        if (this.contactModelHashMap.containsKey(contactModel.getContactName())){
            return true;
        }
        else{
            return false;
        }
    }


}
