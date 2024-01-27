package org.task2.pojo;

import org.springframework.beans.factory.annotation.Autowired;

public class DataCollectionService {
    @Autowired
    private Connector connector;

    public DataCollectionService() {
        System.out.println("DataCollectionService начал сбор данных с датчиков ... ");
        Delay.delayProgressBar(100);
        System.out.println("Данные обработаны и готовы к отправке");
    }

    public void sendInfoData() {
        if (this.connector != null) {
            this.connector.connect();
            System.out.println("Отправка данных ... ");
            Delay.delayProgressBar(10);
            System.out.println("Отправка выполнена успешно, коннектор связи закрыт");
        }
    }
}
