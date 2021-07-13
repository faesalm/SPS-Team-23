/*
 * Copyright 2016 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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

public class SubmissionServlet extends HttpServlet {
  @Override
  public void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws IOException {

    // TODO: store in datastore

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


    // resp.setHeader("Content-Type", "text/html; charset=UTF-8");
    // PrintWriter out = resp.getWriter();
    // out.write("username: " + username);
    // out.write("email: " + email);
    // out.write("language: " + language);
    // out.write("message: " + message);
    // out.flush();
    // out.close();
  }
}