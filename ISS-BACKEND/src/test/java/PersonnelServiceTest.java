import model.Donation;
import model.Personnel;
import model.Request;
import model.User;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import repositories.DonationRepository;
import repositories.PersonnelRepository;
import repositories.RequestRepository;
import repositories.UserRepository;
import services.PersonnelService;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class PersonnelServiceTest {
    private final Personnel personnel = new Personnel();
    @Mock
    private UserRepository userRepository;

    @Mock
    private PersonnelRepository personnelRepository;

    @Mock
    private RequestRepository requestRepository;

    @Mock
    private DonationRepository donationRepository;

    @InjectMocks
    private PersonnelService service;

    @Before
    public void setupMock(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSave(){
        service.save(personnel);
        verify(personnelRepository).save(personnel);
    }

    @Test
    public void testGetAllDonations(){
        Donation donation = new Donation();
        when(donationRepository.findAll()).thenReturn(Arrays.asList(donation));
        assertEquals(Arrays.asList(donation), service.getAllDonation());
    }

    @Test
    public void testGetAllBloodRequest(){
        Request request = new Request();
        when(requestRepository.findAll()).thenReturn(Arrays.asList(request));
        assertEquals(Arrays.asList(request), service.getAllBloodRequest());
    }

    @Test
    public void testGetUserPersonnel(){
        User user = new User();
        when(userRepository.findById(1L)).thenReturn(user);
        assertEquals(user, service.getUserPersonnel(1L));
    }
}
