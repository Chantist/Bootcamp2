
class Person {
	String recipient;
	String gifter;
	String name;
	
	Person(String name) {
		this.setName(name);
	}
	
	private String getRecipient() {
		return recipient;
	}
	void setRecipient(String recipient) {
		this.recipient = recipient;
	}
	String getGifter() {
		return gifter;
	}
	void setGifter(String gifter) {
		this.gifter = gifter;
	}

	String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}
	
	

}
