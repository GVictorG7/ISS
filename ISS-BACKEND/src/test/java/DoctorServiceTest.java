import model.Doctor;
import model.Hospital;
import model.User;
import model.UserType;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import repositories.DoctorRepository;
import repositories.HospitalRepository;
import repositories.UserRepository;
import services.DoctorService;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class DoctorServiceTest {
    private final User user = new User(1, "a", "b", "DOCTOR");
    private final Hospital hospital = new Hospital();
    private final Doctor doctor = new Doctor("a","b",user, hospital);

    @Mock
    private DoctorRepository doctorRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private HospitalRepository hospitalRepository;

    @InjectMocks
    private DoctorService service;

    @Before
    public void setupMock(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetById(){
        when(doctorRepository.findById(1L)).thenReturn(doctor);
        assertEquals(doctor, service.getById(1L));
    }

    @Test
    public void testGetUserDoctor(){
        when(userRepository.findById(1L)).thenReturn(user);
        assertEquals(user, service.getUserDoctor(1L));
    }

    @Test
    public void testGetHospitalDoctor(){
        when(hospitalRepository.findById(1L)).thenReturn(hospital);
        assertEquals(hospital, service.getHospitalDoctor(1L));
    }
}
