package gd;

/**
 * Created by rajani.maski on 6/15/17.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.Proxy;
import java.net.InetSocketAddress;
import java.io.OutputStreamWriter;

public class BitBucketAPIs {

    public static void main(String[] args) {

        try {

            //String url = "http://127.0.0.1:15672/api/traces/%2f/trololo";

           // String url = "https://api.bitbucket.org/1.0/user/repositories";//"https://api.bitbucket.org/1.0/repositories/glassdoorcom/search-chef-repo/src/SOLR4/config/datacenters.yaml";
            String url = "https://api.bitbucket.org/2.0/repositories/1team/moxie";
            URL obj = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
          conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            conn.setRequestMethod("GET");

           String userpass = "rajani_maski" + ":" + "Almighty@123";
            String basicAuth = "Basic " + javax.xml.bind.DatatypeConverter.printBase64Binary(userpass.getBytes("UTF-8"));
            conn.setRequestProperty("Authorization", basicAuth);

            String data = "{\"format\":\"json\",\"pattern\":\"#\"}";
            OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream());
            out.write(data);
            out.close();

            new InputStreamReader(conn.getInputStream());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
