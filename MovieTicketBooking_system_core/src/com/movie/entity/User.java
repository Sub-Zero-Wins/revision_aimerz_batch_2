package com.movie.entity;

public class User {
	
	    String username;
	    String password;
	    boolean isAdmin;

	    public User(String username, String password, boolean isAdmin) {
	        this.username = username;
	        this.password = password;
	        this.isAdmin = isAdmin;
	    }

		public User() {
			super();
			// TODO Auto-generated constructor stub
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

		public boolean isAdmin() {
			return isAdmin;
		}

		public void setAdmin(boolean isAdmin) {
			this.isAdmin = isAdmin;
		}

		@Override
		public String toString() {
			return "User [username=" + username + ", password=" + password + ", isAdmin=" + isAdmin + "]";
		}
	    
	    
	    
	}