package org.lesson.expBean.pojo;

import org.lesson.expBean.interfaces.BusinessLogic;

public class SecondBean {
    private String name;

    private final BusinessLogic businessLogic;

    public SecondBean(String name, BusinessLogic businessLogic) { // внедрение в конструктор
        this.name = name;
        this.businessLogic = businessLogic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BusinessLogic getBusinessLogic() {
        return businessLogic;
    }
}
