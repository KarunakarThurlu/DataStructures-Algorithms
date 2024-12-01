package solidprinciples;

//Without Open Closed Principle 
class NotificationService1 {
    public void send(String message, String type) {
        if (type.equals("EMAIL")) {
            System.out.println("Sending email: " + message);
        } else if (type.equals("SMS")) {
            System.out.println("Sending SMS: " + message);
        }
        //In feature if we want to add Push notification , we need to add one more else if  block (modifying NotificationService1 class)
    }
}


//With Open Closed Principle 
interface Notification {
    void send(String message);
}

class EmailNotification implements Notification {
    public void send(String message) {
        System.out.println("Sending email: " + message);
    }
}

class SMSNotification implements Notification {
    public void send(String message) {
        System.out.println("Sending SMS: " + message);
    }
}

class PushNotification implements Notification {
    public void send(String message) {
        System.out.println("Sending PushNotification: " + message);
    }
}

class NotificationService {
    public void notify(Notification notification, String message) {
        notification.send(message);
    }
}
public class OpenClosedPrinciple {

	public static void main(String[] args) {
		//Definition: Software entities (classes, modules, functions, etc.) should be open for extension but closed for modification.
		//Benefit: This allows the system to be extended with new functionality without modifying existing code, reducing the risk of bugs and regressions.
		//Example: You can add new types of notifications (email, SMS) to a system by extending an existing interface, rather than changing the existing code.
		
		Notification email = new EmailNotification();
		Notification sms = new SMSNotification();
		NotificationService service = new NotificationService();
		service.notify(email, "Hello!");
		service.notify(sms, "Hello!");
	}
}





