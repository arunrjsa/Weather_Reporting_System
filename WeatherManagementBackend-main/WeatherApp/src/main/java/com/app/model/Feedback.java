package com.app.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="feedbackdata")

public class Feedback {
	@Id
	private String dailyweather;
	private String friendliness;
	private String usefulness;
	private String comment;
	private String overallexperience;
	
	
	@Override
	public int hashCode() {
		return Objects.hash(comment, dailyweather, friendliness, overallexperience, usefulness);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Feedback other = (Feedback) obj;
		return Objects.equals(comment, other.comment) && Objects.equals(dailyweather, other.dailyweather)
				&& Objects.equals(friendliness, other.friendliness)
				&& Objects.equals(overallexperience, other.overallexperience)
				&& Objects.equals(usefulness, other.usefulness);
	}
	public String getDailyweather() {
		return dailyweather;
	}
	public void setDailyweather(String dailyweather) {
		this.dailyweather = dailyweather;
	}
	public String getFriendliness() {
		return friendliness;
	}
	public void setFriendliness(String friendliness) {
		this.friendliness = friendliness;
	}
	public String getUsefulness() {
		return usefulness;
	}
	public void setUsefulness(String usefulness) {
		this.usefulness = usefulness;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getOverallexperience() {
		return overallexperience;
	}
	public void setOverallexperience(String overallexperience) {
		this.overallexperience = overallexperience;
	}
	
	

}
