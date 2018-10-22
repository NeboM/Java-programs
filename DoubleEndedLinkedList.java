package algorithms;

public class DoubleEndedLinkedList {
	User firstLink;
	User lastLink;
	
	public boolean isEmpty(){
		return firstLink == null;
	}
	public void insertInFirstPosition(String username, int age){
		User newUser = new User(username,age);
		// first of all check if the list is empty
		if(isEmpty()){
			lastLink = newUser;
		}else{
			firstLink.previous = newUser;
		}
		newUser.next = firstLink;
		firstLink = newUser;
	}
	
	public void insertInLastPosition(String username, int age){
		User newUser = new User(username,age);
		if(isEmpty()){
			firstLink = newUser;
		}else{
			lastLink.next = newUser;
			newUser.previous = lastLink;
		}
		lastLink = newUser;
	}
	
	public boolean insertAfterKey(String username, int age, User key){
		User newUser = new User(username,age);
		User focusUser = firstLink;
		while(!(focusUser.isSame(key))){
			focusUser = focusUser.next;
			if(focusUser == null){
				return false;
			}
		}
		if(focusUser == lastLink){
			lastLink = newUser;
		}else{
			newUser.next = focusUser.next;
			newUser.next.previous = newUser;
		}
		focusUser.next = newUser;
		newUser.previous = focusUser;
		
		return true;
	}
	
	public void displayList(){
		User focusUser = firstLink;
		while(focusUser != null){
			System.out.println(focusUser);
			focusUser = focusUser.next;
		}
	}
	
	public void displayBackwards(){
		User focusUser = lastLink;
		while(focusUser != null){
			System.out.println(focusUser);
			focusUser = focusUser.previous;
		}
	}
	
	public boolean removeLink(User link){
		User focusUser = firstLink;
		while(!focusUser.isSame(link)){
			focusUser = focusUser.next;
			if(focusUser == null){
				return false;
			}
		}
		if(focusUser.previous == null && focusUser.next == null){ // only 1 element
			firstLink = null;
			lastLink = null;
		}else if(focusUser.previous == null){ // beginning of the list
			firstLink = firstLink.next;
			firstLink.previous = null;
		}else if(focusUser.next == null){
			lastLink = lastLink.previous;
			lastLink.next = null;
		}else{
			focusUser.previous.next = focusUser.next;
			focusUser.next.previous = focusUser.previous;
		}
		return true;
	}
	
	public static void main(String [] args){
		DoubleEndedLinkedList theList = new DoubleEndedLinkedList();
		theList.insertInLastPosition("john123", 26);
		theList.insertInLastPosition("eddie01", 36);
		theList.insertInFirstPosition("marks", 52);
		theList.insertInLastPosition("bob1212",12);
		User afterKey = new User("bob1212",12);
		theList.insertAfterKey("INSERTME", 12, afterKey);
		theList.displayList();
		System.out.println();
		theList.displayBackwards();
	}
}

class User{
	public User previous;
	public User next;
	
	public String username;
	public int age;
	
	public User(String username, int age) {
		this.username = username;
		this.age = age;
	}
	public boolean isSame(User compare){
		if(username.equals(compare.username) && age == compare.age){
			return true;
		}else{
			return false;
		}
	}
	public String toString(){
		return username + " is " + age + " years old.";
	}
}
/* OUTPUT

marks is 52 years old.
john123 is 26 years old.
eddie01 is 36 years old.
bob1212 is 12 years old.
INSERTME is 12 years old.

INSERTME is 12 years old.
bob1212 is 12 years old.
eddie01 is 36 years old.
john123 is 26 years old.
marks is 52 years old.
*/
