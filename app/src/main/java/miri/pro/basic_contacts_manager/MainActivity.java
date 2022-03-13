package miri.pro.basic_contacts_manager;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import miri.pro.basic_contacts_manager.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    // views
    //private Button addNewContactButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //init variables
        //addNewContactButton = findViewById(R.id.addNewContactButton);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        //init fragment
        replaceFragment(new ContactsListFragment());

       bottomNavigationView.setOnItemSelectedListener(itemSelectedListener);

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
            Toast.makeText(MainActivity.this, "item "+item.getItemId() , Toast.LENGTH_SHORT).show();
            if(item.getItemId() == R.id.contactsListMenuItem){
                replaceFragment(new ContactsListFragment());
            }
            else if(item.getItemId() == R.id.addContactMenuItem){
                replaceFragment(new AddNewContactFragment());

            }
            return false;
        }
    };



}