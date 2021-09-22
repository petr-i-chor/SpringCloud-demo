package ourchem.springcloud.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {
    private T data;
    private String msg;
    private int status;

    public Result(int status ,String msg){
        this.status = status;
        this.msg = msg;
    }

}
