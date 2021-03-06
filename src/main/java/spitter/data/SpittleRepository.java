package spitter.data;

import spitter.Spittle;

import java.util.List;

public interface SpittleRepository {

    List<Spittle> findSpittles(long max, int count);

    Spittle findOne(long id);

    List<Spittle> findRecentSpittles();

    void save(Spittle spittle);
}
