import model.Doctor;
import model.Hospital;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import repositories.HospitalRepository;
import services.HospitalService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class HospitalServiceTest {
    @Mock
    private final Hospital hospital = new Hospital();

    @Mock
    private HospitalRepository hospitalRepository;

    @InjectMocks
    private HospitalService service;

    @Before
    public void setupMock(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSave(){
        service.save(hospital);
        verify(hospitalRepository).save(hospital);
    }

    @Test
    public void testGetById(){
        when(hospitalRepository.findById(1L)).thenReturn(hospital);
        assertEquals(hospital, service.getById(1L));
    }

    @Test
    public void testAddDoctor(){
        Doctor doctor = new Doctor();
        List<Doctor> doctorList = new ArrayList<>();
        doctorList.add(doctor);
        hospital.setDoctors(doctorList);
        service.addDoctor(hospital, doctor);
        verify(hospital).addMedic(doctor);
    }
}
