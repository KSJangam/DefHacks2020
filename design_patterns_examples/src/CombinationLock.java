class CombinationLock
    //State design pattern example
{
    private int [] combination;
    public String status = "LOCKED";

    public CombinationLock(int[] combination)
    {
        this.combination = combination;
    }

    public void enterDigit(int digit)
    {
        if(status.equals("LOCKED"))status=""+digit;
        else status+=digit;
        if(status.length()==combination.length)
            checkComplete();


    }
    private void checkComplete(){
        boolean correct=true;
        for(int i=0; i<status.length(); i++){
            if(!(status.substring(i,i+1).equals(""+combination[i]))){
                status="ERROR";
                correct=false;
                break;
            }
        }
        if(correct)status="OPEN";

    }
    // todo: check digit and update status here

}