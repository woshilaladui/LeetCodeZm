package com.whut.study.thread.thread_pool;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/6/17 19:42
 * @desription
 */
public class RunResult {
    // 输入参数
    private Integer param;
    // 是否运算成功
    private Boolean success;
    // 运算结果
    private Integer result;
    public Integer getParam() {
        return param;
    }
    public void setParam(Integer param) {
        this.param = param;
    }
    public Boolean getSuccess() {
        return success;
    }
    public void setSuccess(Boolean success) {
        this.success = success;
    }
    public Integer getResult() {
        return result;
    }
    public void setResult(Integer result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "RunResult{" +
                "param=" + param +
                ", success=" + success +
                ", result=" + result +
                '}';
    }
}
