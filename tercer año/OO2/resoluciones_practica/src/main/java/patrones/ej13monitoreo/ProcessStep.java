package patrones.ej13monitoreo;

public abstract class ProcessStep {
    private boolean result;


    public void execute (MixingTank tank){
        if (this.basicExecute(tank)){
            this.setSuccess();
        }
        else this.setFailure();
    }

    public abstract boolean basicExecute (MixingTank tank);

    public boolean isDone(){
        return this.result;
    }

    public void setSuccess(){
        this.result=true;
    }

    public void setFailure(){
        this.result=false;
    }

}
