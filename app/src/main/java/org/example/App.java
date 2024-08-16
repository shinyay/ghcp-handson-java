package org.example;

import org.example.challenge1.*;
import org.example.challenge2.*;


public class App {


    public static void main(String[] args) {
        // シナリオ１：基本的なコード生成
        HelloCopilot helloCopilot = new HelloCopilot();
        helloCopilot.greeting();

        // シナリオ２：Copilot チャットを使ってコード生成
        YourIdea yourIdea = new YourIdea();
        yourIdea.run();
    }
}
