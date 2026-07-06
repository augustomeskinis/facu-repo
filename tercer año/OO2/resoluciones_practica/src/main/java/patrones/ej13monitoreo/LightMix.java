package patrones.ej13monitoreo;

public class LightMix extends ProcessStep {


    @Override
    public boolean basicExecute(MixingTank tank) {
       /* return tank.heatPower(0)
                && tank.mixerPower(0)
                && tank.purge(); */
        return true;
    }
}
