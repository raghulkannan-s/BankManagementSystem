package dto;

public class Result {

    boolean valid;
    String message;


    public Result(boolean valid, String message) {
        this.valid = valid;
        this.message = message;
    }


    public boolean isValid() {
        return valid;
    }

    public String getMessage() {
        return message;
    }


}
