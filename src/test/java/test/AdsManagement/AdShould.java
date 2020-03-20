package test.AdsManagement;

import adsmanagement.domain.ads.Ad;
import adsmanagement.domain.ads.Body;
import adsmanagement.domain.ads.Title;
import adsmanagement.domain.exeptions.TitleAndBodyEquality;
import adsmanagement.domain.exeptions.TooManyCharacters;
import adsmanagement.services.Id;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class AdShould {

    @Test
    void Add_an_add_if_it_does_not_exist() {

        Title title = new Title("title");
        Body body = new Body("body");
        Id id = new Id();
        Ad expectedAd = new Ad(title, body, new Date(), id);
    }

    @Test
    void not_add_a_catalog_if_title_has_more_than_50_characters(){

        Title title = new Title("title should be less than 50 characters or it should return a null statement");
        Body body = new Body("body");
        Id id = new Id();
        Ad expectedAd = new Ad(title, body, new Date(), id);

        Assertions.assertThrows(TooManyCharacters.class, ()-> expectedAd.add(expectedAd));
    }

    @Test
    void not_add_a_catalog_if_title_and_body_are_equal(){

        Title title = new Title("body");
        Body body = new Body("body");
        Id id = new Id();
        Ad expectedAd = new Ad(title, body, new Date(), id);

        Assertions.assertThrows(TitleAndBodyEquality.class, ()-> expectedAd.add(expectedAd));
    }

}
