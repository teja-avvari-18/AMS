

// Get the profile details from local storage or a database
const profileDetails = {
    firstName: 'John',
    lastName: 'Doe',
    dob: '1990-01-01',
    email: 'johndoe@example.com',
    address: '123 Main St',
    contactNumber: '1234567890'
  };
  
  // Display the profile details
  document.getElementById('firstName-display').textContent = profileDetails.firstName;
  document.getElementById('lastName-display').textContent = profileDetails.lastName;
  document.getElementById('dob-display').textContent = profileDetails.dob;
  document.getElementById('email-display').textContent = profileDetails.email;
  document.getElementById('address-display').textContent = profileDetails.address;
  document.getElementById('contactNumber-display').textContent = profileDetails.contactNumber;
  
  // Add event listener to the edit button
  document.getElementById('edit-button').addEventListener('click', () => {
    document.getElementById('profile-details').style.display = 'none';
    document.getElementById('edit-form').style.display = 'block';
  });
  
  // Add event listener to the save button
  document.getElementById('save-button').addEventListener('click', () => {
    // Get the updated values from the edit form
    const updatedProfileDetails = {
      firstName: document.getElementById('firstName-edit').value,
      lastName: document.getElementById('lastName-edit').value,
      dob: document.getElementById('dob-edit').value,
      email: document.getElementById('email-edit').value,
      address: document.getElementById('address-edit').value,
      contactNumber: document.getElementById('contactNumber-edit').value
    };
  
    // Update the profile details in local storage or a database
    //...
  
    // Display the updated profile details
    document.getElementById('firstName-display').textContent = updatedProfileDetails.firstName;
    document.getElementById('lastName-display').textContent = updatedProfileDetails.lastName;
    document.getElementById('dob-display').textContent = updatedProfileDetails.dob;
    document.getElementById('email-display').textContent = updatedProfileDetails.email;
    document.getElementById('address-display').textContent = updatedProfileDetails.address;
    document.getElementById('contactNumber-display').textContent=updatedProfileDetails.contactNumber;

  });