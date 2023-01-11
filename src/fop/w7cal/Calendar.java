package fop.w7cal;

public class Calendar {
    public EventList events;

    public Calendar() {
        events = null;
    }
    public Calendar(EventList events) {
        this.events = events;
    }

    public void addNewEvent(Event event) {
        if (events == null) {
            events = new EventList(event);
        } else events = events.add(event);
    }

    public Event[] eventsAt(int day) {
        EventList currentEvent = events;
        int count = 0;
        EventList currentEvent2 = events;
        int i = 0;

        if (events == null) return new Event[0];

        while (currentEvent != null) {
            if (currentEvent.getEvent().diff(day) == 0) {
                count++;
            }
            currentEvent = currentEvent.getNext();
        }
        Event[] resArr = new Event[count];
        while (currentEvent2 != null) {
            if (currentEvent2.getEvent().diff(day) == 0) {
                resArr[i] = currentEvent2.getEvent();
                i++;
            }
            currentEvent2 = currentEvent2.getNext();

        }
        return resArr;
    }

    public Event nextEvent(int day){
        if (events == null) return null;

        Event closest = null;
        EventList currEvent = events;
        int minDiff = Integer.MAX_VALUE;

        while (currEvent != null){
            int currDiff = currEvent.getEvent().diff(day);
            if(currDiff >=0 && currDiff < minDiff){
                closest = currEvent.getEvent();
                minDiff = currDiff;
            }

            currEvent = currEvent.getNext();
        }return closest;
    }
}
