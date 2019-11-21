package com.fotra.database.entities;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonProperty;

@Entity
@Table(name = "\"ResetPassword\"", schema = "public")
public class PasswordReset {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_password;
	
	@JsonProperty("token")
    private String token;

    private int user_var;

    private Date expiry_date;
    
    public PasswordReset() {
	}

    public PasswordReset(Integer id_password, String token, int user, Date expiry_date) {
		this.id_password = id_password;
		this.token = token;
		this.user_var = user;
		this.expiry_date = expiry_date;
	}

	public Integer getId() {
        return id_password;
    }

    public void setId(Integer id) {
        this.id_password = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getUser() {
        return user_var;
    }

    public void setUser(int user) {
        this.user_var = user;
    }

    public Date getExpiryDate() {
        return expiry_date;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiry_date = expiryDate;
    }

    public void setExpiryDate(int minutes){
        Calendar now = Calendar.getInstance();
        now.add(Calendar.MINUTE, minutes);
        this.expiry_date = now.getTime();
    }

    public boolean isExpired() {
        return new Date().after(this.expiry_date);
    }

}
