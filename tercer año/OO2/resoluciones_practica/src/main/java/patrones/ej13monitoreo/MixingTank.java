package patrones.ej13monitoreo;

/**
 * Mock simple de MixingTank para tests
 */

// consultar que tipo de TDD es y cómo es la implementacion

public class MixingTank {
    private boolean heatPowerResult = true;
    private boolean mixerPowerResult = true;
    private boolean purgeResult = true;

    public void setHeatPowerResult(boolean result) {
        this.heatPowerResult = result;
    }

    public void setMixerPowerResult(boolean result) {
        this.mixerPowerResult = result;
    }

    public void setPurgeResult(boolean result) {
        this.purgeResult = result;
    }


    public boolean heatPower(int power) {
        return heatPowerResult;
    }


    public boolean mixerPower(int power) {
        return mixerPowerResult;
    }


    public int upTo() {
        return 0;
    }


    public double temperature() {
        return 0;
    }
}