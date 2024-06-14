
document.addEventListener('DOMContentLoaded', function() {
    const searchForm = document.getElementById('searchForm');
    const carrierSelect = document.getElementById('carrierSelect');
    const carrierDetails = document.getElementById('carrierDetails');
    const carrierForm = document.getElementById('carrierForm');
    const messageDiv = document.getElementById('message');

    searchForm.addEventListener('submit', function(event) {
        event.preventDefault();
        const selectedCarrier = carrierSelect.value;
        if (selectedCarrier) {
            
            const carrierData = {
                "Indigo": {
                    "60DaysAdvanceBooking": 10,
                    "90DaysAdvanceBooking": 15,
                    "BulkBooking": 20,
                    "SilverUser": 5,
                    "GoldUser": 10,
                    "PlatinumUser": 15,
                    "2DaysBeforeTravelDate": 50,
                    "10DaysBeforeTravelDate": 70,
                    "20DaysOrMoreBeforeTravelDate": 90
                },
                "Air India": {
                    "60DaysAdvanceBooking": 8,
                    "90DaysAdvanceBooking": 12,
                    "BulkBooking": 18,
                    "SilverUser": 4,
                    "GoldUser": 8,
                    "PlatinumUser": 12,
                    "2DaysBeforeTravelDate": 45,
                    "10DaysBeforeTravelDate": 65,
                    "20DaysOrMoreBeforeTravelDate": 85
                },
                "Vistara": {
                    "60DaysAdvanceBooking": 7,
                    "90DaysAdvanceBooking": 11,
                    "BulkBooking": 16,
                    "SilverUser": 3,
                    "GoldUser": 7,
                    "PlatinumUser": 11,
                    "2DaysBeforeTravelDate": 40,
                    "10DaysBeforeTravelDate": 60,
                    "20DaysOrMoreBeforeTravelDate": 80
                }
            };
            
            const data = carrierData[selectedCarrier];
            document.getElementById('carrierName').value = selectedCarrier;
            document.getElementById('60DaysAdvanceBooking').value = data["60DaysAdvanceBooking"];
            document.getElementById('90DaysAdvanceBooking').value = data["90DaysAdvanceBooking"];
            document.getElementById('BulkBooking').value = data["BulkBooking"];
            document.getElementById('SilverUser').value = data["SilverUser"];
            document.getElementById('GoldUser').value = data["GoldUser"];
            document.getElementById('PlatinumUser').value = data["PlatinumUser"];
            document.getElementById('2DaysBeforeTravelDate').value = data["2DaysBeforeTravelDate"];
            document.getElementById('10DaysBeforeTravelDate').value = data["10DaysBeforeTravelDate"];
            document.getElementById('20DaysOrMoreBeforeTravelDate').value = data["20DaysOrMoreBeforeTravelDate"];

            carrierDetails.style.display = 'block';
        }
    });

    document.getElementById('editCarrierBtn').addEventListener('click', function() {
        const carrierName = document.getElementById('carrierName').value;
        const data = {
            "60DaysAdvanceBooking": document.getElementById('60DaysAdvanceBooking').value,
            "90DaysAdvanceBooking": document.getElementById('90DaysAdvanceBooking').value,
            "BulkBooking": document.getElementById('BulkBooking').value,
            "SilverUser": document.getElementById('SilverUser').value,
            "GoldUser": document.getElementById('GoldUser').value,
            "PlatinumUser": document.getElementById('PlatinumUser').value,
            "2DaysBeforeTravelDate": document.getElementById('2DaysBeforeTravelDate').value,
            "10DaysBeforeTravelDate": document.getElementById('10DaysBeforeTravelDate').value,
            "20DaysOrMoreBeforeTravelDate": document.getElementById('20DaysOrMoreBeforeTravelDate').value
        };
        
        console.log(`Updated data for ${carrierName}:`, data);
        messageDiv.textContent = `${carrierName} details are updated successfully`;
    });

    document.getElementById('deleteCarrierBtn').addEventListener('click', function() {
        const carrierName = document.getElementById('carrierName').value;
        console.log(`Deleting carrier: ${carrierName}`);
        messageDiv.textContent = `Carrier details are removed from the system`;
        carrierDetails.style.display = 'none';
    });
});
