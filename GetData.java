package stock;

import java.util.LinkedHashMap;
import java.util.Map;

public class GetData {
    public static Map<String, String> parseData(String url) {
        String[] raw = HttpClient.doGet(url).split("=");
        String str = raw[1].replaceAll("\"", "");
        str = str.replaceAll(";", "");
        String[] strArray = str.split(",");
        String[] keyArray = {"指数名称", "当前点数", "当前价格", "涨跌率", "成交量（手）", "成交额（万元）"};
        Map<String, String> dataMap = new LinkedHashMap<>();
        for (int i = 0; i < keyArray.length; i++) {
            dataMap.put(keyArray[i], strArray[i]);
        }
        return dataMap;
    }
}
