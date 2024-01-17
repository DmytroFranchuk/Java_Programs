package org.lesson.expBean.pojo;

import org.lesson.expBean.interfaces.BusinessLogic;

public class ThirdBean {

    private FirstBean firstBean;
    private BusinessLogic businessLogic;

    public FirstBean getFirstBean() {
        return firstBean;
    }

    public BusinessLogic getBusinessLogic() {
        return businessLogic;
    }

    public void setFirstBean(FirstBean firstBean) { // внедрение в сеттер
        this.firstBean = firstBean;
        System.out.println("метод setFirstBean firstBean was set");
    }

    public void setBusinessLogic(BusinessLogic businessLogic) { // внедрение в сеттер
        this.businessLogic = businessLogic;
        System.out.println("метод setBusinessLogic businessLogic was set");
    }
}
