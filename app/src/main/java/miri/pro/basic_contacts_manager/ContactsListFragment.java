package miri.pro.basic_contacts_manager;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


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
        List<String> list = new ArrayList<>();
        for (int i=0; i< 11; i++){
            list.add("Contact "+i);
        }
        ListAdapter adapter = new ArrayAdapter<String>(this.getContext(), android.R.layout.simple_list_item_1 , list);

        contactsListView.setAdapter(adapter);

        return view;
    }

    private class ClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {

        }
    }
}