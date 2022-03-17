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
import android.widget.Toast;

import miri.pro.basic_contacts_manager.data.DataGateway;
import miri.pro.basic_contacts_manager.data.DataGatewayImp;
import miri.pro.basic_contacts_manager.model.ContactGender;
import miri.pro.basic_contacts_manager.model.ContactModel;
import miri.pro.basic_contacts_manager.model.ContactType;
import miri.pro.basic_contacts_manager.model.ContactsBook;


public class AddNewContactFragment extends Fragment {
    // views
    private EditText nameEditText;
    private EditText emailEditText;
    private EditText phoneNumberEditText;
    private Spinner contactTypeSpinner;
    private Spinner contactGenderSpinner;
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
        contactGenderSpinner = view.findViewById(R.id.contactGenderSpinner);

        dataGateway = new DataGatewayImp();

        // init spinner
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                        R.array.contacts_types, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        contactTypeSpinner.setAdapter(adapter);

        ArrayAdapter<CharSequence> contactGenderAdapter = ArrayAdapter.createFromResource(getContext(),
                R.array.contacts_gender, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        contactGenderSpinner.setAdapter(contactGenderAdapter);


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
        //data
        String inName = nameEditText.getText().toString();
        String inEmail = emailEditText.getText().toString();
        String inPhone = phoneNumberEditText.getText().toString();
        // validate data before saving
        String inErrors = validateData(inName, inEmail, inPhone);
        if(inErrors.isEmpty() || inErrors.equals("")){
            ContactModel contactModel = new ContactModel();
            contactModel.setContactName(inName);
            contactModel.setEmail(inEmail);
            contactModel.setPhoneNumber(inPhone);
            String chosenContactType = (String)contactTypeSpinner.getSelectedItem();
            String chosenContactGender = (String)contactGenderSpinner.getSelectedItem();
            contactModel.setContactType(ContactType.OTHER);
            contactModel.setContactGender(ContactGender.MALE);
            for (ContactType contactType: ContactType.values()){
                if(chosenContactType.contains(contactType.toString())){
                    contactModel.setContactType(contactType);
                }
            }
            for (ContactGender contactGender: ContactGender.values()){
                if(chosenContactGender.contains(contactGender.toString())){
                    contactModel.setContactGender(contactGender);
                }
            }


            // add to list
            ContactsBook.addContact(contactModel);
            System.out.println("Contact: "+ contactModel);

            // save to file
            dataGateway.saveData(getContext(), ContactsBook.getContactsBookList());

            //
            Toast.makeText(getContext(), "Contact saved successfully", Toast.LENGTH_SHORT).show();
            resetFields();
        }
        else {
            Toast.makeText(getContext(), inErrors, Toast.LENGTH_SHORT).show();
        }
    }

    private String validateData(String name, String email, String phoneNumber){
        String errors = "";
        if(name.isEmpty() || name.length()<3){
            errors+="Invalid name: Enter a valid please (min 3 chars).";
        }
        if (!email.matches("[a-z0-9]+@[a-z]+\\.[a-z]{2,3}")){
            errors+="\nInvalid email: Enter a valid email address please.";

        }
        if(!phoneNumber.matches("((\\+2126)|(\\+2127)|(06)|(07))[0-9]{8}")){
            errors+="\nInvalid phone num: Enter a valid phone number please (0611223344).";
        }
        return errors;

    }

}