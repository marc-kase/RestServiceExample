package tst.example.rest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class TestSimpleClient {
    // http://localhost:8080/RESTfulExample/json/product/get
    public static void main(String[] args) throws IOException {

        try {

            URL url = new URL("http://localhost:8080/myapp/myresource");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("username", "user");
            conn.setRequestProperty("password", "12345");
//            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String output;
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }

            conn.disconnect();

        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }

    }
}



//        IdHTTP.Request.BasicAuthentication := True;
//        IdHTTP.Request.Username := 'user';
//        IdHTTP.Request.Password := 'pass';
//        IdHTTP.Get('http://localhost/test');