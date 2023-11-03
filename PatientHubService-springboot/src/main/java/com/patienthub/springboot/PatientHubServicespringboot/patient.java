package com.patienthub.springboot.PatientHubServicespringboot;

public class patient {
	
	    private Long id;
	    private String name;
	    private int age;
	    private String gender;
	    // Getters and setters
	    // Constructors
	    // toString() method
       public patient(Long id, String name, int age, String gender) {
			super();
			this.id = id;
			this.name = name;
			this.age = age;
			this.gender = gender;
		}



		public Long getId() {
			return id;
		}



		public void setId(Long id) {
			this.id = id;
		}



		public String getName() {
			return name;
		}



		public void setName(String name) {
			this.name = name;
		}



		public int getAge() {
			return age;
		}



		public void setAge(int age) {
			this.age = age;
		}



		public String getGender() {
			return gender;
		}



		public void setGender(String gender) {
			this.gender = gender;
		}
		
		@Override
		public String toString() {
			return "patient [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + "]";
		}
	    


}
