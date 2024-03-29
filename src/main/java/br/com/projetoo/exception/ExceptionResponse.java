package br.com.projetoo.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionResponse implements Serializable {
    private static final long serialversionUID = 1L;

    private Date timestamp;
    private String message;
    private String details;

}