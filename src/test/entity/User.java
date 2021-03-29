package test.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;


@Entity
public class User {
    private long id;
    private String name;
    private Date birthday;
    private String sex;
    private String phone;
    private String occupation;
    private String remarks;



    @Id
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 20)
    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "birthday", nullable = false, length = 20)
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Basic
    @Column(name = "sex", nullable = false, length = 20)
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "phone", nullable = false, length = 20)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "occupation", nullable = false, length = 20)
    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    @Basic
    @Column(name = "remarks", nullable = false, length = 20)
    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public User(int id, String name, java.util.Date birthday, String sex, String phone, String occupation, String remarks) {
        super();
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.sex = sex;
        this.phone = phone;
        this.occupation = occupation;
        this.remarks = remarks;

    }

    public User(String name, Date date, String sex, String phone, String occupation, String remarks) {
        this.id = id;
        this.name = name;
        this.birthday = date;
        this.sex = sex;
        this.phone = phone;
        this.occupation = occupation;
        this.remarks = remarks;
    }
}
