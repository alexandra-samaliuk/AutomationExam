package by.stormnet.automation.core.utils;


public enum PauseLenght {
    MAX(120),
    MIN(5),
    AJAX(10),
    AVG(30);
    private Integer value;
    PauseLenght(Integer value){
        this.value = value;
    }
    public Integer value(){
        return this.value;
    }
}
