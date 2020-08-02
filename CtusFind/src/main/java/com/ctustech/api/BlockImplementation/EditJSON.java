package com.ctustech.api.BlockImplementation;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.json.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class EditJSON {
   // private URI filename;

    public void ProductInfo() throws IOException, ParseException {
        JSONParser parseIt = new JSONParser();

        JSONArray a = (JSONArray) parseIt.parse(new FileReader("data\\result.json"));

        for (Object o : a)
        {
            JSONObject person = (JSONObject) o;

            String year = (String) person.get("Year");
            System.out.println(year);

            String anumber = (String) person.get("Alert number");
            System.out.println(anumber);

            String name = (String) person.get("Name");
            System.out.println(name);

            String rtype = (String) person.get("Risk type");
            System.out.println(rtype);
           // for (Object c : cars)
           // {
           //     System.out.println(c+"");
           // }
        }
       // catch (FileNotFoundException e) {
         //   e.printStackTrace();
        //} catch (IOException e) {
          //  e.printStackTrace();
        //} catch (ParseException e) {
          //  e.printStackTrace();
        //}
//        FileReader reader = new FileReader("data\\csvjson.json");
//        try {
//            Object obj = parseIt.parse(reader);
//            JSONArray productList = (JSONArray) obj;
//            //System.out.println(productList);
//            int x = productList.size();
//            System.out.println(x);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }

    }
    public void writeHash(String filename) throws IOException {
        try(FileReader fr = new FileReader(filename);
            FileWriter fw = new FileWriter("data\\result.json");
            JsonReader reader = Json.createReader(fr);
            JsonWriter jsonWriter = Json.createWriter(fw);) {
            JsonObject jsonObject = reader.readObject();

            JsonBuilderFactory jsonBuilderFactory = Json.createBuilderFactory(null);
            JsonObjectBuilder jsonObjectBuilder = jsonBuilderFactory.createObjectBuilder();

            for(String key : jsonObject.keySet()) {
                jsonObjectBuilder.add(key, jsonObject.get(key));
            }
            jsonObjectBuilder.add("Hash", "RANDOMLYGENERATEDHASHVALUE");

            jsonObject = jsonObjectBuilder.build();

            jsonWriter.writeObject(jsonObject);
        }
    }
}
