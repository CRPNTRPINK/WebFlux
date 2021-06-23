//package com.example.WebFluxPerson;
//
//import com.fasterxml.jackson.core.JsonParser;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
//
//import java.io.IOException;
//import java.net.HttpURLConnection;
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.util.Scanner;
//
//public class Requests {
//
//
//    public static void main(String[] args) {
//        try{
//            URL url = new URL("https://api.covid19api.com/summary");
//
//            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//            conn.setRequestMethod("GET");
//            conn.connect();
//            String inline = "";
//            Scanner scanner = new Scanner(url.openStream());
//            while (scanner.hasNext()){
//                inline += scanner.nextLine();
//            }
//            scanner.close();
//            System.out.println(inline);
//            JSONParser parse = new JSONParser();
//            JSONObject data_obj = (JSONObject) parse.parse(inline);
//            JSONObject obj = (JSONObject) data_obj.get("Global");
//            System.out.println(obj);
//            System.out.println(obj.get("NewRecovered"));
//
//        }catch (Exception e){
//            System.out.println(e.getMessage());
//        }
//    }
//}
