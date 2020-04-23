import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class Encoder {

    public static void main (String args[]) throws UnsupportedEncodingException
    {
        if(args ==  null || args.length==0 || args[0].trim().length() == 0)
        {
            System.out.println("Please enter a URL for encoding");
        }
        else
        {
            System.out.println("Input URL "+args[0]);        
            System.out.println("Encoded URL string is "+URLEncoder.encode(args[0], "UTF-8"));
        }
        
    }

}