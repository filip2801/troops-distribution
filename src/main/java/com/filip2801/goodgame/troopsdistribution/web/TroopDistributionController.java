package com.filip2801.goodgame.troopsdistribution.web;

import com.filip2801.goodgame.troopsdistribution.domain.TroopDistributionService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/troop-distributions")
public class TroopDistributionController {

    private final TroopDistributionService troopDistributionService;

    public TroopDistributionController(TroopDistributionService troopDistributionService) {
        this.troopDistributionService = troopDistributionService;
    }

    @PostMapping
    public TroopDistributionResource distributeTroops(@RequestBody TroopDistributionRequest request) {
        var troops = troopDistributionService.distributeTroops(request.getNumberOfSoldiers());

        return new TroopDistributionResource(troops);
    }

}
