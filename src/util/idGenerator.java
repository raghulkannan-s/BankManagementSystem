package util;

public class idGenerator {
    
    private static int counter = 1000;

    public static int generateId(){
        return ++counter;
    }

}
