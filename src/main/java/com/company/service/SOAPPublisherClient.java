package com.company.service;

import com.company.bean.Theatre;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

public class SOAPPublisherClient {

    public static void main(String[] args) throws IOException {

        URL wsdlURL = new URL("http://localhost:8080/ws/theatres?wsdl");
        QName qname = new QName("http://service.company.com/", "TheatreServiceImplService");
        Service service = Service.create(wsdlURL, qname);
        TheatreService ps = service.getPort(TheatreService.class);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean flag = true;
        while (flag) {
            System.out.print("1 - find by name \n 2 - find by date \n 3 - get all item \n 4 - exit\n");
            int choice = Integer.parseInt(reader.readLine());
            if (choice == 1) {
                System.out.println("Write name of theatre");
                String theatre = reader.readLine();
                ArrayList<Theatre> temp = (ArrayList<Theatre>) ps.findByName(theatre);
                if (temp.isEmpty()) {
                    System.out.println("Cant find");
                } else {
                    System.out.println(temp);
                }
            } else if (choice == 2) {
                SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
                System.out.println("Write date of theatre");
                String date = reader.readLine();
                ArrayList<Theatre> temp;
                try {
                    temp = (ArrayList<Theatre>) ps.findByDate(formatter.parse(date));
                } catch (ParseException e) {
                    e.printStackTrace();
                    continue;
                }
                if (temp.isEmpty()) {
                    System.out.println("Cant find");
                } else {
                    System.out.println(temp);
                }
            } else if (choice == 3) {
                System.out.println(ps.getAllTheatre());
            } else if (choice == 4) {
                flag = false;
            }
        }
    }

}