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
import services.IDonorService;

@RestController
@RequestMapping(value = "/donation")
public class DonationController {
    private final IDonationService donationService;
    private final IDonorService donorService;

    @Autowired
    public DonationController(IDonationService donationService, IDonorService donorService) {
        this.donationService = donationService;
        this.donorService = donorService;
    }
    @PostMapping(value = "/saveDonation")
    public void saveDonation(@RequestBody DonationFields donationFields)
    {
        System.out.println(donationFields.toString());
        donationService.save(new Donation(
                donorService.getById(donationFields.getIdDonor()),
                donationFields.getCollectionDate(),
                donationFields.getForPerson(),
                donationFields.getHealthIssues()));
    }
}
