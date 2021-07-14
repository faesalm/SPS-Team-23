package myapp;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.FullEntity;
import com.google.cloud.datastore.KeyFactory;
import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

public class SubmissionServlet extends HttpServlet {
  @Override
  public void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws IOException {
    //String username = Jsoup.clean(request.getParameter("full-name"), Whitelist.none());
    //String email= Jsoup.clean(request.getParameter("email-address"), Whitelist.none());
    //String message = Jsoup.clean(request.getParameter("message"), Whitelist.none());
    //String language = Jsoup.clean(request.getParameter("language"), Whitelist.none()); 

    //System.out.println(username);

    Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
    KeyFactory keyFactory = datastore.newKeyFactory().setKind("full-name");
        FullEntity taskEntity =
        Entity.newBuilder(keyFactory.newKey())
        .set("full-name", "Koy")
        .set("email-address", "testing")
        .set("language", "english")
        .set("message", "test")
        .build();
    datastore.put(taskEntity);  
    resp.sendRedirect("/index.html");  
      }
}
