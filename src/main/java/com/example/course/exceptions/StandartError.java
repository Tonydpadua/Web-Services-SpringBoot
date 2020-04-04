package com.example.course.exceptions;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StandartError implements Serializable {
    private static final long serialVersionUID=1L;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'",timezone ="GMT")
    private Instant timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;



}
