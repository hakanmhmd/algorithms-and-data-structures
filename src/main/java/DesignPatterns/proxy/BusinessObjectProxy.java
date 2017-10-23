package DesignPatterns.proxy;

import javax.security.auth.login.CredentialException;

/**
 * Created by hakanmehmed on 03/07/2017.
 */
public class BusinessObjectProxy extends BusinessObject {
    private BusinessObject target;

    public BusinessObjectProxy(BusinessObject target){
        this.target = target;
    }
    @Override
    public void sayHi(Integer passcode) throws CredentialException {
        if(passcode.equals(123)) {
            this.target.sayHi(passcode);
        } else {
            throw new CredentialException("Wrong credentials.");
        }
    }
}
