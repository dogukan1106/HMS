import java.util.Scanner;
@SuppressWarnings("resource")

/*
 Proper Email
 Proper Password
 */



public class main {
	@SuppressWarnings("unused")
	
	public static void main(String[] args) {
		Management act = new Management();
		act.init();
		
		System.out.print("0. Log-in\n1. Add Doctor\n2. Remove Doctor\n3. Add User\n4. Remove User\n5. Make Appointment\nEnter -1 to terminate\n");
		System.out.print("Enter a number for action listed above : ");
		
		
		Scanner s = new Scanner(System.in);
		int n = getInput();
		
		
		while(n!=-1){
			String name;
			String departmentName;
			String email;
			String password;
			String passwordCheck;
			String tckn;
			int age;
			
			
			if(n == 0){
				do{
					System.out.print("Enter TCKN: ");
					tckn = getStrInput();
					System.out.print("Enter password: ");
					password = getStrInput();
				}while(!act.logIn(tckn, password));
			}
			else if(n == 1){//Add Doctor
				do{
					System.out.print("Enter Doctor's full name: ");
					name = getStrInput();
				}while(act.isDoctorExists(name, 1));
				
				System.out.print("Enter Doctor's age: ");
				age = getInput();
				
				do{
					System.out.print("Enter Doctor's Department name: ");
					departmentName = getStrInput();
				} while(!act.isInDepartments(departmentName));

				act.addDoctor(name, departmentName, age);
			}
			else if(n == 2){//Remove Doctor
				do{
					System.out.print("Enter Doctor's full name: ");
					name = getStrInput();
				}while(!act.isDoctorExists(name, 2));
				act.removeDoctor(name);
			}
			else if(n == 3){//Add User
				do{
					System.out.print("Enter your e-mail: ");
					email = getStrInput();
				}while(!act.checkEmail(email, 3));
				
				do{
					System.out.print("Enter your full name: ");
					name = getStrInput();
					System.out.print("Enter your age: ");
					age = getInput();
					System.out.print("Enter password: ");
					password = getStrInput();
					System.out.print("Re-enter password: ");
					passwordCheck = getStrInput();
					if(!password.equals(passwordCheck))
						System.out.print("Passwords does not match.\n ");
					//if(checkPassword(password))
						//System.out.print("Enter proper password.\n ");
				}while(!password.equals(passwordCheck));
				act.addUser(email, password);
				act.addPatient(name, age);
				
			}
			else if(n == 4){//Remove User
				do{
					System.out.print("Enter user's e-mail: ");
					email = getStrInput();
				}while(!act.checkEmail(email, 4));
				act.removePatient(act.getPatientID(email));
				act.removeUser(email);
			}
			else if(n == 5){//Make Appointment
				
			}
			System.out.print("Enter a number for action listed above : ");
			n = getInput();
		}
		System.out.println("Program Terminated.");
	}
	
	
	
	
	
	
	
	
	
	
	
	public static int getInput(){
		Scanner input = new Scanner(System.in);
		while (!input.hasNextInt()) {
		      System.out.println("Input is not a number.");
		      input.nextLine();
		}
		int n = input.nextInt();
		return n;
	}
	
	public static String getStrInput(){
		Scanner input = new Scanner(System.in);
		String line = input.nextLine();
		return line;
	}
	
	/*
	public static boolean checkPassword(String password){
		
		return true;
	}
	*/
}

