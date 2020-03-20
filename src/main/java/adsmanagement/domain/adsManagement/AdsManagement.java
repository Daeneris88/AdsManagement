package adsmanagement.domain.adsManagement;

import adsmanagement.InMemoryRepository;
import adsmanagement.domain.ads.Ad;
import adsmanagement.services.Id;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdsManagement {

    private List<Ad> adList = new ArrayList<Ad>();

    public AdsManagement(InMemoryRepository inMemoryRepository) {

        this.adList = inMemoryRepository.getAll();
    }

    public void checkRepository(InMemoryRepository inMemoryRepository) {
        if(adList.size() >= 100) cleanOldestAd(inMemoryRepository);
    }

    private void cleanOldestAd(InMemoryRepository inMemoryRepository) {
        Ad ad = adList.get(0);
        Id id = ad.getId();
        inMemoryRepository.remove(id);
    }

    public void cleanAds(Date date, InMemoryRepository inMemoryRepository){
        for (Ad ad : adList) {
            Date adDate = ad.getDate();
            if(date.getTime() > adDate.getTime()) {
                inMemoryRepository.remove(ad.getId());
            }
        }
    }

}

