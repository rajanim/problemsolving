package gd;


import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Base64;


public class ReadGitFile {

    public static void main(String[] args) {

        try {
            //String webPage = "https://api.bitbucket.org/2.0/repositories/1team/moxie";
            String webPage = "https://api.bitbucket.org/1.0/repositories/glassdoorcom/search-chef-repo/src/develop/cookbooks/search-solr/files/default/solrconfig.xml";
            String name = "rajani_maski";
            String password = "Almighty@123";

            String authString = name + ":" + password;
            System.out.println("auth string: " + authString);
            Base64.Encoder encoder = Base64.getEncoder();
            byte[] authEncBytes = encoder.encode(authString.getBytes());
            String authStringEnc = new String(authEncBytes);
            System.out.println("Base64 encoded auth string: " + authStringEnc);

            URL url = new URL(webPage);
            URLConnection urlConnection = url.openConnection();
            urlConnection.setRequestProperty("Content-Type", "application/json");
            urlConnection.setRequestProperty("Authorization", "Basic " + authStringEnc);
            DataInputStream dis = new DataInputStream(urlConnection.getInputStream());
            //InputStream is = urlConnection.getInputStream();
            InputStreamReader isr = new InputStreamReader(dis);

            int numCharsRead;
            char[] charArray = new char[1024];
            StringBuffer sb = new StringBuffer();
            while ((numCharsRead = isr.read(charArray)) > 0) {
                sb.append(charArray, 0, numCharsRead);
            }
            String result = sb.toString();

            System.out.println("*** BEGIN ***");
            System.out.println(result);
            System.out.println("*** END ***");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
