package com.walkme.repositories;

import com.walkme.model.CampaignUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CampaignUserRepository extends MongoRepository<CampaignUser, String> {
    Optional<List<CampaignUser>>findByCampaignId(String campaignId);
    Optional<CampaignUser>findByCampaignIdAndUserId(String campaignId, String userId);

}