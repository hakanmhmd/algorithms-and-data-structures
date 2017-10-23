package DesignPatterns.proxy;

import javax.security.auth.login.CredentialException;

/**
 * Created by hakanmehmed on 03/07/2017.
 */
public class Main {
    public static void main(String[] args) throws CredentialException {

        BusinessObject obj = BusinessObject.create();
        obj.sayHi(123);
    }
}
