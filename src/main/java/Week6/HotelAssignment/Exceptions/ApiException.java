package Week6.HotelAssignment.Exceptions;

import lombok.Getter;

@Getter
public class ApiException extends Throwable {
    int statusCode;
    public ApiException(int statusCode,String msg){
        super(msg);
        this.statusCode = statusCode;
    }
}