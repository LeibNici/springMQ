package com.cm.task;

import com.cm.sender.IMqttSender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

@Slf4j
@Component
public class senderTask {

    @Autowired
    private IMqttSender sender;

    @Scheduled(fixedRate = 1000)
    public void test() {
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").format(System.currentTimeMillis());
        log.warn(format);
        String time = String.valueOf(System.currentTimeMillis()).substring(0, 10);
        sender.sendToMqtt("{\"rlist\":{\"18067\":{\"range_bs_addr\":18067,\"time_calibrate\":0,\"between_antenna\":0,\"rssi\":-89,\"range_dist\":22116,\"channel\":1}},\"refresh_rate\":2.0,\"bs_addr\":18067,\"timestamp\":" + time + ",\"all_bs_num\":1,\"default_h\":1.5,\"tag_id\":110515,\"version\":3,\"back_sn\":6018,\"bs_num\":1,\"tof_sn\":36429,\"static\":0,\"tag_up_by_uwb\":0}");
    }

}
