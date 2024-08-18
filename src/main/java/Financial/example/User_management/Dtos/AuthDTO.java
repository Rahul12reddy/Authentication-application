package Financial.example.User_management.Dtos;

import jakarta.persistence.Column;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class AuthDTO {
    int userid;
    String first_name;
    String last_name;
    Date dob;
    String gender;
    String email;
    String Password;

    public AuthDTO() {
    }

    public AuthDTO(int userid, String first_name, String last_name, Date dob, String gender, String email, String password) {
        this.userid = userid;
        this.first_name = first_name;
        this.last_name = last_name;
        this.dob = dob;
        this.gender = gender;
        this.email = email;
        Password = password;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
