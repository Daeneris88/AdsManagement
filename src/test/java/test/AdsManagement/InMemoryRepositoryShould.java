package test.AdsManagement;

import adsmanagement.InMemoryRepository;
import adsmanagement.domain.ads.Ad;
import adsmanagement.domain.ads.Body;
import adsmanagement.domain.ads.Title;
import adsmanagement.services.Id;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class InMemoryRepositoryShould {

    @Test
    void return_an_Ad_when_we_ask_for_it(){

        Title title = new Title("title");
        Body body = new Body("body");
        Id id = new Id("1");
        Ad expectedAd = new Ad(title, body, new Date(), id);
        InMemoryRepository inMemoryRepository = new InMemoryRepository();
        inMemoryRepository.save(id, expectedAd);

        Assertions.assertEquals(expectedAd, inMemoryRepository.get(new Id("1")));
    }

    @Test
    void return_null_because_we_removed_all_adds(){

        Title title = new Title("title");
        Body body = new Body("body");
        Id id = new Id("1");
        Ad expectedAd = new Ad(title, body, new Date(), id);
        InMemoryRepository inMemoryRepository = new InMemoryRepository();
        inMemoryRepository.save(id, expectedAd);

        inMemoryRepository.remove(new Id("1"));

        Assertions.assertNull(inMemoryRepository.get(id));
    }

    @Test
    void return_all_adds(){

        Title title = new Title("title");
        Body body = new Body("body");
        Id id = new Id("1");
        Title titlle1 = new Title("Hola");
        Body body1 = new Body("Body1");
        Id id1 = new Id("2");

        Ad expectedAd = new Ad(title, body, new Date(), id);
        Ad ad = new Ad(titlle1, body1, new Date(), id1);
        InMemoryRepository inMemoryRepository = new InMemoryRepository();
        inMemoryRepository.save(id, expectedAd);
        inMemoryRepository.save(id1, ad);

        Assertions.assertEquals(2, inMemoryRepository.getAll().size());
    }

}
