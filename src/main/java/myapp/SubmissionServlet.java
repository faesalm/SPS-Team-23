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

package myapp;

import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SubmissionServlet extends HttpServlet {
  @Override
  public void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws IOException {
        System.out.println(req.getParameterNames().toString());

    String username = req.getParameter("full-name");
    String email = req.getParameter("email-address");
    String language = req.getParameter("language");
    String message = req.getParameter("message");
    System.out.println(username + "--" + email + "--" + language + "--" + message);

    
    // TODO: store in datastore

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