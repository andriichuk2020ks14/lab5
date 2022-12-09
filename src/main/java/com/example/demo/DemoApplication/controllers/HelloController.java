package com.example.demo.DemoApplication.controllers;

import com.example.demo.DemoApplication.dto.DataDTO;
import com.example.demo.DemoApplication.models.Data;
import com.example.demo.DemoApplication.models.JSONConverter;
import com.example.demo.DemoApplication.services.AdminService;
import com.example.demo.DemoApplication.services.PeopleService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {

    private final AdminService adminService;
    private final PeopleService peopleService;

    public HelloController(AdminService adminService, PeopleService peopleService) {
        this.adminService = adminService;
        this.peopleService = peopleService;
    }


    @GetMapping("/admin")
    public String sayAdmin() {
        adminService.doStuff();
        return "admin";
    }

    @GetMapping("/currency")
    public String currency(Model model) throws IOException {
        String Get_url = "https://api.privatbank.ua/p24api/exchange_rates?json&date=08.11.2022";
        URL url = new URL(Get_url);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod("GET");
        int responseCode = httpURLConnection.getResponseCode();

        if (responseCode == HttpURLConnection.HTTP_OK){
            BufferedReader in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            String string;
            StringBuilder s = new StringBuilder();

            while((string = in.readLine())!=null){
                s.append(string);
            }in.close();

            ObjectMapper om = new ObjectMapper();
            JSONConverter root = om.readValue(s.toString(), JSONConverter.class);
            List<DataDTO> usr = new ArrayList<>();

            for (Data r: root.getExchangeRate()){
                if (r.getCurrency()!= null) {
                    usr.add(new DataDTO(root.getDate(), r.getBaseCurrency(),
                            r.getCurrency(), round(r.getSaleRateNB())));
                }
            }

            for (DataDTO u: usr){
                System.out.println(u.toString());
            }
            model.addAttribute("list", usr);
        }
        return "currency";
    }

    private static double round(double value) {
        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(3, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

}
