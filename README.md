# basicContactsManager

This is a native android present the basic functionalities of a contact management application, it is a practical activity, to learn how to
deal with local storage in native android.

## Specifications

1. the application based on two fragments, one represente the list of contacts, and the other represent the form to add a new contact.
2. the records inserted and loadded from a local json file.
3. I used <mark>[Gson](https://github.com/google/gson)</mark> convert the objects to json to String and vice versa.

### load data

```java DataGatewayImp.java
@Override
    public HashMap<String, ContactModel> loadData(Context context) {
        /**
         * TODO: read the entire file, get the content as string
         * convert it to ContactsBook object and return it
         *
         */
        Gson gson = new Gson();
        String fileContent = readFromFile(context, JSON_FILE_NAME);
        Type listType = new TypeToken<HashMap<String, ContactModel>>(){}.getType();
        HashMap<String, ContactModel> contactModelHashMap = gson.fromJson(fileContent, listType);
        return contactModelHashMap;
    }

```

### readFromFile

```java DataGatewayImp.java
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
```

## UI

1. FragmentContainerView
2. AppBarLayout, Toolbar
3. FrameLayout
4. bottomnavigation.BottomNavigationView

## TODO

- [ ] Adding filters (By name, by category, by gender).
- [ ] Adding the ability to edit a contact.
- [ ] Adding the ability to delete a contact.
- [ ] Adding the ability to erase the list.
- [ ] Adding an image to the contact.

## Screenshots

| <img src="/screenshots/contacts_list.png" width="200px" height="auto">    | <img src="/screenshots/add_new_contact.png" width="200px" height="auto">   | <img src="/screenshots/validation.png" width="200px" height="auto">    |
| ------------------------------------------------------------------------- | -------------------------------------------------------------------------- | ---------------------------------------------------------------------- |
| <img src="/screenshots/validation_phone.png" width="200px" height="auto"> | <img src="/screenshots/contact_added_msg.png" width="200px" height="auto"> | <img src="/screenshots/contact_added.png" width="200px" height="auto"> |
|                                                                           |                                                                            |                                                                        |

## Watch the [DEMO](https://www.youtube.com/watch?v=fyiWv8DaG_o) on youtube.
