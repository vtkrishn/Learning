import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Solution {

	static class UserService{
		String serviceName;
		Map<Integer, User> map = new HashMap<Integer, User>();
		List<UserService> service = new ArrayList<UserService>();

		public UserService(String serviceName) {
			this.serviceName=serviceName;
		}

		  public void addUser(User user) {
			  map.put(user.getId(), user);
			  for(UserService u : service) {
				  if(!u.map.containsKey(user.getId()))
					  u.addUser(user);
			  }
		  }

		  public void deleteUser(User user) {
			  map.remove(user.getId());
			  for(UserService u : service) {
				    u.deleteUser(user);
			  }
		  }

		  public List<User> getUsers() { return new ArrayList<User>(map.values()); }

		  public void registerListener(UserService userService) {
			    service.add(userService);
		  }

		  public void deregisterListener(UserService userService) {
			  service.remove(userService);
		  }

		  public String toString(){
			  return this.serviceName;
		  }

	}

	static class User{
		private String name;
		  private int id;

		  public User(String name, int id) {
		    this.name = name;
		    this.id = id;
		  }

		  public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String toString(){
		     return name +" "+ id;
		}

		@Override
		public boolean equals(Object obj) {
			return this.id == ((User)obj).id;
		}
	}

	public static void main(String[] args) {
    List<UserService> services = new ArrayList<>();
    Map<String, UserService> serviceLookup = new HashMap<>();
    Scanner scanner = new Scanner(System.in);
    int commands = scanner.nextInt();
    String serviceName, userName, serviceName1, serviceName2;
    int userId;
    UserService us, service1, service2;
    for (int c = 0; c < commands; c++) {
      String command = scanner.next();
      switch(command) {
        case "add":
          serviceName = scanner.next();
          userName = scanner.next();
          userId = scanner.nextInt();
          us = serviceLookup.get(serviceName);
          us.addUser(new User(userName, userId));
          break;
        case "delete":
          serviceName = scanner.next();
          userName = scanner.next();
          userId = scanner.nextInt();
          us = serviceLookup.get(serviceName);
          us.deleteUser(new User(userName, userId));
          break;
        case "service":
          serviceName = scanner.next();
          us = new UserService(serviceName);
          services.add(us);
          serviceLookup.put(serviceName, us);
          break;
        case "register":
          serviceName1 = scanner.next();
          serviceName2 = scanner.next();
          service1 = serviceLookup.get(serviceName1);
          service2 = serviceLookup.get(serviceName2);
          service1.registerListener(service2);
          break;
        case "deregister":
          serviceName1 = scanner.next();
          serviceName2 = scanner.next();
          service1 = serviceLookup.get(serviceName1);
          service2 = serviceLookup.get(serviceName2);
          service1.deregisterListener(service2);
          break;
      }
    }
    for (UserService s : services) {
      System.out.println("service " + s);
      for (User u : s.getUsers()) {
        System.out.println(u);
      }
    }
  }
}
