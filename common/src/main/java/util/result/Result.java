package util.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

/**
 * @Description 后端返回的数据封装类
 * @Author vazquez
 * @DATE 2024/7/25 8:54
 */

@Data
@ApiModel(value = "接口统一返回格式")
public class Result implements Serializable {

    @ApiModelProperty(value = "响应状态码")
    private ResultCode resultCode;

    @ApiModelProperty(value = "返回值")
    private Object data;

    public Result() {}

    public Result(ResultCode resultCode, Object data) {
        this.resultCode = resultCode;
        this.data = data;
    }

    public ResultCode getResultCode() {
        return resultCode;
    }

    public void setResultCode(ResultCode resultCode) {
        this.resultCode = resultCode;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static Result SUCCESS() {
        Result result = new Result();
        result.setResultCode(ResultCode.SUCCESS);
        return  result;
    }

    public static Result SUCCESS(Object data) {
        Result result = new Result();
        result.setResultCode(ResultCode.SUCCESS);
        result.setData(data);
        return result;
    }

    public static Result FAILURE(ResultCode resultCode) {
        Result result = new Result();
        result.setResultCode(resultCode);
        return result;
    }

    public static Result FAILURE(ResultCode resultCode, Object data) {
        Result result = new Result();
        result.setResultCode(resultCode);
        result.setData(data);
        return result;
    }
}
