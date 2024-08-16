package org.example.challenge2;

import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class YourIdea {
    
    public YourIdea() {
        System.out.println("シナリオ２：Copilot チャットを使ってコード生成");
    }

    public void run() {
        // 現在の日時を取得
        ZonedDateTime now = ZonedDateTime.now();

        // 日本のローカル時間
        ZonedDateTime japanTime = now.withZoneSameInstant(ZoneId.of("Asia/Tokyo"));
        DateTimeFormatter japanFormatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH時mm分ss秒");
        System.out.println("日本のローカル時間: " + japanTime.format(japanFormatter));

        // アメリカ西海岸時間
        ZonedDateTime usWestCoastTime = now.withZoneSameInstant(ZoneId.of("America/Los_Angeles"));
        DateTimeFormatter usFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a");
        System.out.println("アメリカ西海岸時間: " + usWestCoastTime.format(usFormatter));

        // イギリス時間
        ZonedDateTime ukTime = now.withZoneSameInstant(ZoneId.of("Europe/London"));
        DateTimeFormatter ukFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        System.out.println("イギリス時間: " + ukTime.format(ukFormatter));
    }
}