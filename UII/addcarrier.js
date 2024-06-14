

function generateRandomId() {
    const characters = '123456789';
    let randomId = '';
    for (let i = 0; i < 6; i++) { 
        randomId += characters.charAt(Math.floor(Math.random() * characters.length));
    }
    return randomId;
}




document.getElementById('addCarrierBtn').addEventListener('click', function() {
    const requiredFields = [
        document.getElementById('30DaysAdvanceBooking'),
        document.getElementById('60DaysAdvanceBooking'),
        document.getElementById('90DaysAdvanceBooking'),
        document.getElementById('BulkBooking'),
        document.getElementById('SilverUser'),
        document.getElementById('GoldUser'),
        document.getElementById('PlatinumUser'),
        document.getElementById('2DaysBeforeTravelDate'),
        document.getElementById('10DaysBeforeTravelDate'),
        document.getElementById('20DaysOrMoreBeforeTravelDate')
    ];

    let allValid = true;
    requiredFields.forEach(function(field) {
        if (!field.checkValidity()) {
            allValid = false;
        }
    });

    if (allValid) {
        const randomId = generateRandomId(); 
        const successMessage = document.getElementById('successMessage');
        successMessage.innerHTML = `Carrier Information Saved Successfully!!! - Carrier Id generated is ${randomId}`;
    } else {
        requiredFields.forEach(function(field) {
            field.reportValidity();
        });
    }
});
