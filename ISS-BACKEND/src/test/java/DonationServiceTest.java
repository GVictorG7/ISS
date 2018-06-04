import model.Blood;
import model.Donation;
import model.Donor;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import repositories.BloodRepository;
import repositories.DonationRepository;
import repositories.DonorRepository;
import services.DonationService;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.any;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class DonationServiceTest {
    private final Donation donation = new Donation();

    @Mock
    private DonationRepository donationRepository;

    @Mock
    private DonorRepository donorRepository;

    @Mock
    private BloodRepository bloodRepository;

    @InjectMocks
    private DonationService service;

    @Before
    public void setupMock() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetById() {
        when(donationRepository.findById(1L)).thenReturn(donation);
        assertEquals(donation, service.getById(1L));
    }

    @Test
    public void testFindAll() {
        when(donationRepository.findAll()).thenReturn(Arrays.asList(donation));
        assertEquals(Arrays.asList(donation), service.findAll());
    }

    @Test
    public void testSave() {
        when(donorRepository.findById(1L)).thenReturn(new Donor());
        service.save(1L);
        verify(donorRepository).findById(1L);
    }

    @Test
    public void testDeleteById() {
        when(donationRepository.deleteById(1L)).thenReturn(new Donation());
        assertThat(service.deleteById(1L), is(notNullValue()));
    }

    @Test
    public void testGetAllDonationsByDonor(){
        Donor donor = new Donor();
        when(donorRepository.getOne(1L)).thenReturn(donor);
        when(donationRepository.getAllByDonor(donor)).thenReturn(Arrays.asList(donation));
        assertEquals(Arrays.asList(donation),service.getAllDonationsByDonor(donor.getId()));
    }

    @Test
    public void testUpdate(){
        service.update(donation);
        verify(donationRepository).save(donation);
    }

    @Test
    public void testGetAllOpenDonationsCounter(){
        when(donationRepository.findAllByStatusOpne()).thenReturn(4);
        assertEquals(4,service.getAllOpenDonationsCounter());
    }
}
