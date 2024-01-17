package org.lesson.expBean.pojo;

import org.lesson.expBean.interfaces.BusinessLogic;

public class BusinessLogicImpl implements BusinessLogic {

    @Override
    public void doBusinessLogic() {
        System.out.println("метод класса BusinessLogicImpl Do very important business logic");
    }
}
