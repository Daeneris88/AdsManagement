package test.AdsManagement;

import adsmanagement.InMemoryRepository;
import adsmanagement.domain.ads.Ad;
import adsmanagement.domain.adsManagement.AdsManagement;
import adsmanagement.domain.ads.Body;
import adsmanagement.domain.ads.Title;
import adsmanagement.services.Id;
import adsmanagement.services.TimeServer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Date;


public class AdsManagementShould {

    @Mock TimeServer timeServer;

    //redundant-test-but-it-means-it-works
    @Test
    void be_able_to_check_if_the_repository_has_100_adds_and_if_it_does_remove_the_first_one_added(){

        Title title = new Title("title");
        Body body = new Body("body");
        Id id = new Id("1");
        Title title1 = new Title("Hola");
        Body body1 = new Body("Body1");
        Id id1 = new Id("2");

        Ad expectedAd = new Ad(title, body, new Date(), id);
        Ad ad = new Ad(title1, body1, new Date(), id1);
        InMemoryRepository inMemoryRepository = new InMemoryRepository();
        inMemoryRepository.save(id, expectedAd);
        inMemoryRepository.save(id1, ad);

        AdsManagement adsManagement = new AdsManagement(inMemoryRepository);
        adsManagement.checkRepository(inMemoryRepository);

        Assertions.assertEquals(2, inMemoryRepository.getAll().size());
    }

    @Test
    void remove_all_adds_before_x_date(){
        MockitoAnnotations.initMocks(this);
        Title title = new Title("title");
        Body body = new Body("body");
        Id id = new Id("1");
        TimeServer timeServer = new TimeServer();

        Title title1 = new Title("Hola");
        Body body1 = new Body("Body1");
        Id id1 = new Id("2");
        TimeServer timeserver1 = new TimeServer();


        Ad expectedAd = new Ad(title, body, new Date(2002, 11, 21), id);

        Ad ad = new Ad(title1, body1, new Date(2000, 11, 21), id1);
        InMemoryRepository inMemoryRepository = new InMemoryRepository();
        inMemoryRepository.save(id, expectedAd);
        inMemoryRepository.save(id1, ad);

        AdsManagement adsManagement = new AdsManagement(inMemoryRepository);
        adsManagement.cleanAds(new Date (2001, 8, 10), inMemoryRepository);

        Assertions.assertEquals(1, inMemoryRepository.getAll().size());
    }
}
