package model.entities;

import java.io.Serializable;

public class Week implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String timehour;	
	private String hourstart;
	private String hourend;
	private String sunday;
	private String monday;
	private String tuesday;
	private String fourth;
	private String fifth;
	private String friday;
	private String saturday;	
			
	public Week() {		
	}
		
	public Week(Integer id, String timehour, String hourstart, String hourend, String sunday, String monday, String tuesday, String fourth,
			String fifth, String friday, String saturday) {
		super();
		this.id = id;
		this.hourstart = hourstart;
		this.hourend = hourend;
		this.sunday = sunday;
		this.monday = monday;
		this.tuesday = tuesday;
		this.fourth = fourth;
		this.fifth = fifth;
		this.friday = friday;
		this.saturday = saturday;
		this.timehour = timehour;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTimehour() {
		return timehour;
	}

	public void setTimehour(String timehour) {
		this.timehour = timehour;
	}
	
	public String getHourstart() {
		return hourstart;
	}

	public void setHourstart(String hourstart) {
		this.hourstart = hourstart;
	}

	public String getHourend() {
		return hourend;
	}

	public void setHourend(String hourend) {
		this.hourend = hourend;
	}

	public String getSunday() {
		return sunday;
	}

	public void setSunday(String sunday) {
		this.sunday = sunday;
	}

	public String getMonday() {
		return monday;
	}

	public void setMonday(String monday) {
		this.monday = monday;
	}

	public String getTuesday() {
		return tuesday;
	}

	public void setTuesday(String tuesday) {
		this.tuesday = tuesday;
	}

	public String getFourth() {
		return fourth;
	}

	public void setFourth(String fourth) {
		this.fourth = fourth;
	}

	public String getFifth() {
		return fifth;
	}

	public void setFifth(String fifth) {
		this.fifth = fifth;
	}

	public String getFriday() {
		return friday;
	}

	public void setFriday(String friday) {
		this.friday = friday;
	}

	public String getSaturday() {
		return saturday;
	}

	public void setSaturday(String saturday) {
		this.saturday = saturday;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Week other = (Week) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	@Override
	public String toString() {		
		if(monday.equals("") && tuesday.equals("") && fourth.equals("")
				&& fifth.equals("") && friday.equals("") &&saturday.equals("")){			
			return id + " - " + timehour + " - " +  hourstart + " - " + hourend + 
					" - " + sunday;		
		}
		else if(sunday.equals("") && tuesday.equals("") && fourth.equals("")
				&& fifth.equals("") && friday.equals("") &&saturday.equals("")){
			return id + " - " + timehour + " - " +  hourstart + " - " + hourend + 
					" - " + monday;
		}
		else if(sunday.equals("") && monday.equals("") && fourth.equals("")
				&& fifth.equals("") && friday.equals("") &&saturday.equals("")) {
			return id + " - " + timehour + " - " +  hourstart + " - " + hourend + 
					" - " + tuesday;
		}
		else if(sunday.equals("") && monday.equals("") && tuesday.equals("")
				&& fifth.equals("") && friday.equals("") &&saturday.equals("")) {
			return id + " - " + timehour + " - " +  hourstart + " - " + hourend + 
					" - " + fourth;
		}
		else if(sunday.equals("") && monday.equals("") && tuesday.equals("")
				&& fourth.equals("") && friday.equals("") &&saturday.equals("")) {
			return id + " - " + timehour + " - " +  hourstart + " - " + hourend + 
					" - " + fifth;			
		}
		else if(sunday.equals("") && monday.equals("") && tuesday.equals("")
				&& fourth.equals("") && fifth.equals("") &&saturday.equals("")) {
			return id + " - " + timehour + " - " +  hourstart + " - " + hourend + 
					" - " + friday;			
		}
		else if(sunday.equals("") && monday.equals("") && tuesday.equals("")
				&& fourth.equals("") && fifth.equals("") && friday.equals("")) {
			return id + " - " + timehour + " - " +  hourstart + " - " + hourend + 
					" - " + saturday;			
		}else {
		
		return id + " - " + timehour + " - " +  hourstart + " - " + hourend + " - " + sunday
			+ " - " + monday + " - " + tuesday + " - " + fourth + " - " + fifth
			+ " - " + friday + " - " + saturday;	
		}	
	}
}
