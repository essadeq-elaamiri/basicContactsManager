package miri.pro.basic_contacts_manager.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import miri.pro.basic_contacts_manager.R;
import miri.pro.basic_contacts_manager.model.ContactModel;
import miri.pro.basic_contacts_manager.model.ContactsBook;

public class ContactsListAdapter extends ArrayAdapter<ContactModel> {
    private Context context;
    private List<ContactModel> contactModels = new ArrayList<>();

    private TextView contactNameTextView;
    private TextView contactEmailTextView;
    private TextView contactPhoneTextView;
    private TextView contactTypeTextView;

    public ContactsListAdapter(@NonNull Context context, List<ContactModel> contactModels) {
        super(context, 0);
        if(context == null){
            context = getContext();
        }
        this.context = context;
        this.contactModels = contactModels;
    }

    @NonNull
    @Override
    /**
     * This view is called when a listItem needs to be created and populated with the data.In this method
     * first the View is inflated using the LayoutInflator.inflate() method. It is important
     * that you check that if the view you are trying to inflate is new or reused.
     * If convertView == null then the view should be inflated.
     */
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        System.out.println("========== getView ==========");
        View listItem = convertView;
        if(listItem == null)
            listItem = LayoutInflater.from(context).inflate(R.layout.single_contact_item,parent,false);

        ContactModel current = this.contactModels.get(position);
        System.out.println(current.toString());
        contactNameTextView = listItem.findViewById(R.id.contactNameTextView);
        contactEmailTextView = listItem.findViewById(R.id.contactEmailTextView);
        contactPhoneTextView = listItem.findViewById(R.id.contactPhoneTextView);
        contactTypeTextView = listItem.findViewById(R.id.contactTypeTextView);

        contactNameTextView.setText(current.getContactName());
        contactEmailTextView.setText(current.getEmail());
        contactPhoneTextView.setText(current.getPhoneNumber());
        contactTypeTextView.setText(current.getContactType().name());

        System.out.println("From adapter:" + current);
        return listItem;

    }
}
