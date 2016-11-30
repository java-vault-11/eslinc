package com.linctronix.event;

public class Message {
	private String time;
	private String issuer;
	private String source;
	private String category;
	private String target;
	private Integer percentage;
	
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getIssuer() {
		return issuer;
	}
	public void setIssuer(String issuer) {
		this.issuer = issuer;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public Integer getPercentage() {
		return percentage;
	}
	public void setPercentage(Integer percentage) {
		this.percentage = percentage;
	}
	
	@Override
	public String toString() {
		return this.getClass().getName() + ": {"
				+ "time: " + this.getTime()
				+ ", issuer: " + this.getIssuer()
				+ ", source: " + this.getSource()
				+ ", category: " + this.getCategory()
				+ ", target: " + this.getTarget()
				+ ", percentage: " + this.getPercentage()
				+ "}";
	}
}
