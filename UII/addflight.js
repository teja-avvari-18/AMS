
function generateRandomId() {
    const characters = '123456789';
    let randomId = '';
    for (let i = 0; i < 6; i++) { 
        randomId += characters.charAt(Math.floor(Math.random() * characters.length));
    }
    return randomId;
}

document.getElementById('addFlightBtn').addEventListener('click', function() {
    const form = document.getElementById('flightForm');
    if (form.checkValidity()) {
        const randomId = generateRandomId(); 
        const successMessage = document.getElementById('successMessage');
        successMessage.innerHTML = `Flight Information Saved Successfully!!! - Flight Id generated is ${randomId}`;
    } else {
        form.reportValidity();
    }
});
