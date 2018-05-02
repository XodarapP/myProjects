package dbService.dataSets;

import java.util.Date;

public class UsersDataSet {
    private long id;
    private String ipAddress;
    private Date dateTime;

    public UsersDataSet(long id, String ipAddress, Date dateTime) {
        this.id = id;
        this.ipAddress = ipAddress;
        this.dateTime = dateTime;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "UsersDataSet{" +
                "id=" + id +
                ", id ='" + id + '\'' +
                '}';
    }
}
