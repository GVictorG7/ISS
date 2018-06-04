import model.Doctor;
import model.Donor;
import model.Personnel;
import model.User;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import repositories.DoctorRepository;
import repositories.DonorRepository;
import repositories.PersonnelRepository;
import repositories.UserRepository;
import services.UserService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.*;

public class UserServiceTest {
    private final User user = new User();
    @Mock
    private UserRepository userRepository;

    @Mock
    private DonorRepository donorRepository;

    @Mock
    private DoctorRepository doctorRepository;

    @Mock
    private PersonnelRepository personnelRepository;

    @InjectMocks
    private UserService service;

    @Before
    public void setupMock(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testLogin(){
        when(userRepository.findByUsernameAndPassword("a", "d")).thenReturn(null);
        assertNull(service.login("a", "d"));
    }

    @Test
    public void testGetUserDonor(){
        Donor donor = new Donor();
        when(userRepository.findById(1L)).thenReturn(user);
        when(donorRepository.findByUser(user)).thenReturn(donor);
        assertEquals(donor, service.getUserDonor(1L));
    }

    @Test
    public void testGetUserDoctor(){
        Doctor doctor = new Doctor();
        when(userRepository.findById(1L)).thenReturn(user);
        when(doctorRepository.findByUser(user)).thenReturn(doctor);
        assertEquals(doctor, service.getUserDoctor(1L));
    }

    @Test
    public void testGetUserPersonnel(){
        Personnel personnel = new Personnel();
        when(userRepository.findById(1L)).thenReturn(user);
        when(personnelRepository.findByUser(user)).thenReturn(personnel);
        assertEquals(personnel, service.getUserPersonel(1L));
    }

    @Test
    public void testGetUsernames(){
        List<String> stringList = new ArrayList<>();
        when(userRepository.getUsernames()).thenReturn(stringList);
        assertEquals(stringList, service.getUsernames());
    }

    @Test
    public void testSave(){
        service.save(user);
        verify(userRepository).save(user);
    }

    @Test
    public void testUpdate(){
        service.update(user);
        verify(userRepository).save(user);
    }
}
