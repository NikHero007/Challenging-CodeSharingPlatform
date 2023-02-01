package platform;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "CodeNoRestrictions")
public class CodeNoRestrictions {
    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long ID;
    @Column(name = "Code")
    private String code;
    @Column(name = "Date")
    private String date;

    @Column(name = "Time")
    private int time;

    @Column(name = "Views")
    private int views;

    @JsonIgnore
    @Column(name = "UUID")
    private String uuid;


    @JsonIgnore
    @Transient
    private LocalDateTime localDateTime;
    @JsonIgnore
    @Transient
    private DateTimeFormatter dateTimeFormatter;

    public CodeNoRestrictions() {
        localDateTime = LocalDateTime.now();
        String DATE_FORMATTER = "yyyy/MM/dd HH:mm:ss";
        dateTimeFormatter = DateTimeFormatter.ofPattern(DATE_FORMATTER);
        this.date = localDateTime.format(dateTimeFormatter);
    }

    public CodeNoRestrictions(String code) {
        this.code = code;
        localDateTime = LocalDateTime.now();
        String DATE_FORMATTER = "yyyy/MM/dd HH:mm:ss";
        dateTimeFormatter = DateTimeFormatter.ofPattern(DATE_FORMATTER);
        this.date = localDateTime.format(dateTimeFormatter);
    }

    public CodeNoRestrictions(String code, int time, int views, String uuid) {
        this.code = code;
        this.time = time;
        this.views = views;
        this.uuid = uuid;
        localDateTime = LocalDateTime.now();
        String DATE_FORMATTER = "yyyy/MM/dd HH:mm:ss";
        dateTimeFormatter = DateTimeFormatter.ofPattern(DATE_FORMATTER);
        this.date = localDateTime.format(dateTimeFormatter);
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }


    public DateTimeFormatter getDateTimeFormatter() {
        return dateTimeFormatter;
    }

    public void setDateTimeFormatter(DateTimeFormatter dateTimeFormatter) {
        this.dateTimeFormatter = dateTimeFormatter;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    @JsonIgnore
    public String getUuid() {
        return uuid;
    }

    @JsonIgnore
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @JsonIgnore
    public Long getID() {
        return ID;
    }

    @JsonIgnore
    public void setID(Long ID) {
        this.ID = ID;
    }
}
