package adsmanagement.domain;

import adsmanagement.InMemoryRepository;
import adsmanagement.domain.ads.Ad;
import adsmanagement.domain.adsManagement.AdsManagement;
import adsmanagement.domain.ads.Body;
import adsmanagement.domain.ads.Title;
import adsmanagement.services.Id;
import adsmanagement.services.TimeServer;

import java.util.Date;

public class AdsManagementService {

    public final InMemoryRepository catalogRepository;
    private TimeServer timeServer;

    public AdsManagementService(InMemoryRepository catalogRepository, TimeServer timeServer) {
        this.catalogRepository = catalogRepository;
        this.timeServer = timeServer;
    }

    public void addAd(Title title, Body body, Date timeserver, Id id) {
        AdsManagement adsManagement = new AdsManagement(catalogRepository);
        adsManagement.checkRepository(catalogRepository);
        Ad ad = new Ad(title,  body, timeserver, id);
        catalogRepository.save(id, ad);
    }

    public void remove(Id id){
        Ad ad = catalogRepository.get(id);
        catalogRepository.remove(id);
    }

    public Ad getAdd(Id id){
       Ad ad = catalogRepository.get(id);
       return ad;
    }

    public void removeOldAds(Date timeserver){
        AdsManagement adsManagement = new AdsManagement(catalogRepository);
        adsManagement.cleanAds(timeserver, catalogRepository);
    }
}
