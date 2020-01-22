package tw.com.bryant.global.web.util;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class CIOutput<T> {

    private int statusCode = 200;

    private T data;

    public CIOutput(T data) {
        this.data = data;
    }

    public CIOutput(int statusCode,T data) {
        this.statusCode = statusCode;
        this.data = data;
    }

}
