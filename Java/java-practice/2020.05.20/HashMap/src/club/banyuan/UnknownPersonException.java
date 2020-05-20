package club.banyuan;

public class UnknownPersonException extends RuntimeException{
    private final String message;

    UnknownPersonException(String message){
           this.message = message;
    }
    @Override
    public String toString() {
        return message;
    }
}
