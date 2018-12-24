package btl.Generation;

import btl.Entity.Entity;
import com.sun.istack.internal.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GenerateRandom {
    private Entity random(int i) {
        switch (i) {
            case 1:
                return new GeneratePerson().generator();
            case 2:
                return new GenerateCountry().generator();
            case 3:
                return new GenerateOrganization().generator();
            case 4:
                return new GenerateEvent().generator();
            case 0:
                return new GenerateLocation().generator();
            default:
                return null;
        }
    }

    public List<Entity> listRandomEntity(int x) {
        ArrayList<Entity> rs = new ArrayList<>();
        for (int i = 0; i < x; i++) {
            rs.add(random(new Random().nextInt(4)));
        }
        return rs;
    }
}
