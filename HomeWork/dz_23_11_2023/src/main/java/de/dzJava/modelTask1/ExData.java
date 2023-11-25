package de.dzJava.modelTask1;

import java.util.List;

public class ExData {
    private String serviceName;
    private int code;
    private String userMessage;
    private boolean isError;
    private List<SupportContact> supportContacts;

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setUserMessage(String userMessage) {
        this.userMessage = userMessage;
    }

    public void setIsError(boolean error) {
        isError = error;
    }

    public void setSupportContacts(List<SupportContact> supportContacts) {
        this.supportContacts = supportContacts;
    }

    @Override
    public String toString() {
        return "ExData{" +
                "serviceName='" + serviceName + '\'' +
                ", code=" + code +
                ", userMessage='" + userMessage + '\'' +
                ", isError=" + isError +
                ", supportContacts=" + supportContacts +
                '}';
    }
}
