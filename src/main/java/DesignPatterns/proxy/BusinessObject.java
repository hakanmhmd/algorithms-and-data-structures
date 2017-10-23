package DesignPatterns.proxy;

import javax.security.auth.login.CredentialException;

/**
 * Created by hakanmehmed on 03/07/2017.
 */
public abstract class BusinessObject {
    abstract void sayHi(Integer passcode) throws CredentialException;
    public static BusinessObject create() {
        return new BusinessObjectProxy(new BusinessObjectImpl());
    }
}
