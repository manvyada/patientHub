package com.patienthub.springboot.PatientHubServicespringboot;

public class patientResource {
	
	    private Long id;
	    private String resourceName;
	    // Getters and setters
	    // Constructors
	    // toString() method
		public patientResource(Long id, String resourceName) {
			super();
			this.id = id;
			this.resourceName = resourceName;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getResourceName() {
			return resourceName;
		}
		public void setResourceName(String resourceName) {
			this.resourceName = resourceName;
		}
		@Override
		public String toString() {
			return "patientResource [id=" + id + ", resourceName=" + resourceName + "]";
		}
	    
}
