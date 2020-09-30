package com.walkme.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mongodb.lang.NonNull;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Getter
@Setter
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "campaign")
public class Campaign {

    @Id
    private @NonNull String id = UUID.randomUUID().toString();

    @JsonProperty
    private String name;

    @JsonProperty
    private String data;

    @JsonProperty
    private CampaignCap cap;

    public Campaign(String name, String data, int maxCountPerUser, int maxCount) {
        this.name = name;
        this.data = data;
        this.cap = new CampaignCap(maxCountPerUser, maxCount);
    }

    public CampaignDTO toDTO() {
        return new CampaignDTO(this.id, this.name, this.data);
    }
}
