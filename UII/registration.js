document.addEventListener("DOMContentLoaded", function() {
	const registrationForm = document.getElementById("registration-form");
	const acknowledgmentScreen = document.getElementById("acknowledgment-screen");
	const passengerIdElement = document.getElementById("passenger-id");
	const passwordElement = document.getElementById("password");
	
	registrationForm.addEventListener("submit", function(event) {
		event.preventDefault();
		const firstName = document.getElementById("firstName").value;
		const lastName = document.getElementById("lastName").value;
		const dob = document.getElementById("dob").value;
		const email = document.getElementById("email").value;
		const address = document.getElementById("address").value;
		const contactNumber = document.getElementById("contactNumber").value;
		
		if (!firstName ||!lastName ||!dob ||!email ||!address ||!contactNumber) {
			alert("All fields are mandatory.");
			return;
		}
		
		const dobDate = new Date(dob);
		if (dobDate < new Date("1924-01-01")) {
			alert("Choose a date greater than 1/1/1924");
			return;
		}
		
		if (contactNumber.length!== 10) {
			alert("Enter a valid contact number");
			return;
		}
		
		if (!validateEmail(email)) {
			alert("Enter a valid mail id");
			return;
		}
		
		const passengerId = generateRandomId();
		const password = firstName.substring(0, 4) + "@123";
		
		passengerIdElement.textContent = passengerId;
		passwordElement.textContent = password;
		
		acknowledgmentScreen.style.display = "block";
	});
	
	document.getElementById("reset").addEventListener("click", function(event) {
		if (confirm("Is it Okay to reset the fields?")) {
            acknowledgmentScreen.style.display = "none";
			document.getElementById("registration-form").reset();
           
		}
	});
});

function generateRandomId() {
	return Math.floor(Math.random() * 1000000);
}

function validateEmail(email) {
	const emailRegex = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
	return emailRegex.test(email);
}