package hibernate.dao;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "ChangingValues", schema = "dbo", catalog = "Spitter")
public class ChangingValuesEntity {
    private int id;
    private String oldValue;
    private String newValue;
    private String type;
    private Timestamp changingDateTime;

    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "OldValue", nullable = false, length = 50)
    public String getOldValue() {
        return oldValue;
    }

    public void setOldValue(String oldValue) {
        this.oldValue = oldValue;
    }

    @Basic
    @Column(name = "NewValue", nullable = false, length = 50)
    public String getNewValue() {
        return newValue;
    }

    public void setNewValue(String newValue) {
        this.newValue = newValue;
    }

    @Basic
    @Column(name = "Type", nullable = false, length = 50)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "ChangingDateTime", nullable = false)
    public Timestamp getChangingDateTime() {
        return changingDateTime;
    }

    public void setChangingDateTime(Timestamp changingDateTime) {
        this.changingDateTime = changingDateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ChangingValuesEntity that = (ChangingValuesEntity) o;

        if (id != that.id) return false;
        if (oldValue != null ? !oldValue.equals(that.oldValue) : that.oldValue != null) return false;
        if (newValue != null ? !newValue.equals(that.newValue) : that.newValue != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (changingDateTime != null ? !changingDateTime.equals(that.changingDateTime) : that.changingDateTime != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (oldValue != null ? oldValue.hashCode() : 0);
        result = 31 * result + (newValue != null ? newValue.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (changingDateTime != null ? changingDateTime.hashCode() : 0);
        return result;
    }
}
