package miri.pro.basic_contacts_manager.data;

import java.io.File;

import miri.pro.basic_contacts_manager.model.ContactsBook;

public interface DataGateway {
    /**
     * this class's function is to:
     * 1. save data to json file using Gson
     * 2. load data from the json file
     * ------------------------------
     * every time the application runs, we load data in a ContactsBook object
     * every operation with data will be done on the HashMap of ContactsBook object
     * so the list view will display the content of the hashmap all the time
     * when the application closed we will commit and save data to the json file
     * and so on
     *
     */

    ContactsBook loadData(File file);
    void saveData(File file, ContactsBook contactsBook);

}
