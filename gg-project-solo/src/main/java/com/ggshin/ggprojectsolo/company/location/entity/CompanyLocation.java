package com.ggshin.ggprojectsolo.company.location.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter /*mapping 시에 꼭 필요!*/
@Entity
public class CompanyLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String location;
    private String locationCode;

    @Builder
    public CompanyLocation(String location, String locationCode) {
        this.location = location;
        this.locationCode = locationCode;
    }

    public String getLocationCode() {
        return locationCode;
    }
    public void setLocationCode(String locationCode) {
        this.locationCode = locationCode;
    }

    @Override
    public String toString() {
        return "CompanyLocation{" +
                "id=" + id +
                ", location='" + location + '\'' +
                ", locationCode='" + locationCode + '\'' +
                '}';
    }
}
