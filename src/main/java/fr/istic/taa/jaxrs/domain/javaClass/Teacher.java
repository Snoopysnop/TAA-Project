package fr.istic.taa.jaxrs.domain.javaClass;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;

@Entity
public class Teacher extends User implements Serializable{

    Long id;
    List<DateTimeSlot> date_availability;


    protected Teacher() {}

    public Teacher(String firstName, String lastName) {
        super(firstName, lastName);
        this.date_availability = new ArrayList<>();
    }
    //peutetre à terme mettre une map pour les avaibility
    public void displayDisponibility(){
        for (DateTimeSlot dt : date_availability){
            
            List<TimeSlot> lt = dt.getTimeSlots();
            Calendar calendar = Calendar.getInstance();
	        calendar.setTime(dt.getDate());
            System.out.println("DATE : " + calendar.get(Calendar.DAY_OF_MONTH) + " " + (calendar.get(Calendar.MONTH)+1) + " " + calendar.get(Calendar.YEAR));
            for(TimeSlot ts : lt){
                System.out.println(ts.getStartHour() + ":" + ts.getStartMinute() + " -> " + ts.getEndHour() + ":" + ts.getEndMinute());
            }        
        }
    }

    private boolean isEqualDate(Date date1, Date date2){
        Calendar calendarDate1 = Calendar.getInstance();
        Calendar calendarDate2 = Calendar.getInstance();
        calendarDate1.setTime(date1);
        calendarDate2.setTime(date2);

        return (calendarDate1.get(Calendar.DAY_OF_MONTH) == calendarDate2.get(Calendar.DAY_OF_MONTH)
            && calendarDate1.get(Calendar.MONTH) == calendarDate2.get(Calendar.MONTH)
            && calendarDate1.get(Calendar.YEAR) == calendarDate2.get(Calendar.YEAR));
    }

    public boolean removeSlot(Date date, TimeSlot timeSlot) {
        for (DateTimeSlot dt : date_availability){
            if(isEqualDate(dt.getDate(), date)) {
                List<TimeSlot> timeSlotList = dt.getTimeSlots();
                List <TimeSlot> newTimeSlot = new ArrayList<>();

                for (TimeSlot ts : timeSlotList){
                    if(ts.isTimeSlotContainedInOtherTimeSlot(timeSlot)){
                        newTimeSlot = timeSlot.sliceTimeSlot(ts);
                        if(timeSlotList.remove(ts)){
                            for(TimeSlot element : newTimeSlot){
                            timeSlotList.add(element);
                            }
                            dt.setTimeSlots(timeSlotList);
                            return true;
                        }
                        return false;
                    }
                }
            }
        }
        return false;
    }
    public boolean addListTimeSlot(Date date, List<TimeSlot> timeSlots){
        for (TimeSlot timeSlot : timeSlots){
            if(!addTimeSlot(date,timeSlot)){return false;}
        }
        return true;
    }
    public boolean addTimeSlot(Date date, TimeSlot timeSlot) {  
        for (DateTimeSlot dt : date_availability){
            if(isEqualDate(dt.getDate(), date)) {
                for(TimeSlot ts : dt.getTimeSlots()) {
                    if(timeSlot.timeSlotOverlap(ts)) {
                        return false;
                    }
                }
                return dt.timeSlots.add(timeSlot);
            }
        }
        return date_availability.add(new DateTimeSlot(date, timeSlot));
    }

    

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Transient 
    public Map<Date, List<TimeSlot>> getAvailability() {
        Map<Date, List<TimeSlot>> m = new HashMap<>();
        for (DateTimeSlot dt : date_availability){
            m.put(dt.getDate(), dt.getTimeSlots());
        }
        return m;
    }


    @OneToMany
    @JoinColumn(name="teacherId")
    public List<DateTimeSlot> getDate_availability() {
        return date_availability;
    }

    public void setDate_availability(List<DateTimeSlot> date_availability) {
        this.date_availability = date_availability;
    }

}