package sever.com.serverFacturation.dtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorDto {
    private Integer httpcode;

    //private ErrorCodes codes;

    private String message;

    //private List<String> error=new ArrayList<>();
}
