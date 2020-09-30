package com.walkme.controllers;

import com.walkme.model.Campaign;
import com.walkme.model.CampaignCap;
import com.walkme.model.CampaignDTO;
import com.walkme.repositories.CampaignRepository;
import com.walkme.services.CampaignService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value="campaigns")
public class CampaignController {
    private static Logger logger = LogManager.getLogger(CampaignController.class);

    @Autowired
    private CampaignRepository campaignRepository;

    @Autowired
    private CampaignService campaignService;

    @GetMapping("/{user_id}")
    public ResponseEntity<List<CampaignDTO>> getCampaigns(@PathVariable("user_id") String userId) {
        return ResponseEntity.ok(campaignService.getCampaignsForUser(userId));
    }

    @PostMapping("/add")
    public ResponseEntity<Campaign> add(@RequestParam String name,
                                        @RequestParam String data,
                                        @RequestParam int maxCountPerUser,
                                        @RequestParam int maxCount) {
        try {
            Campaign campaign = new Campaign(name, data, maxCountPerUser, maxCount);
            return ResponseEntity.ok(campaignRepository.save(campaign));
        } catch (Exception e) {
            logger.warn("Caught exception in add campaign: " + e.toString());
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Campaign> update(@PathVariable String id,
                                                   @RequestParam int maxCountPerUser,
                                                   @RequestParam int maxCount) {
        try {
            Campaign campaign = campaignRepository.findById(id).orElseThrow(Exception::new);
            CampaignCap cap = new CampaignCap(maxCountPerUser, maxCount);
            campaign.setCap(cap);
            return ResponseEntity.ok(campaignRepository.save(campaign));
        } catch (Exception e) {
            logger.warn("Caught exception in updateNote: " + e.toString());
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }



}
