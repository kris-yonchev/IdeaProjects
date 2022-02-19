package unitTestingExercise.p06_TirePressureMonitoringSystem;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class AlarmTest {
    private static final double LOW_PRESSURE_VALUE = 12.0;
    private static final double HIGH_PRESSURE_VALUE = 50.0;
    private static final double NORMAL_PRESSURE_VALUE = 18.0;

    private Alarm alarm;

    @Test
    public void alarmTestTurnsOnForLowPressure() {
     Sensor mockedSensorForLowPressure = Mockito.mock(Sensor.class);

        when(mockedSensorForLowPressure.popNextPressurePsiValue()).thenReturn(LOW_PRESSURE_VALUE);
        alarm = new Alarm(mockedSensorForLowPressure);
        alarm.check();
        Assert.assertTrue(alarm.getAlarmOn());

    }

    @Test
    public void alarmTestTurnOnForHighPressure() {
        Sensor mockedSensorForHighPressure = Mockito.mock(Sensor.class);

        when(mockedSensorForHighPressure.popNextPressurePsiValue()).thenReturn(HIGH_PRESSURE_VALUE);
        alarm = new Alarm(mockedSensorForHighPressure);
        alarm.check();
        Assert.assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void alarmIsOffForNormalPressure() {
        Sensor mockedSensor = Mockito.mock(Sensor.class);

        when(mockedSensor.popNextPressurePsiValue()).thenReturn(NORMAL_PRESSURE_VALUE);
        alarm = new Alarm(mockedSensor);
        alarm.check();
        Assert.assertFalse(alarm.getAlarmOn());
    }

}