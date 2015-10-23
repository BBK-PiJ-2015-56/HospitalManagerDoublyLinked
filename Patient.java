  public class Patient {
	private String name;
	private int age;
	private String illness;
	private Patient next;
	private Patient previous;
	
	
	public Patient(String name, int age, String illness) {
		this.name = name;
		this.age = age;
		this.illness = illness;
		this.next = null;
		this.previous = null;
	}
	
	//addPatient method assumes there are already at least two in the list. 
	//It is only called from the 2nd patient onwards.
	public void addPatient(Patient newPatient){
		if(this.next == null){
			this.next = newPatient;
			this.next.previous = this.previous.next;
		}
		else{
			this.next.addPatient(newPatient);
		}
	}
	
	public boolean deletePatient(Patient patientToDelete){
		while((!(this.next == patientToDelete))&& !(this.next==null)){
			this.next.deletePatient(patientToDelete);
		}
		if (this.next ==null){
			System.out.println("This patient is not in the list");
			return false;
		}
		else{
			this.next = next.next;
			this.next.previous = this.previous.next;
			return true;
		}
	}
		







	/*public boolean deletePatient(Patient patientToDelete){
		if (this.next == null)
			return false;
		else{
			if (this.next.name.equals(patientToDelete.name)){
				this.next = next.next;
			    return true;
			}
			else{
				return this.next.deletePatient(patientToDelete);
			}
		
	    }
	
	}*/
		
	public void printThisPatientAndRecur(){
		System.out.println("This patient's name is " + this.name + ". There age is " + this.age +". There illness is " + this.illness + "."); 
        if (next == null)
			System.out.println ("End of List.");
		else
		    next.printThisPatientAndRecur();		                               
	}
		

	public String getName(){
		return name;
	}
	public Patient getNext(){
		return next;
	}
	public void setNext(Patient p){
		next = p;
	}
	public Patient getPrevious(){
		return previous;
	}
	public void setPrevious(Patient p){
		previous = p;
	}
	
} 