package rs.ac.bg.fon.silab.ru;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 *
 * @author user
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {
    private String status;
    private Object data;
    private String error;

    public Response(String status, Object data, String error) {
        this.status = status;
        this.data = data;
        this.error = error;
    }
    
    public Response(String status, Object data) {
        this.status = status;
        this.data = data;
    }
    
    public Response(Object data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
    
    
}
