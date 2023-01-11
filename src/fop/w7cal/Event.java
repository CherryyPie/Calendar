package fop.w7cal;

public class Event {
	private int day;
    private String description;
    private String place;

    public Event(int day, String description, String place){
        this.day = day;
        this.description = description;
        this.place = place;
    }

    public String getPlace() {
        return place;
    }

    public String getDescription() {
        return description;
    }

    public int getDay() {
        return day;
    }

    public int diff(int day){
        return this.day - day;
    }

}
