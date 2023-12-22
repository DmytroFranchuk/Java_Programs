package org.pr_2023_12_22_Synchronizers.task_4;

import org.pr_2023_12_22_Synchronizers.task_4.Runner.FirstRunner;
import org.pr_2023_12_22_Synchronizers.task_4.Runner.Runner;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CyclicBarrier;

public class Main {

    // Пусть есть 5 беговых дорожек. На каждой дорожке на расстоянии 300 м стоят бегуны одной команды,
    // всего в команде 10 бегунов. На старте стоят первые бегуны каждой из команд. После выстрела
    // стартового пистолета бегуны мчатся по своей дорожке до следующего участника, чтобы передать
    // ему эстафетную палочку. Участник, получивший эстафетную палочку бежит к следующему члену
    // команды и т.д. Скорость каждого бегуна задайте случайным образом. Забег завершается,
    // когда последний бегун последней команды прибыл на финиш. Используйте блокирующие очереди для
    // моделирования ситуации.
    public static void main(String[] args) {
        int teamsNum = 3;
        int runnersNum = 3;
        System.out.println("Команд " + teamsNum + " участников " + runnersNum);
        CyclicBarrier barrier = new CyclicBarrier(teamsNum);
        List<Thread> threads = new ArrayList<>();
        for (int i = 1; i <= teamsNum; i++) {
            Runner nextInRace = null;
            for (int j = runnersNum; j < 1; j--) {
                Runner runner = j == 1 ? new FirstRunner(j, i, nextInRace, barrier) : new Runner(j, i, nextInRace);
                nextInRace = runner;
                threads.add(new Thread(runner));
            }
        }
        threads.forEach(Thread::start);
    }
}
