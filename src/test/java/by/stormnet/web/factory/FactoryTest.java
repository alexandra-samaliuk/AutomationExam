package by.stormnet.web.factory;

import org.testng.annotations.Factory;

public class FactoryTest {

    @Factory()
    public Object[] factoryMethod() {
        return new Object[]{
                new TestForFactory("abc@"),
                new TestForFactory("abc#"),
                new TestForFactory("abc$"),
                new TestForFactory("abc!")};
    }
}
