package fop.w7cal;

public class InfiniteRepeatEvent extends Event {
    private int period;

    public InfiniteRepeatEvent(int day, String description, String place, int period) {
        super(day, description, place);
        this.period = period;
    }

    public int getPeriod() {
        return period;
    }

    @Override
    public int diff(int day){
        int currDay = super.getDay();
        while (true){
            if(day <= currDay){
                return currDay - day;
            }currDay += period;
        }
    }
}
