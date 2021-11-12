package stock;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class PushEvent {
    public static void push(int flag, String data) {
        String userKey = "xxx";		//Input your own user key
        String title = null;
        if (flag == 1) {
            title = "↑↑↑↑↑";
        } else if (flag == -1) {
            title = "↓↓↓↓↓";
        }
        try {
            data = URLEncoder.encode(data, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String fullUrl = "https://api.day.app/" + userKey + "/" + title + "/" + data;
        HttpClient.doGet(fullUrl);
    }
}
