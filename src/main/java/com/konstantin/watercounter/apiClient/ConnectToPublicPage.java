package com.konstantin.watercounter.apiClient;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import lombok.Data;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;

@Data
@Component
public class ConnectToPublicPage {
  private Connection.Response loginForm;
  private Document loginInDocument;

  public Connection.Response connect() throws IOException {
    loginForm = Jsoup.connect("https://billing.vodokanal.kharkov.ua/login")
        .method(Connection.Method.GET)
        .execute();
    return loginForm;
  }

  public  Document login() throws IOException {

    Connection.Response response = Jsoup.connect("https://billing.vodokanal.kharkov.ua/login")
        .referrer("https://billing.vodokanal.kharkov.ua/login")
        .userAgent("Mozilla/5.0")
        .timeout(10 * 1000)
        .method(Connection.Method.POST)
        .data("_csrf-frontend", "hCYXsRwzow9mnxMFjjnG6t0yi2AXaAVfeliCenTXQa3rQEPyLmLgfQvNIHXbD46vi3zZASc_dh4RLNAdGrJw9Q==")
        .data("LoginForm[username]", "Kastey")
        .data("LoginForm[password]", "fa2ALXnwc")
        .data("LoginForm[rememberMe]", "1")
        //ptHdDfb2j4
        //ptHdDfb2j4


/*        .data("cookieexists", "false")
        .data("username", "32007702")
        .data("login", "Login")*/
        .cookies(loginForm.cookies())
        .headers(loginForm.headers())
        .followRedirects(true)
        .execute();
       // .post();

    return response.parse();
  }

  public void login2() throws IOException {

    // URL of the website you want to send the POST request to
    String url = "https://billing.vodokanal.kharkov.ua/login";

    // Set the POST data parameters
    String username = "Kastey";
    String password = "fa2ALXnwc";


    Map<String , String> requestHeaders = new HashMap<>();
    requestHeaders.putAll(loginForm.headers());
    requestHeaders.put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7");
    requestHeaders.put("Accept-Encoding","gzip, deflate, br");
    requestHeaders.put("Accept-Language","en-US,en;q=0.9,ru;q=0.8");
    requestHeaders.put("Cache-Control","max-age=0");
    requestHeaders.put("Connection","keep-alive");
    requestHeaders.put("Content-Length","243");
   // requestHeaders.put("Content-Type:","application//x-www-form-urlencoded");
   // requestHeaders.put("Content-Type:","application/x-www-form-urlencoded");
    requestHeaders.put("Cookie","_ga=GA1.3.2080903486.1685372102; _csrf-frontend=32a9c03744b608e192a6372082554bf3937ada18a0efe57ffc7f398e15df330ba%3A2%3A%7Bi%3A0%3Bs%3A14%3A%22_csrf-frontend%22%3Bi%3A1%3Bs%3A32%3A%228mzp3C-9970NgU2SQVwpUHJbKcMK3SKK%22%3B%7D; lang=bcae8332082d271323d6a53b82ac96cc3810922f259e426b9acf90cfc3d8e8d6a%3A2%3A%7Bi%3A0%3Bs%3A4%3A%22lang%22%3Bi%3A1%3Bs%3A5%3A%22ru-RU%22%3B%7D; _gid=GA1.3.423174202.1685707917; advanced-frontend=12k7ngsmh2al5q04l5pl62gm7u");
    requestHeaders.put("Dnt","1");
    requestHeaders.put("Host","billing.vodokanal.kharkov.ua");
    requestHeaders.put("Origin","https://billing.vodokanal.kharkov.ua");
    requestHeaders.put("Referer","https://billing.vodokanal.kharkov.ua/login");
/*    requestHeaders.put("Sec-Ch-Ua","\"Google Chrome\";v=\"113\", \"Chromium\";v=\"113\", \"Not-A.Brand\";v=\"24\"");
    requestHeaders.put("Sec-Ch-Ua-Mobile","30");
    requestHeaders.put("Sec-Ch-Ua-Platform","Windows");
    requestHeaders.put("Sec-Fetch-Dest","document");
    requestHeaders.put("Sec-Fetch-Mode","navigate");
    requestHeaders.put("Sec-Fetch-Site","same-origin");
    requestHeaders.put("Sec-Fetch-User","?1");*/
    requestHeaders.put("Upgrade-Insecure-Requests","1");
    requestHeaders.put("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36");
    //requestHeaders.put("","");

    // Send the POST request
/*    Document document = Jsoup.connect(url)
        .method(Connection.Method.POST)
        .data("LoginForm[username]", username)
        .data("LoginForm[password]", password)
        .headers(requestHeaders)
        .cookies(loginForm.cookies())
        .referrer(url) // Set the referrer header if needed
        .post();

    // Process the response as needed
    System.out.println(document.title());*/



    //=====================
    try{

      Connection.Response response =
          Jsoup.connect("https://billing.vodokanal.kharkov.ua/login")
              .userAgent("Mozilla/5.0")
              .timeout(10 * 1000)
              .method(Connection.Method.POST)
              .data("_csrf-frontend", "hCYXsRwzow9mnxMFjjnG6t0yi2AXaAVfeliCenTXQa3rQEPyLmLgfQvNIHXbD46vi3zZASc_dh4RLNAdGrJw9Q==")
              .data("LoginForm[username]", username)
              .data("LoginForm[password]", password)
              .headers(requestHeaders)
              .cookies(loginForm.cookies())
              .followRedirects(true)
              .execute();

      //parse the document from response
      Document doc = response.parse();

      //get cookies
      Map<String, String> mapCookies = response.cookies();

      /*
       * You may need to send all the cookies you received
       * from the post response to the subsequent requests.
       *
       * You can do that using cookies method of Connection
       */



    }catch(IOException ioe){
      System.out.println("Exception: " + ioe);
    }



  }


/*
  public class JsoupExample {
    public static void main(String[] args) {
      try {
        // URL of the website you want to connect to
        String url = "https://example.com";

        // Set the "Referrer" header manually
        String referrer = "https://example.com";

        // Connect to the website and set the referrer header
        Document document = Jsoup.connect(url)
            .referrer(referrer)
            .get();

        // Process the HTML document as needed
        System.out.println(document.title());
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }
  In the code above, we use the Jsoup.connect(url) method to establish a connection to the desired website. Then, we set the referrer header using the .referrer(referrer) method, where referrer is the URL of the website that you want to act as the referrer. Finally, we use the .get() method to retrieve the HTML document, and you can process it according to your requirements.

  By setting the referrer header explicitly, you are informing the server about the origin of the request, which helps satisfy the "strict-origin-when-cross-origin" policy.


*/







}
