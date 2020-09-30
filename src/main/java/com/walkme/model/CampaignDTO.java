package com.walkme.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;


@Getter
@Setter
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CampaignDTO {

    @JsonProperty
    private String id;

    @JsonProperty
    private String name;

    @JsonProperty
    private String data;

}