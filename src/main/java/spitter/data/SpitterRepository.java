package spitter.data;

import spitter.Spitter;

public interface SpitterRepository {

    Spitter save(Spitter spitter);

    Spitter findByUserName(String userName);
}
