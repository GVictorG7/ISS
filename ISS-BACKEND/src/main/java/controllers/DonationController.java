package controllers;

import controllers.formatters.DonationFieldDOnor;
import controllers.formatters.DonationFields;
import model.Donation;
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
    public Donation saveDonation(@RequestBody DonationFieldDOnor donationFieldDOnor)
    {

      return donationService.save(donationFieldDOnor.getIdDonor());


    }

    @GetMapping(value = "/allHealthIssues")
    public HealthIssue[] getAllHealthIssues()
    {
        return HealthIssue.values();
    }

    @PostMapping(value = "/changeStatus")
    public void changeStatus(@RequestBody DonationFields donationFields){


    }
}
