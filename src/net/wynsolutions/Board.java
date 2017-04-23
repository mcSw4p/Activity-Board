package net.wynsolutions;

import java.io.IOException;
import java.net.Inet4Address;
import java.util.HashMap;
import java.util.SortedSet;
import java.util.TreeSet;

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
public class Board {

	private String name, code = "";
	private HashMap<String, String> items;
	
	public Board() {
		
		items = new HashMap<String, String>();
		
		for(int i = 10; i < 33; i++){
			items.put("192.168.68.1" + i, getImageValue("192.168.68.1" + i));
		}
	
		populate();
	}
	
	public void populate(){
		
		System.out.println("Doing it.");
		
		SortedSet<String> keys = new TreeSet<String>(items.keySet());
		String str = "<table cellspacing=\"20\" cellpadding=\"50\" style=\";margin: 0 auto;\">\n " +
				"<thead> \n<tr><th colspan=\"7\" scope=\"colgroup\" style=\"font-size: 60px;text-decoration: underline;\">" +
				"Activity Board</th></tr></thead><tbody>";
		
		int col = 0, tot = 0;
		for(String s : keys){
			
			
			if(col == 0){
				str += "<tr>\n";
			}
			
			if(col < 7){
				str += "<td style=\"text-align: center;color: black;font-size: 24px;background-color: #eae672;width: 100px;height: 120px;box-shadow: 10px 20px 70px black;\">" +
						s + "<br/>" + 
						"<img src=\"" + items.get(s) +"\" alt=\"LED\" width=\"70\" height=\"70\"/></td>\n"; 
				
			}
			
			if(col == 7 || tot == (items.size() - 1)){
				col = 0;
				str += "</tr>\n";
			}else{
				col++;
				tot++;
			}
			
		}
		
		str += "</tbody>\n</table>\n";
		
		/*String str = "<h:panelGrid columns=\"7\" cellspacing=\"20\" cellpadding=\"50\" headerClass=\"gridHeader\" styleClass=\"grid\">\n"
				+ "<f:facet name=\"header\">\n<h:outputLabel value=\"Activity Board\" style=\"font-size: 60px; text-decoration: underline;\" />\n</f:facet>\n";
		
		for(String s : items.keySet()){
			str += "<h:panelGroup styleClass=\"node\">\n" +
					"<h:outputLabel value=\"" + s + "\" style=\"text-align: center; font-weight: bold; font-size: 25px;\"/>\n" + 
					"<br/>\n" + 
					"<h:graphicImage value=\"http://i.imgur.com/qFr34Y7.png\" height=\"50\" width=\"50\"/>\n" +
					"</h:panelGroup>\n";
		}
		
		str += "</h:panelGrid>\n";*/
		
		code = str;
	}

	private String getImageValue(String ip){
		
		try {
			if(Inet4Address.getByName(ip).isReachable(15)){
				return "http://i.imgur.com/UfEdTQJ.png";
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "http://i.imgur.com/AnEFlRE.png";
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @return the items
	 */
	public HashMap<String, String> getItems() {
		return items;
	}
	
}
