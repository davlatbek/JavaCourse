package networks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by davlet on 6/15/17.
 */
public class UrlExample {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://bash.im");
            BufferedReader bufferedReader =
                    new BufferedReader(new InputStreamReader(url.openStream()));
            String s = "";
            while((s = bufferedReader.readLine()) != null){
                System.out.println(s);
            }
            bufferedReader.close();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
