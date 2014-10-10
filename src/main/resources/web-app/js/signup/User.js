function User(formData) {
	this.id = User.findFormValue(formData, "id");
	this.firstName = User.findFormValue(formData, 'first_name');
	this.lastName = User.findFormValue(formData, 'last_name');
	this.email = User.findFormValue(formData, 'email');
	this.precinct = parseInt(User.findFormValue(formData, 'precinct'));
	this.contactEmail = User.findFormValue(formData, 'contactemail');
	this.contactSMS = User.findFormValue(formData, 'contactsms');
	this.alphaCode = User.findFormValue(formData, 'alphacode');
	this.state = "Texas";
	this.county = "Travis";
}

User.findFormValue = function(formData, fieldName) {
	for (var idx in formData) {
		if (formData[idx].name == fieldName) return formData[idx].value;
	}
	return null;
};

User.prototype.postBody = function() {
	return {
		firstName: this.firstName,
		lastName: this.lastName,
		email: this.email,
		state: this.state,
		county: this.county,
		precinct: this.precinct,
		emailReminder: this.contactEmail != "",
		smsReminder: this.contactSMS != "",
		smsNumber: (this.contactSMS != "") ? this.contactSMS : ""
	};
};

User.fromJson = function(json) {
	var user = new User();
	user.id = json.id;
	user.firstName = json.firstName;
	user.lastName = json.lastName;
	user.email = json.email;
	user.precinct = json.precinct;
	user.contactEmail = json.contactEmail;
	user.contactSMS = json.contactSMS;
	return user;
}