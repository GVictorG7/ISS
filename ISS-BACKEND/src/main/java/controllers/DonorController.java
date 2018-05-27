package controllers;
import controllers.formatters.DonorFields;
import model.Donor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import services.IBloodService;
import services.IDonorService;
import services.IUserService;

@RestController
@RequestMapping(value = "/donor")
public class DonorController {
    private final IDonorService donorService;
    private final IUserService userService;
    private final IBloodService bloodService;

    @Autowired
    public DonorController(IDonorService donorService, IUserService userService, IBloodService bloodService) {
        this.donorService = donorService;
        this.userService = userService;
        this.bloodService = bloodService;
    }

    @PostMapping(value = "/saveDonor")
    public void saveDonation(@RequestBody DonorFields donorFields)
    {
        System.out.println(donorFields.toString());
        donorService.save(new Donor(
                donorFields.getName(),
                donorFields.getBirthday(),
                donorFields.getDomiciliu(),
                donorFields.getResedinta(),
                donorFields.getEmail(),
                donorFields.getPhone(),
                userService.getByUsername(donorFields.getUsername()),
                bloodService.findById(donorFields.getIdBlood())
        ));
    }
}
