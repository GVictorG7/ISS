package controllers;

import controllers.formatters.DonationFieldDOnor;
import controllers.formatters.DonationFields;
import model.Donation;
import model.HealthIssue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import services.DonationService;
import services.interfaces.IDonationService;

import java.util.List;


@RestController
@RequestMapping(value = "/donation")
public class DonationController {
    private final IDonationService donationService;

    @Autowired
    public DonationController(IDonationService donationService) {
        this.donationService = donationService;

    }

    @PostMapping(value = "/save")
    public Donation saveDonation(@RequestBody DonationFieldDOnor donationFieldDOnor) {
        return donationService.save(donationFieldDOnor.getIdDonor());
    }
    @GetMapping(value = "getAll")
    public List<Donation> getAllDonation(){
        return donationService.findAll();
    }

    @GetMapping(value = "/allHealthIssues")
    public HealthIssue[] getAllHealthIssues() {
        return HealthIssue.values();
    }

    @PostMapping(value = "/changeStatus")
    public void changeStatus(@RequestBody DonationFields donationFields){
        donationService.changeStatus(donationFields.getIdDonatie(),donationFields.getIdDonor(),donationFields.getCollectionDate(),donationFields.getForPerson(),donationFields.getStatus(),donationFields.getBloodRH(),donationFields.getBloodType(),donationFields.getHealthIssues());

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
    @GetMapping(value = "/openDonations")
    public List<Donation> getAllOpenDonations() {
        return donationService.getAllOpenDonations();
    }
}
