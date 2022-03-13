package miri.pro.basic_contacts_manager.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

public final class ContactsBook implements Serializable {
    private static HashMap<String, ContactModel> contactModelHashMap = new HashMap<>();

    public ContactModel getContact(String nom){
        return this.contactModelHashMap.get(nom);
    }

    public static void addContact(ContactModel contactModel){
        contactModelHashMap.put(contactModel.getContactName(), contactModel);
    }

    public  static boolean isContactExist(ContactModel contactModel){
        if (contactModelHashMap.containsKey(contactModel.getContactName())){
            return true;
        }
        else{
            return false;
        }
    }

    public static HashMap<String, ContactModel> getContactsBoolList(){
        return contactModelHashMap;
    }


}
