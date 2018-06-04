import model.Donor;
import model.User;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import repositories.DonorRepository;
import repositories.UserRepository;
import services.DonorService;
import static org.mockito.Mockito.*;
import static org.junit.Assert.assertEquals;

public class DonorServiceTest {
    private final Donor donor = new Donor();

    @Mock
    private DonorRepository donorRepository;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private DonorService service;

    @Before
    public void setupMock(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSave(){
        service.save(donor);
        verify(donorRepository).save(donor);
    }

    @Test
    public void testGetById(){
        when(donorRepository.findById(1L)).thenReturn(donor);
        assertEquals(donor, service.getById(1L));
    }

    @Test
    public void testGetUserDonor(){
        User user = new User();
        when(userRepository.findById(1L)).thenReturn(user);
        assertEquals(user, service.getUserDonor(1L));
    }
}
