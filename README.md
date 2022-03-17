# basicContactsManager

This is a native android present the basic functionalities of a contact management application, it is a practical activity, to learn how to
deal with local storage in native android.

## Specifications

1. the application based on two fragments, one represente the list of contacts, and the other represent the form to add a new contact.
2. the records inserted and loadded from a local json file.
3. I used Gson to convert the objects to json to String and vice versa.

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

# hhf
