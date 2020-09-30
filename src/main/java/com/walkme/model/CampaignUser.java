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
@Document(collection = "campaign_user")
public class CampaignUser {

    @Id
    private @NonNull String id = UUID.randomUUID().toString();

    @JsonProperty
    private @NonNull String userId = "";

    @JsonProperty
    private String campaignId;

    @JsonProperty
    private long shown;

}
