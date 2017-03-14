package DiseñoPorContrato;

/**
 * Created by DiegoMancini on 10/3/17.
 */
public class PhoneAlreadyUnlocked extends RuntimeException{

    public PhoneAlreadyUnlocked() {
        super("Phone is already unlocked");
    }
}
