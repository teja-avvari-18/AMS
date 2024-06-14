document.addEventListener('DOMContentLoaded', function() {
    const searchForm = document.getElementById('searchForm');
    if (searchForm) {
        searchForm.addEventListener('submit', function(event) {
            event.preventDefault(); 
            
           
            const origin = document.getElementById('origin').value;
            const destination = document.getElementById('destination').value;
            const departure = document.getElementById('departure').value;
            const travellers = document.getElementById('travellers').value;
            const travelClass = document.getElementById('class').value;
            
            
            window.location.href = 'bookflight.html';
        });
    } else {
        form.reportValidity();
    }
});
