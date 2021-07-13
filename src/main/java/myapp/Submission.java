package com.google.sps.servlets;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.FullEntity;
import com.google.cloud.datastore.KeyFactory;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

@Override
public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    String Username = Jsoup.clean(request.getParameter("full-name"), Whitelist.none());
    String email= Jsoup.clean(request.getParameter("email-address"), Whitelist.none());
    String message = Jsoup.clean(request.getParameter("message"), Whitelist.none());
    String language = Jsoup.clean(request.getParameter("language"), Whitelist.none()); 

    Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
    KeyFactory keyFactory = datastore.newKeyFactory().setKind("full-name");
        FullEntity taskEntity =
        Entity.newBuilder(keyFactory.newKey())
        .set("full-name", username)
        .set("email-address", email)
        .set("language", language)
        .set("message", message)
        .build();
    datastore.put(userEntity);  
    response.sendRedirect("/index.html");  
} 

//Work in Prog
