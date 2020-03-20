package adsmanagement.services;
import java.util.Objects;
import java.util.UUID;

public class Id {

    public String uniqueID;

    public Id() {
        this.uniqueID = UUID.randomUUID().toString();
    }

    public Id(String id){
        this.uniqueID = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Id id = (Id) o;
        return Objects.equals(uniqueID, id.uniqueID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uniqueID);
    }

    @Override
    public String toString() {
        return ""+uniqueID;
    }
}
