package net.wynsolutions;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Copyright (C) 2017  Sw4p
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 * @author Sw4p
 *
 */

@ManagedBean
@SessionScoped
public class LoginBean {

	 private String name;
	    private String password;


	    public String getName (){
	        return name;
	    }


	    public void setName (final String name){
	        this.name = name;
	    }


	    public String getPassword (){
	        return password;
	    }


	    public void setPassword (final String password){
	        this.password = password;
	    }
	    
	    public String login(){
	    	
	    	System.out.println("Logging in");
	    	
	    	return "login";
	    }
	
}
