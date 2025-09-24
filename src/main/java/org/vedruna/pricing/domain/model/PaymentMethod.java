package org.vedruna.pricing.domain.model;

public class PaymentMethod {
    
    private final Integer id;
    private final String methodName;

    public PaymentMethod(Integer id, String methodName) {
        this.id = id;
        this.methodName = methodName;
    }

    // Getters
    public Integer getId(){ return id; }
    public String getMethodName(){ return methodName; }

}
