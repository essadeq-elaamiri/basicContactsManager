package miri.pro.basic_contacts_manager;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import miri.pro.basic_contacts_manager.data.DataGateway;
import miri.pro.basic_contacts_manager.data.DataGatewayImp;
import miri.pro.basic_contacts_manager.model.ContactModel;
import miri.pro.basic_contacts_manager.model.ContactType;
import miri.pro.basic_contacts_manager.model.ContactsBook;


public class AddNewContactFragment extends Fragment {
    // views
    private EditText nameEditText;
    private EditText emailEditText;
    private EditText phoneNumberEditText;
    private Spinner contactTypeSpinner;
    private Button saveContactButton;
    private Button resetFields;

    View  view;
    DataGateway dataGateway;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_add_new_contact, container, false);
        //init views
        saveContactButton = view.findViewById(R.id.saveContactButton);
        resetFields = view.findViewById(R.id.resetFields);
        nameEditText = view.findViewById(R.id.nameEditText);
        emailEditText = view.findViewById(R.id.emailEditText);
        phoneNumberEditText = view.findViewById(R.id.phoneNumberEditText);
        contactTypeSpinner = view.findViewById(R.id.contactTypeSpinner);

        dataGateway = new DataGatewayImp();

        // init spinner
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                        R.array.contacts_types, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        contactTypeSpinner.setAdapter(adapter);

        resetFields.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetFields();
            }
        });

        saveContactButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveContact();
                //dataGateway.saveData(getContext(), );

            }
        });

        return view;
    }

    private void resetFields() {
        nameEditText.setText("");
        emailEditText.setText("");
        phoneNumberEditText.setText("");

    }

    private void saveContact() {
        ContactModel contactModel = new ContactModel();
        contactModel.setContactName(nameEditText.getText().toString());
        contactModel.setEmail(emailEditText.getText().toString());
        contactModel.setPhoneNumber(phoneNumberEditText.getText().toString());
        String chosenContactType = (String)contactTypeSpinner.getSelectedItem();
        contactModel.setContactType(ContactType.OTHER);
        for (ContactType contactType: ContactType.values()){
            if(chosenContactType.contains(contactType.toString())){
                contactModel.setContactType(contactType);
            }
        }


        // add to list
        ContactsBook.addContact(contactModel);
        System.out.println("Contact: "+ contactModel);

        // save to file
        dataGateway.saveData(getContext(), ContactsBook.getContactsBookList());
    }


}