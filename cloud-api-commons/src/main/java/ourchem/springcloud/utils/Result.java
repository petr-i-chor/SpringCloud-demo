package ourchem.springcloud.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {
    private int status;
    private String msg;
    private T data;

    public Result(int status , String msg){
        this.status = status;
        this.msg = msg;
    }

}
