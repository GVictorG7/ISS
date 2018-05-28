package controllers;

import controllers.formatters.DonationFields;
import model.HealthIssue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import services.interfaces.IDonationService;


@RestController
@RequestMapping(value = "/donation")
public class DonationController {
    private final IDonationService donationService;

    @Autowired
    public DonationController(IDonationService donationService) {
        this.donationService = donationService;

    }
    @PostMapping(value = "/save")
    public void saveDonation(@RequestBody DonationFields donationFields)
    {
        System.out.println(donationFields.toString());
        donationService.save(
                donationFields.getIdDonor(),
                donationFields.getCollectionDate(),
                donationFields.getForPerson(),
                donationFields.getHealthIssues());
    }

    @GetMapping(value = "/allHealthIssues")
    public HealthIssue[] getAllHealthIssues()
    {
        return HealthIssue.values();
    }
}
