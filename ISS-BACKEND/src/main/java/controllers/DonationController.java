package controllers;

import controllers.formatters.DonationFields;
import model.Donation;
import model.Donor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import services.IDonationService;

@RestController
@RequestMapping(value = "/donation")
public class DonationController {
    private final IDonationService donationService;

    @Autowired
    public DonationController(IDonationService donationService) {
        this.donationService = donationService;
    }
    @PostMapping(value = "/saveDonation")
    public void saveDonation(@RequestBody DonationFields donationFields)
    {

        System.out.println(donationFields.toString());
        donationService.save(new Donation(
                donationFields.getCollectionDate(),
                donationFields.getForPerson(),
                donationFields.getHealthIssues()));
    }
}
