package miri.pro.basic_contacts_manager.data;

import android.content.Context;

import java.io.File;
import java.util.HashMap;

import miri.pro.basic_contacts_manager.model.ContactModel;
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

    HashMap<String, ContactModel> loadData(Context context);
    void saveData(Context context, HashMap<String, ContactModel> contactsBook);
    public void emptyListBook(Context context);


    }
