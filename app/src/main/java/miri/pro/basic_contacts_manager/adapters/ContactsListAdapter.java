package miri.pro.basic_contacts_manager.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import miri.pro.basic_contacts_manager.R;
import miri.pro.basic_contacts_manager.model.ContactGender;
import miri.pro.basic_contacts_manager.model.ContactModel;
import miri.pro.basic_contacts_manager.model.ContactType;
import miri.pro.basic_contacts_manager.model.ContactsBook;

public class ContactsListAdapter extends ArrayAdapter<ContactModel> {
    private final int res;
    private Context context;
    private List<ContactModel> contactModels = new ArrayList<>();

    private ImageView contactImageView;
    private TextView contactNameTextView;
    private TextView contactEmailTextView;
    private TextView contactPhoneTextView;
    private TextView contactTypeTextView;

    public ContactsListAdapter(@NonNull Context context, @LayoutRes int res, List<ContactModel> contactModels) {
        super(context, res, contactModels);
        this.context = context;
        this.contactModels = contactModels;
        this.res = res;
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
        View listItem = convertView;
        if(listItem == null)
            //listItem = LayoutInflater.from(context).inflate(R.layout.single_contact_item,parent,false);
            listItem = LayoutInflater.from(context).inflate(res, parent, false);

        ContactModel current = this.contactModels.get(position);
        contactImageView = listItem.findViewById(R.id.contactImageView);
        contactNameTextView = listItem.findViewById(R.id.contactNameTextView);
        contactEmailTextView = listItem.findViewById(R.id.contactEmailTextView);
        contactPhoneTextView = listItem.findViewById(R.id.contactPhoneTextView);
        contactTypeTextView = listItem.findViewById(R.id.contactTypeTextView);

        // TODO: change image with the gender
        //
        if(current.getContactGender() == ContactGender.FEMALE){
            contactImageView.setImageResource(R.mipmap.female_user);
        }
        else {
            contactImageView.setImageResource(R.mipmap.male_user);
        }

        switch (current.getContactType()){
            case FAMILY:
                contactTypeTextView.setTextColor( parent.getResources().getColor(R.color.green_type));
                break;
            case PERSONAL:
                contactTypeTextView.setTextColor( parent.getResources().getColor(R.color.orange_type));
                break;
            case PROFESSIONAL:
                contactTypeTextView.setTextColor( parent.getResources().getColor(R.color.purple_type));
                break;
            default: // OTHER
                contactTypeTextView.setTextColor( parent.getResources().getColor(R.color.blue_type));

                break;

        }
        contactNameTextView.setText(current.getContactName());
        contactEmailTextView.setText(current.getEmail());
        contactPhoneTextView.setText(current.getPhoneNumber());
        contactTypeTextView.setText(current.getContactType().name());

        return listItem;

    }
}
