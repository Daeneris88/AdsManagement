package adsmanagement.domain.adsManagement;

import adsmanagement.InMemoryRepository;
import adsmanagement.domain.ads.Ad;
import adsmanagement.services.Id;

import java.util.*;

public class AdsManagement {

    private List<Ad> adList;

    public AdsManagement(InMemoryRepository inMemoryRepository) {
        this.adList = inMemoryRepository.getAll();
    }

    public void checkRepository(InMemoryRepository inMemoryRepository) {
        if(this.adList.size() >= 100) cleanOldestAds(inMemoryRepository);
    }

    private void cleanAd(InMemoryRepository inMemoryRepository) {
        Ad ad = this.adList.get(0);
        Id id = ad.getId();
        inMemoryRepository.remove(id);
    }

    public void cleanOldestAds(InMemoryRepository inMemoryRepository) {
        Comparator<Ad> compareByDates = (Ad ad0, Ad ad1) -> ad0.getDate().compareTo(ad1.getDate());
        Collections.sort(adList, compareByDates);
        cleanAd(inMemoryRepository);
    }

    public void cleanLessAccessedAds(InMemoryRepository inMemoryRepository) {
        Comparator<Ad> compareByViews = (Ad ad0, Ad ad1) -> ad0.views().compareTo(ad1.views());
        Collections.sort(adList, compareByViews);
        cleanAd(inMemoryRepository);
    }

    public void cleanAds (Date date, InMemoryRepository inMemoryRepository){
        for (Ad ad : adList) {
            checkAndRemoveOldAds(date, inMemoryRepository, ad);
        }
    }

    private void checkAndRemoveOldAds (Date date, InMemoryRepository inMemoryRepository, Ad ad){
        Date adDate = ad.getDate();
        if (date.getTime() > adDate.getTime()) inMemoryRepository.remove(ad.getId());
    }
}

