package miri.pro.basic_contacts_manager.data;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

import miri.pro.basic_contacts_manager.model.ContactModel;
import miri.pro.basic_contacts_manager.model.ContactsBook;

public class DataGatewayImp implements DataGateway{
    private final String JSON_FILE_NAME = "contactBooks.json";
    @Override
    public HashMap<String, ContactModel> loadData(Context context) {
        /**
         * TODO: read the entire file, get the content as string
         * convert it to ContactsBook object and return it
         *
         */
        Gson gson = new Gson();
        //ModelObject modelObject1 = gson.fromJson(json, ModelObject.class);
        HashMap<String, ContactModel> contactModelHashMap = null;
        String fileContent = readFromFile(context, JSON_FILE_NAME);
        contactModelHashMap = gson.fromJson(fileContent, HashMap.class);
        return contactModelHashMap;
    }

    private String readFromFile(Context context, String jsonFileName) {
            String ret = "";

            try {
                InputStream inputStream = context.openFileInput(jsonFileName);

                if ( inputStream != null ) {
                    InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    String receiveString = "";
                    StringBuilder stringBuilder = new StringBuilder();

                    while ( (receiveString = bufferedReader.readLine()) != null ) {
                        //stringBuilder.append("\n").append(receiveString);
                        stringBuilder.append(receiveString);
                    }

                    inputStream.close();
                    ret = stringBuilder.toString();
                }
            }
            catch (FileNotFoundException e) {
                Log.e("login activity", "File not found: " + e.toString());
            } catch (IOException e) {
                Log.e("login activity", "Can not read file: " + e.toString());
            }

            return ret;
    }

    @Override
    public void saveData(Context context, HashMap<String, ContactModel> contactsBook) {
        /**
         * TODO: convert the object to JsonString and save it to the file
         */
        Gson gson = new Gson();
        if(contactsBook != null){
            String stringObject = gson.toJson(contactsBook);
            // write it to file
            writeToFile(context, JSON_FILE_NAME, stringObject);

        }

    }

    private void writeToFile(Context context, String jsonFileName, String data) {
        try {
            OutputStreamWriter outputStreamWriter =
                    new OutputStreamWriter(context.openFileOutput(jsonFileName, Context.MODE_PRIVATE));
            outputStreamWriter.write(data);
            outputStreamWriter.close();
        }
        catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }


}
