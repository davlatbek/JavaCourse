package networks;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by davlet on 6/15/17.
 */
public class SearchClient {
    private static final String USER_AGENT = "Mozilla/5.0";

    public static void main(String[] args) {
        try {
            URL url = new URL("https://yandex.ru");
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            String s = "";
            while((s = in.readLine()) != null){
                System.out.println(s);
            }
            in.close();

            Scanner scanner = new Scanner(System.in);
            String query;
            URL queryUrl;
            DataInputStream dataInputStream;
            while (true){
                System.out.println("Enter query string: ");
                query = scanner.next();
                if (query.equals("exit")) return;
                queryUrl = new URL("https://yandex.ru/search/?text=" + query + "\"");
                HttpsURLConnection httpsURLConnection = (HttpsURLConnection) queryUrl.openConnection();
                httpsURLConnection.setRequestMethod("POST");
                httpsURLConnection.setRequestProperty("User-Agent", USER_AGENT);
                httpsURLConnection.setDoOutput(true);
                dataInputStream = new DataInputStream(httpsURLConnection.getInputStream());
                System.out.println(dataInputStream.readUTF());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
