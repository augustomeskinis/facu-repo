package patrones.ej13monitoreo;

public class Purge extends ProcessStep {

    public boolean basicExecute(MixingTank tank){
        return tank.heatPower(20)
                && tank.mixerPower(5);
    }
}
