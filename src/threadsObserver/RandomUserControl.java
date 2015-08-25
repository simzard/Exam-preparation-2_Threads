package threadsObserver;

import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;
import randomperson.RandomUser;
import randomperson.RandomUserGenerator;

// extends Observable means THIS is the SUBJECT
public class RandomUserControl extends Observable {

    RandomUser user = null;

    public synchronized void fetchRandomUser() {

        try {
            user = RandomUserGenerator.getRandomUser();
        } catch (InterruptedException ex) {
            Logger.getLogger(RandomUserControl.class.getName()).log(Level.SEVERE, null, ex);
        }

        setChanged(); // something has happened!
        notifyObservers(user); // send a message to all the Observers with the user argument
    }
}
