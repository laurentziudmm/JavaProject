package reflection.domain;

import reflectionTwo.api.annotation.Column;
import reflectionTwo.api.annotation.Table;


@Table(name="locations")
public class Location2 {
    @Column(name = "location_id")
    private Long id;

    @Column(name="location_name")
    private String name;


    private String otherProperty1;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOtherProperty1() {
        return otherProperty1;
    }

    public void setOtherProperty1(String otherProperty1) {
        this.otherProperty1 = otherProperty1;
    }
}
