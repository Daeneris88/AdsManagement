package adsmanagement.domain.ads;

import java.util.Objects;

public class Body {

    private String body;

    public Body(String body) {
        this.body = body;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Body body1 = (Body) o;
        return Objects.equals(body, body1.body);
    }

    @Override
    public int hashCode() {
        return Objects.hash(body);
    }

    @Override
    public String toString() {
        return body;
    }
}
