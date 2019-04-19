public class Task {

	private Integer priority;
	private String description;
	private String dueDate;
	private String status;
	private String startDate;
	private String endDate;
	
	public Task(int priority, String description, String dueDate, String status, String startDate, String endDate) {
		
		this.priority = priority;
		this.description = description;
		this.dueDate = dueDate;
		this.status = status;
		this.startDate = startDate;
		this.endDate = endDate;
		
		}	
	
	public Integer getPriority() {
		return priority;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDueDate() {
		return dueDate;
	}
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
}