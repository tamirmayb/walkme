package com.walkme.services;

import com.walkme.model.Campaign;
import com.walkme.model.CampaignDTO;
import com.walkme.model.CampaignUser;
import com.walkme.repositories.CampaignRepository;
import com.walkme.repositories.CampaignUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CampaignService {

    @Autowired
    private CampaignUserRepository campaignUserRepository;

    @Autowired
    private CampaignRepository campaignRepository;


    public List<CampaignDTO> getCampaignsForUser(String userId) {
        List<CampaignDTO> result = new ArrayList<>();
        List<Campaign> allCampaigns = campaignRepository.findAll();
        allCampaigns.forEach(c-> {
            List<CampaignUser> campaignUsers = campaignUserRepository.findByCampaignId(c.getId()).orElseGet(ArrayList::new);

            Long sumShownByCampaignId = campaignUsers.stream()
                    .map(CampaignUser::getShown)
                    .reduce(0L, Long::sum);

            if(sumShownByCampaignId < c.getCap().getMaxCount()) {
                CampaignUser byCampaignIdAndUserId = campaignUserRepository.findByCampaignIdAndUserId(c.getId(), userId).orElseGet(CampaignUser::new);
                long countByCampaignIdAndUserId = byCampaignIdAndUserId.getShown();
                if(countByCampaignIdAndUserId < c.getCap().getMaxCountPerUser()) {
                    CampaignUser campaignUser = new CampaignUser(byCampaignIdAndUserId.getId(), userId, c.getId(), countByCampaignIdAndUserId + 1);
                    campaignUserRepository.save(campaignUser);
                    result.add(c.toDTO());
                }
            }
        });
        return result;
    }
}
