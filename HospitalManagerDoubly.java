public class HospitalManagerDoubly{
	private Patient patientListStart = null;    
	//creates and points to a first patient space in memory, but this space doesn't point to any values for the patient (ie null)
	public static void main(String[] args) {
		HospitalManagerDoubly hm = new HospitalManagerDoubly();
		//this creates the object hm - no constructor class so it just creates a super object of the type HospitalManager.
		hm.launch();
	}
	
	
	//we have a launch method that creates the first patient and then points the starter object "patientListStart" to it.
	public void launch(){
		Patient firstPatient = new Patient("John", 33, "Tuberculosis");
		patientListStart = firstPatient;
	
		Patient secondPatient = new Patient("simon", 56, "Meningitis");
		patientListStart.addPatient(secondPatient);
	
		Patient thirdPatient = new Patient("James", 16, "broken leg");
		patientListStart.addPatient(thirdPatient);
	
		Patient fourthPatient = new Patient("Catherine", 32, "flu");
		patientListStart.addPatient(fourthPatient);
	
	
	
		patientListStart.addPatient(new Patient("Pedro", 34, "confused about Java (but enjoying it)"));
		
		patientListStart.printThisPatientAndRecur();                  
		
		deletePatientIncludingFirst(thirdPatient); 
		
		
		patientListStart.printThisPatientAndRecur();
		
		
		deletePatientIncludingFirst(firstPatient);
		patientListStart.printThisPatientAndRecur();
	}
	private boolean deletePatientIncludingFirst(Patient patientToDelete){
		if (patientListStart.getName().equals(patientToDelete.getName())){ 
		            //the above line definitely works
			patientListStart = patientListStart.getNext();
 			        //this doesn't seem to be deleting patientListStart!
			return true;
		}
		else{
			return patientListStart.deletePatient(patientToDelete);
		}
		
	}
	
	
	private void addPatient(Patient patientToAdd){
		if (patientListStart == null){
			patientListStart = patientToAdd;
		}
		if (patientListStart.getNext() == null){
			patientListStart.setNext(patientToAdd);
			patientToAdd.setPrevious(patientListStart);
		}
		else{
			patientListStart.getNext().addPatient(patientToAdd);
		}
	}
	
	private boolean deletePatient(Patient patientToDelete){
		if (patientToDelete.getName().equals(patientListStart.getName())){
			patientListStart = patientListStart.getNext();
			return true;
		}
	
		else
			return patientListStart.deletePatient(patientToDelete);
	}
	
	/*private boolean deletePatientIncludingFirst(Patient patientToDelete){
		if (patientListStart.getName().equals(patientToDelete.getName())){ 
		            //the above line definitely works
			patientListStart = patientListStart.getNext();
 			        //this doesn't seem to be deleting patientListStart!
			return true;
		}
		else{
			return patientListStart.deletePatient(patientToDelete);
		}  */
			
}