package model.entity;

import java.util.UUID;

public class User {
    private UUID id;
    private String email ;
    private String fullName;
    private String password;
    private String address;
    private Role role;
    private boolean enabled;
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(String role) {
        this.role = Role.fromString(role);
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
    
    

    // Getters and setters
    
}


enum Role {
	ADMIN("ADMIN"),
    LANDLORD("LANDLORD"),
    USER("USER");
	
	private final String role;

    Role(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
    public static Role fromString(String role) {
        for (Role userRole : Role.values()) {
            if (userRole.getRole().equalsIgnoreCase(role)) {
                return userRole;
            }
        }
        throw new IllegalArgumentException("Invalid role: " + role);
    }
}
