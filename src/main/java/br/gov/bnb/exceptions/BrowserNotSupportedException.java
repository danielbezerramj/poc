package br.gov.bnb.exceptions;

public class BrowserNotSupportedException extends IllegalStateException  {
    public BrowserNotSupportedException(String browser) {
        super(String.format("Browser not supported: %s", browser));
    }
}
