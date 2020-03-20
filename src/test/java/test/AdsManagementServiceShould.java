package test;

import adsmanagement.InMemoryRepository;
import adsmanagement.services.TimeServer;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;


import static org.mockito.Mockito.*;

public class AdsManagementServiceShould {

    @Mock
    InMemoryRepository catalogRepository;
    @Mock TimeServer timeServer;

    @Test
    public void save_an_ad_correctly_in_repository(){

       /* MockitoAnnotations.initMocks(this);

        Title title = new Title("Title");
        Body body = new Body("Body");

        AdsManagementService adsManagementService = new AdsManagementService(catalogRepository, timeServer);
        when(timeServer.getDate()).thenReturn("31/05/2020");
        adsManagementService.addAd(title, body);

        verify(catalogRepository).save(title, body);
    */}
}
