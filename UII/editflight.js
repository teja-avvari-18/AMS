

document.addEventListener('DOMContentLoaded', function() {
    const searchForm = document.getElementById('searchForm');
    const carrierSelect = document.getElementById('carrierSelect');
    const originSelect = document.getElementById('originSelect');
    const destinationSelect = document.getElementById('destinationSelect');
    const flightDetails = document.getElementById('flightDetails');
    const flightForm = document.getElementById('flightForm');
    const messageDiv = document.getElementById('message');

    searchForm.addEventListener('submit', function(event) {
        event.preventDefault();
        const selectedCarrier = carrierSelect.value;
        const selectedOrigin = originSelect.value;
        const selectedDestination = destinationSelect.value;

        if (selectedCarrier && selectedOrigin && selectedDestination) {
            
            const flightData = {
                "Indigo": {
                    "Mumbai-Delhi": {
                        "airFare": 5000,
                        "seatCapacityBusiness": 20,
                        "seatCapacityEconomy": 150,
                        "seatCapacityExecutive": 30
                    }
                },
                "Air India": {
                    "Delhi-Chennai": {
                        "airFare": 4500,
                        "seatCapacityBusiness": 15,
                        "seatCapacityEconomy": 140,
                        "seatCapacityExecutive": 25
                    }
                },
                "Vistara": {
                    "Hyderabad-Bengaluru": {
                        "airFare": 4000,
                        "seatCapacityBusiness": 18,
                        "seatCapacityEconomy": 130,
                        "seatCapacityExecutive": 28
                    }
                }
            };

            const routeKey = `${selectedOrigin}-${selectedDestination}`;
            const data = flightData[selectedCarrier] ? flightData[selectedCarrier][routeKey] : null;

            if (data) {
                document.getElementById('flightCarrierName').value = selectedCarrier;
                document.getElementById('flightOrigin').value = selectedOrigin;
                document.getElementById('flightDestination').value = selectedDestination;
                document.getElementById('airFare').value = data["airFare"];
                document.getElementById('seatCapacityBusiness').value = data["seatCapacityBusiness"];
                document.getElementById('seatCapacityEconomy').value = data["seatCapacityEconomy"];
                document.getElementById('seatCapacityExecutive').value = data["seatCapacityExecutive"];

                flightDetails.style.display = 'block';
            } else {
                flightDetails.style.display = 'none';
                messageDiv.textContent = 'No matching flight details found.';
                messageDiv.style.color = 'red';
            }
        }
    });

    document.getElementById('editFlightBtn').addEventListener('click', function() {
        const carrierName = document.getElementById('flightCarrierName').value;
        const data = {
            "origin": document.getElementById('flightOrigin').value,
            "destination": document.getElementById('flightDestination').value,
            "airFare": document.getElementById('airFare').value,
            "seatCapacityBusiness": document.getElementById('seatCapacityBusiness').value,
            "seatCapacityEconomy": document.getElementById('seatCapacityEconomy').value,
            "seatCapacityExecutive": document.getElementById('seatCapacityExecutive').value
        };
        
        console.log(`Updated data for flight of ${carrierName}:`, data);
        messageDiv.textContent = 'Flight Information Updated Successfully!!!';
        messageDiv.style.color = 'green';
    });

    document.getElementById('deleteFlightBtn').addEventListener('click', function() {
        const carrierName = document.getElementById('flightCarrierName').value;
        const origin = document.getElementById('flightOrigin').value;
        const destination = document.getElementById('flightDestination').value;
        
        console.log(`Deleting flight of ${carrierName} from ${origin} to ${destination}`);
        messageDiv.textContent = 'Flight details are removed Successfully!!!';
        messageDiv.style.color = 'green';
        flightDetails.style.display = 'none';
    });
});
