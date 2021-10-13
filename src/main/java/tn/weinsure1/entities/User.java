package tn.weinsure1.entities;


import org.hibernate.annotations.NaturalId;

import tn.weinsure1.entities.audit.DateAudit;
import tn.weinsure1.validation.annotation.NullOrNotBlank;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity(name = "USER")
public class User extends DateAudit {

    @Id
    @Column(name = "USER_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @SequenceGenerator(name = "user_seq", allocationSize = 1)
    private Long id;

    @NaturalId
    @Column(name = "EMAIL", unique = true)
    @NotBlank(message = "User email cannot be null")
    private String email;

    @Column(name = "USERNAME", unique = true)
    @NullOrNotBlank(message = "Username can not be blank")
    private String username;

    @Column(name = "PASSWORD")
    @NotNull(message = "Password cannot be null")
    private String password;

    @Column(name = "FIRST_NAME")
    @NullOrNotBlank(message = "First name can not be blank")
    private String firstName;

    
    @Column(name = "LAST_NAME")
    @NullOrNotBlank(message = "Last name can not be blank")
    private String lastName;

    @Column(name = "IS_ACTIVE", nullable = false)
    private Boolean active;

	
	@Temporal(TemporalType.DATE)
	@Column(name="Birthdate")
	private Date birthdate ;
	
	
	public Date getBirthdate() {
		return birthdate;
	}


	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}


	@Column(name="Phonenumber")
	private Long phonenumber ;
	
	@Column(name="Cin")
	private Long cin ;
	
	@Column(name="Salary")
	private Float salary ;


///////////////////////////////////////////////////////////////////


	
	@JsonIgnore
	@OneToMany(fetch = FetchType.EAGER, mappedBy="user", cascade = CascadeType.ALL)
	private List<sinister> sinisterList = new ArrayList<>();

/////////////////////////////////////////////////////////////////
@OneToMany(fetch = FetchType.LAZY, mappedBy="user")
@JsonIgnore
private List<Contract> contracts;
////////////////////////////////////////////////////////////
@ManyToMany(mappedBy = "users",fetch = FetchType.LAZY)
List<Offer> offers;
////////////////////////////////////////////////////////////////


@JsonIgnore
//@JsonBackReference
@OneToOne
@JoinColumn(name = "idcontraint",referencedColumnName="IDContraint")
private Contraint contraint;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "USER_AUTHORITY", joinColumns = {
            @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")}, inverseJoinColumns = {
            @JoinColumn(name = "ROLE_ID", referencedColumnName = "ROLE_ID")})
    private Set<Role> roles = new HashSet<>();

    @Column(name = "IS_EMAIL_VERIFIED", nullable = false)
    private Boolean isEmailVerified;

    public User() {
        super();
    }


    public void addRole(Role role) {
        roles.add(role);
        role.getUserList().add(this);
    }

    public void addRoles(Set<Role> roles) {
        roles.forEach(this::addRole);
    }

    public void removeRole(Role role) {
        roles.remove(role);
        role.getUserList().remove(this);
    }

    public void markVerificationConfirmed() {
        setEmailVerified(true);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> authorities) {
        roles = authorities;
    }

    public Boolean getEmailVerified() {
        return isEmailVerified;
    }

    public void setEmailVerified(Boolean emailVerified) {
        isEmailVerified = emailVerified;
    }
    public User(User user) {
        id = user.getId();
        username = user.getUsername();
        password = user.getPassword();
        firstName = user.getFirstName();
        lastName = user.getLastName();
        email = user.getEmail();
        active = user.getActive();
        roles = user.getRoles();
        isEmailVerified = user.getEmailVerified();
    }

	public Long getPhonenumber() {
		return phonenumber;
	}


	public void setPhonenumber(Long phonenumber) {
		this.phonenumber = phonenumber;
	}


	public Long getCin() {
		return cin;
	}


	public void setCin(Long cin) {
		this.cin = cin;
	}


	public Float getSalary() {
		return salary;
	}


	public void setSalary(Float salary) {
		this.salary = salary;
	}


	public List<sinister> getSinisterList() {
		return sinisterList;
	}


	public void setSinisterList(List<sinister> sinisterList) {
		this.sinisterList = sinisterList;
	}


	public List<Contract> getContracts() {
		return contracts;
	}


	public void setContracts(List<Contract> contracts) {
		this.contracts = contracts;
	}


	public List<Offer> getOffers() {
		return offers;
	}


	public void setOffers(List<Offer> offers) {
		this.offers = offers;
	}


	public Contraint getContraint() {
		return contraint;
	}


	public void setContraint(Contraint contraint) {
		this.contraint = contraint;
	}


	public Boolean getIsEmailVerified() {
		return isEmailVerified;
	}


	public void setIsEmailVerified(Boolean isEmailVerified) {
		this.isEmailVerified = isEmailVerified;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", username=" + username + ", password=" + password
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", active=" + active + ", birthdate="
				+ birthdate + ", phonenumber=" + phonenumber + ", cin=" + cin + ", salary=" + salary + ", roles="
				+ roles + ", isEmailVerified=" + isEmailVerified + "]";
	}
    
}


