package test;

import adsmanagement.InMemoryRepository;
import adsmanagement.domain.AdsManagementService;
import adsmanagement.domain.ads.Ad;
import adsmanagement.domain.ads.Body;
import adsmanagement.domain.ads.Title;
import adsmanagement.services.Id;
import adsmanagement.services.TimeServer;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import java.util.Date;

import static org.mockito.Mockito.*;

public class AdsManagementServiceShould {

    @Mock InMemoryRepository catalogRepository;
    @Mock TimeServer timeServer;

    @Test
    public void save_an_ad_correctly_in_repository(){
       MockitoAnnotations.initMocks(this);

        Title title = new Title("Title");
        Body body = new Body("Body");
        Id id = new Id();
        Ad expectedAd = new Ad(title, body, new Date(2002, 2, 3), id);

        when(timeServer.getdate()).thenReturn(new Date(2002, 2, 3));
        AdsManagementService adsManagementService = new AdsManagementService(catalogRepository, timeServer);
        adsManagementService.addAd(title, body, timeServer.getdate(), id);

        verify(catalogRepository).save(id, expectedAd);
    }

    @Test
    public void remove_an_ad_correctly_in_repository(){
        MockitoAnnotations.initMocks(this);

        Title title = new Title("Title");
        Body body = new Body("Body");
        Id id = new Id();

        when(timeServer.getdate()).thenReturn(new Date(2002, 2, 3));
        AdsManagementService adsManagementService = new AdsManagementService(catalogRepository, timeServer);
        adsManagementService.addAd(title, body, timeServer.getdate(), id);
        adsManagementService.remove(id);

        verify(catalogRepository).remove(id);
    }

    @Test
    public void get_one_ad_correctly_in_repository(){
        MockitoAnnotations.initMocks(this);

        Title title = new Title("Title");
        Body body = new Body("Body");
        Id id = new Id();

        when(timeServer.getdate()).thenReturn(new Date(2002, 2, 3));
        AdsManagementService adsManagementService = new AdsManagementService(catalogRepository, timeServer);
        adsManagementService.addAd(title, body, timeServer.getdate(), id);
        adsManagementService.getAdd(id);

        verify(catalogRepository).get(id);
    }


}


