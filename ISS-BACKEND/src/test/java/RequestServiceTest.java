import model.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import repositories.BloodRepository;
import repositories.DoctorRepository;
import repositories.DonationRepository;
import repositories.RequestRepository;
import services.RequestService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class RequestServiceTest {
    private final Request request = new Request();
    @Mock
    private RequestRepository requestRepository;

    @Mock
    private DoctorRepository doctorRepository;

    @Mock
    private BloodRepository bloodRepository;

    @Mock
    private DonationRepository donationRepository;

    @InjectMocks
    private RequestService service;

    @Before
    public void setupMock(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSave(){
        service.save(request);
        verify(requestRepository).save(request);
    }

    @Test
    public void testGetById(){
        when(requestRepository.findById(1L)).thenReturn(request);
        assertEquals(request, service.getById(1L));
    }

    @Test
    public void testGetAllRequest(){
        when(requestRepository.findAll()).thenReturn(Arrays.asList(request));
        assertEquals(Arrays.asList(request), service.getAllRequest());
    }

    @Test
    public void testGetAllRequestsByStatus(){
        when(requestRepository.findAllByStatusOpne()).thenReturn(1);
        assertEquals(1, service.getAllRequestsByStatus());
    }

    @Test
    public void testGetAllRequestsByDoctor(){
        Doctor doctor = new Doctor();
        when(requestRepository.findAllByDoctorOrderByRequestDate(doctor)).thenReturn(Arrays.asList(request));
        assertEquals(Arrays.asList(request), service.getAllRequestsByDoctor(doctor));
    }

    @Test
    public void testFindDesireBlood(){
        Blood blood = new Blood();
        Blood returned = new Blood();
        when(bloodRepository.findBloodForRequest(blood.getBloodCategory(), blood.getBloodRH(), blood.getBloodType())).thenReturn(Arrays.asList(returned));
        assertEquals(returned, service.findDesireBlood(blood.getBloodType(), blood.getBloodRH(), blood.getBloodCategory(), 1));
    }

    @Test
    public void testSaveSeparatedBlood(){
        Blood blood = new Blood();
        service.saveSeparatedBlood(blood, BloodCategory.PLASMA);
        verify(bloodRepository).delete(blood);
        verify(bloodRepository).save(blood);
    }

    @Test
    public void testCompatibleDonors(){
        Blood blood = new Blood();
        Donation donation = new Donation();
        Donor donor = new Donor();
        donor.setLocalAddress("Cluj");
        donation.setDonor(donor);
        when(donationRepository.getAllByBloodTypeAndBloodRH(blood.getBloodType(), blood.getBloodRH())).thenReturn(Arrays.asList(donation));
        assertEquals(new ArrayList<>(), service.getCopatibleDonors(blood.getBloodType(), blood.getBloodRH()));
    }

    @Test
    public void testAllNotDone(){
        when(requestRepository.findAllNotDone()).thenReturn(Arrays.asList(request));
        assertEquals(Arrays.asList(request), service.findAllNotDone());
    }
}
