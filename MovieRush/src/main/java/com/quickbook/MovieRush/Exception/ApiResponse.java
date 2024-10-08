package com.quickbook.MovieRush.Exception;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse {

    public String message;
    public boolean status;
}
