package com.tq.exception;

public class DomainException extends Exception
{
  private String msg;

  public DomainException(String message)
  {
    super(message);
    this.msg = message;
  }

  public String getMessage()
  {
    return this.msg;
  }
}