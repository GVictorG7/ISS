import controllers.formatters.BloodCounterTypes;
import model.Blood;
import model.BloodCategory;
import model.BloodRH;
import model.BloodType;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import repositories.BloodRepository;
import services.BloodService;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class BloodServiceTest {
    private final Blood blood = new Blood(BloodType.B,BloodRH.POSITIVE,BloodCategory.PLASMA,true, LocalDate.now());

    @InjectMocks
    private BloodService service;

    @Mock
    private BloodRepository bloodRepository;

    @Before
    public void setupMock(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddMethod(){
        when(bloodRepository.save(any(Blood.class))).thenReturn(new Blood());
        Blood blood = new Blood();
        assertThat(service.save(blood.getBloodType(), blood.getBloodRH(), blood.getBloodCategory(), blood.getUsed(),blood.getExpireDate()),
                is(notNullValue()));
    }

    @Test
    public void testDeleteMethod(){
        service.delete(1L);
        verify(bloodRepository).delete(1L);
    }

    @Test
    public void testGetAll(){
        when(bloodRepository.findAll()).thenReturn(Arrays.asList(blood));
        assertEquals(Arrays.asList(blood), service.getAll());
    }

    @Test
    public void testFindById(){
        when(bloodRepository.getById(1L)).thenReturn(blood);
        assertEquals(blood, service.findById(1L));
    }

    @Test
    public void testGetBloodCounter(){
        when(bloodRepository.findAllValid()).thenReturn(new ArrayList<>());
        assertThat(service.getBloodCounter(), is(notNullValue()));
    }
}


