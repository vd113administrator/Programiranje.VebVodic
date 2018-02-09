/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programiranje.vodic.text;

/**
 *
 * @author Mikec
 */
public class PreslovljavanjeException extends RuntimeException{

    public PreslovljavanjeException() {
    }

    public PreslovljavanjeException(String message) {
        super(message);
    }

    public PreslovljavanjeException(String message, Throwable cause) {
        super(message, cause);
    }

    public PreslovljavanjeException(Throwable cause) {
        super(cause);
    }

    public PreslovljavanjeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
