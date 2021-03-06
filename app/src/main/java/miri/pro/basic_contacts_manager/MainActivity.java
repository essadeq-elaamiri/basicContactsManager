package miri.pro.basic_contacts_manager;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import miri.pro.basic_contacts_manager.data.DataGateway;
import miri.pro.basic_contacts_manager.data.DataGatewayImp;
import miri.pro.basic_contacts_manager.model.ContactModel;
import miri.pro.basic_contacts_manager.model.ContactsBook;

public class MainActivity extends AppCompatActivity {

    // views
    private BottomNavigationView bottomNavigationView;
    private Toolbar toolBareInner;

    DataGateway dataGateway;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //init variables
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        toolBareInner = findViewById(R.id.toolBareInner);

        dataGateway = new DataGatewayImp();

        //init fragment
        replaceFragment(new ContactsListFragment());
        bottomNavigationView.setOnItemSelectedListener(itemSelectedListener);

        // empty file
        // dataGateway.emptyListBook(this);
        // init ContactsBook from file
        ContactsBook.addAllContacts(dataGateway.loadData(this));



    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.contactsListFragmentLayout, fragment);
        fragmentTransaction.commit();

    }

    private NavigationBarView.OnItemSelectedListener itemSelectedListener = new NavigationBarView.OnItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            //Toast.makeText(MainActivity.this, "item "+item.getItemId() , Toast.LENGTH_SHORT).show();
            if(item.getItemId() == R.id.contactsListMenuItem){
                toolBareInner.setTitle("Contact list");
                replaceFragment(new ContactsListFragment());
            }
            else if(item.getItemId() == R.id.addContactMenuItem){
                toolBareInner.setTitle("Add new contact");
                replaceFragment(new AddNewContactFragment());

            }
            return false;
        }
    };



}