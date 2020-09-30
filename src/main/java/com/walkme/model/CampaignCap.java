package com.walkme.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CampaignCap {
    @JsonProperty
    private int maxCountPerUser;

    @JsonProperty
    private int maxCount;
}
