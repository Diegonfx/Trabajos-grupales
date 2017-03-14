package DiseñoPorContrato;

/**
 * Created by DiegoMancini on 10/3/17.
 */
public class PhoneAlreadyLocked extends RuntimeException {

    public PhoneAlreadyLocked() {
        super("Phone is already locked");
    }
}
