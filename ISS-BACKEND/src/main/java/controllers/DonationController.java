package controllers;

import controllers.formatters.DonationFieldDOnor;
import controllers.formatters.DonationFields;
import model.Donation;
import model.HealthIssue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import services.DonationService;

import java.util.List;


@RestController
@RequestMapping(value = "/donation")
public class DonationController {
    private final DonationService donationService;

    @Autowired
    public DonationController(DonationService donationService) {
        this.donationService = donationService;

    }

    @PostMapping(value = "/save")
    public Donation saveDonation(@RequestBody DonationFieldDOnor donationFieldDOnor) {
        return donationService.save(donationFieldDOnor.getIdDonor());
    }

    @GetMapping(value = "/allHealthIssues")
    public HealthIssue[] getAllHealthIssues() {
        return HealthIssue.values();
    }

    @PostMapping(value = "/changeStatus")
    public void changeStatus(@RequestBody DonationFields donationFields) {


    }

    /**
     * Get all donations by given donor
     *
     * @param idDonor - id of donor
     * @return list of donations
     */
    @PostMapping(value = "/allDonations/{idDonor}")
    public List<Donation> getAllDonationsForDonor(@PathVariable long idDonor) {
        return this.donationService.getAllDonationsByDonor(idDonor);
    }

    /**
     * Updates a donation
     *
     * @param donation - the given donation
     */
    @PutMapping
    public void updateDonation(@RequestBody Donation donation) {
        donationService.update(donation);
    }

    /**
     * Gets all open donations
     *
     * @return list of donations
     */
    @RequestMapping(value = "/openDonations")
    public List<Donation> getAllOpenDonations() {
        return donationService.getAllOpenDonations();
    }
}
