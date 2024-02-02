package com.curso.springboot.Exceptions;

import java.io.Serializable;
import java.util.Date;

public class ExceptionResponse implements Serializable {
  private static final long serialVersionUID = 1L;

  private Date timestamp;
  private String message;
  private String detail;

  public ExceptionResponse(Date timestamp, String message, String detail) {
    this.timestamp = new Date();
    this.message = message;
    this.detail = detail;
  }

  public String getDetail() {
    return detail;
  }

  public Date getTimestamp() {
    return timestamp;
  }

  public String getMessage() {
    return message;
  }
}
