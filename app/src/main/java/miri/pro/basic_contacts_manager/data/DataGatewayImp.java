package miri.pro.basic_contacts_manager.data;

import java.io.File;

import miri.pro.basic_contacts_manager.model.ContactsBook;

public class DataGatewayImp implements DataGateway{
    @Override
    public ContactsBook loadData(File file) {
        /**
         * TODO: read the entire file, get the content as string
         * convert it to ContactsBook object and return it
         *
         */
        return null;
    }

    @Override
    public void saveData(File file, ContactsBook contactsBook) {
        /**
         * TODO: convert the object to JsonString and save it to the file
         */
    }
}
