package repos;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "UserForum")
@Table(name = "\"UserForum\"", schema = "public")
public class UserForum {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id_user;
	
	private String name;
	private String login; 
	private String email;
	private String password;
	private Date reg_data;
	private int karma;
	
	public UserForum() {
	}
	
	public UserForum(Integer id_user, String name, String login, String email, String password, Date reg_data, int karma) {
		this.id_user = id_user;
		this.name = name;
		this.login = login;
		this.email = email;
		this.password = password;
		this.reg_data = reg_data;
		this.karma = karma;
	}
	
	public Integer getId_user() {
		return id_user;
	}

	public void setId_user(Integer id_user) {
		this.id_user = id_user;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Date getReg_data() {
		return reg_data;
	}
	public void setReg_data(Date reg_data) {
		this.reg_data = reg_data;
	}
	
	public int getKarma() {
		return karma;
	}
	public void setKarma(int karma) {
		this.karma = karma;
	}

	@Override
	public String toString() {
		return "UserForum [id_user=" + id_user + ", name=" + name + ", login=" + login + ", email=" + email
				+ ", password=" + password + ", reg_data=" + reg_data + ", karma=" + karma + "]";
	}		
	
}
