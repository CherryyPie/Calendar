package fop.w7cal;

public class RepeatEvent extends InfiniteRepeatEvent {
    private int end;

    public RepeatEvent(int day, String description, String place, int period, int end) {
        super(day, description, place, period);
        this.end = end;
    }

    public int getEnd() {
        return end;
    }

    @Override
    public int diff(int day){
        int currDay = super.getDay();
        int res = 0;
        if(day > end){
            return end - day;
        }else {
            for (int i = 0; i < (end - currDay+super.getPeriod())/super.getPeriod(); i++ ){
                if(day <= currDay){
                    res = currDay - day;
                    break;
                }currDay += super.getPeriod();

            }
        }return res;
    }
}
