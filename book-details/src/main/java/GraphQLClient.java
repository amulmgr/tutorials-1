import java.net.URLEncoder;
import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.file.*;; 
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;



public class GraphQLClient {

    public static void main (String args[]) throws Exception
    {
        String baseURL = "http://localhost:8080/graphql?query=";
        
        //get GraphQL query from file
        String query = new String(Files.readAllBytes(Paths.get("samplequery"))); 
        
        //encode the query
        String  encodedString = URLEncoder.encode(query, "UTF-8");

        //send the query in a GET request
        HttpURLConnection httpClient = (HttpURLConnection) new URL(baseURL+encodedString).openConnection();
        System.out.println("\nSending 'GET' request to URL : " + baseURL+encodedString);            
        int responseCode = httpClient.getResponseCode();
        System.out.println("Response Code : " + responseCode);

        //get the response
        try (BufferedReader in = new BufferedReader(
            new InputStreamReader(httpClient.getInputStream()))) {

            StringBuilder response = new StringBuilder();
            String line;

            while ((line = in.readLine()) != null) {
                response.append(line);
            }

            //print response
            System.out.println(response.toString());
        
        }
        
        
    }

}
