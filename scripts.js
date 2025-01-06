// Scroll to Section
function scrollToSection(sectionId) {
    document.getElementById(sectionId).scrollIntoView({ behavior: 'smooth' });
}

// Filter Properties
function filterProperties() {
    const location = document.getElementById('search-location').value.toLowerCase();
    const cards = document.querySelectorAll('.property-card');

    cards.forEach(card => {
        const address = card.querySelector('h3').innerText.toLowerCase();
        card.style.display = address.includes(location) ? 'block' : 'none';
    });
}

// Load Properties
document.addEventListener('DOMContentLoaded', async () => {
    const propertyList = document.getElementById('property-list');
    const response = await fetch('http://localhost:8080/properties/list');
    const properties = await response.json();

    propertyList.innerHTML = ''; // Clear loading message
    properties.forEach(property => {
        const div = document.createElement('div');
        div.className = 'property-card';
        div.innerHTML = `
            <img src="https://via.placeholder.com/300x200" alt="Property Image">
            <h3>${property.propertyAddress}</h3>
            <p><strong>Owner:</strong> ${property.ownerName}</p>
            <p><strong>Lease Paper:</strong> ${property.leasePaper}</p>
            <button>Contact Owner</button>
        `;
        propertyList.appendChild(div);
    });
});
