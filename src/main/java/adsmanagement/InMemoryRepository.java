package adsmanagement;
import adsmanagement.domain.ads.Ad;
import adsmanagement.services.Id;
import java.util.*;

public class InMemoryRepository {
    HashMap <Id, Ad> catalogRepository = new HashMap<Id, Ad>();

    public void save(Id id, Ad ad) {
        catalogRepository.put(id, ad);
    }

    public Ad get(Id id) {
        if(catalogRepository.containsKey(id)) return catalogRepository.get(id);
        return null;
    }

    public void remove(Id id) {
        catalogRepository.remove(id);
    }

    public List getAll() {

        List<Ad> adsList = new ArrayList<Ad>();
        Iterator catalogIterator =catalogRepository.entrySet().iterator();

        while (catalogIterator.hasNext()) {
            Map.Entry mapElement = (Map.Entry) catalogIterator.next();
            adsList.add((Ad) mapElement.getValue());
        }
        return adsList;
    }

}
