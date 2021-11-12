package stock;

import java.util.Map;

public class stock {
    public void run() {
        try {
            synchronized (this) {
                //noinspection InfiniteLoopStatement
                while (true) {
                    String url = "https://hq.sinajs.cn/list=s_sh000001";
                    Map<String, String> dataMap = GetData.parseData(url);
                    double rate = Double.parseDouble(dataMap.get("涨跌率"));
                    if (rate > 0.5) {
                        PushEvent.push(1, AssembleData.assemble(dataMap));
                    } else if (rate < -0.5) {
                        PushEvent.push(-1, AssembleData.assemble(dataMap));
                    } else {
                        System.out.println(rate + "未超过阈值");
                    }
                    this.wait(5 * 60 * 1000);
                    //Thread.sleep(5 * 60 * 1000);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
