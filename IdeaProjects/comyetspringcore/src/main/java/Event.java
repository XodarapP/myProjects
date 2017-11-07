import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.Random;

public class Event {
    private int id;
    private String msg;
    private Date date;
    private DateFormat df;
    final Random random = new Random();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Event (Date date, DateFormat df){
        this.id = random.nextInt(10);
        this.date = date;
        this.df = df;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id= " + id +
                ", message= '"+ msg + '\'' +
                ", date= " + df.format(date) +
                '}';
    }

    public static boolean isDay(int start, int end) {
        LocalTime time = LocalTime.now();
        return time.getHour() > start && time.getHour() < end;
    }
}
