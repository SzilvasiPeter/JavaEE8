package control;

import javax.ejb.ApplicationException;

@ApplicationException(rollback = true)
public class CarStorageExecption extends Exception {
    public CarStorageExecption(String s) {
        super(s);
    }
}
