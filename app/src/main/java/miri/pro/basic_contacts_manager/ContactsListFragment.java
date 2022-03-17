package miri.pro.basic_contacts_manager;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.gson.internal.LinkedTreeMap;

import java.util.ArrayList;
import java.util.List;

import miri.pro.basic_contacts_manager.adapters.ContactsListAdapter;
import miri.pro.basic_contacts_manager.model.ContactModel;
import miri.pro.basic_contacts_manager.model.ContactsBook;


public class ContactsListFragment extends Fragment {
    private ListView contactsListView;
    private View view;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    // va se charger d'injecter la resource de layout du fragment dans le fragmet (class)
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        this.view = inflater.inflate(R.layout.fragment_contacts_list, container, false);

        contactsListView = view.findViewById(R.id.contactsListView);



        List<ContactModel> contactList = new ArrayList<>(ContactsBook.getContactsBookList().values());

        //System.out.println("==========================");
        //System.out.println(ContactsBook.getContactsBookList().values().getClass().toString());
        //System.out.println(ContactsBook.getContactsBookList().values().isEmpty() );
        //System.out.println(contactList.size());
        /*
        for (ContactModel str: ContactsBook.getContactsBookList().values()) {
            ContactModel contactModel_ = new ContactModel();
            contactModel_.setContactName(str.getContactName());
            contactModel_.setEmail(str.getEmail());
            contactModel_.setPhoneNumber(str.getPhoneNumber());
            contactModel_.setContactType(str.getContactType());
            contactList.add(contactModel_);
        }

         */


        //ArrayAdapter adapter = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, contactList);
        ArrayAdapter<ContactModel> adapter = new ContactsListAdapter(getContext(),R.layout.single_contact_item, contactList);

        //TODO: 1- create the adapter, validate before saving , return to list after saving, improve UI

        contactsListView.setAdapter(adapter);

        return view;
    }

    private class ClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {

        }
    }
}