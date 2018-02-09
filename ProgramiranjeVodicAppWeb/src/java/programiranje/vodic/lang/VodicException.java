/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programiranje.vodic.lang;

/**
 *
 * @author Mikec
 */
public class VodicException extends RuntimeException{

    public VodicException() {
    }

    public VodicException(String message) {
        super(message);
    }

    public VodicException(String message, Throwable cause) {
        super(message, cause);
    }

    public VodicException(Throwable cause) {
        super(cause);
    }

    public VodicException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
