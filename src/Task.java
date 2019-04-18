
public class Task {

	private int priority;
	private String description;
	private String dueDate;
	private int status;
	
	private String startDate;
	private String endDate;
	
	enum status{
		
		NotStarted, InProgress, Finished;
		
	}
}
