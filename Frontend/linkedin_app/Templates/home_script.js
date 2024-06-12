// Function to fetch job offers from the server
async function obtenerOfertas() {
    try {
        const response = await fetch('/ofertas');
        if (response.ok) {
            const data = await response.json();
            mostrarOfertas(data);
        } else {
            throw new Error('Unable to fetch job offers');
        }
    } catch (error) {
        console.error('Error:', error);
    }
}

// Function to display job offers on the webpage
function mostrarOfertas(ofertas) {
    const listaOfertas = document.querySelector('.job-offers');
    listaOfertas.innerHTML = ''; // Clear job offers list
    if (ofertas.length > 0) {
        ofertas.forEach(oferta => {
            const ofertaElemento = document.createElement('li');
            ofertaElemento.classList.add('job-offer');
            ofertaElemento.innerHTML = `
                <h2>${oferta.titulo}</h2>
                <p>Empresa: ${oferta.empresa}</p>
                <p>Ciudad: ${oferta.ciudad}</p>
                <p>Descripción: ${oferta.descripcion}</p>
                <button onclick="aplicar(${oferta.id})">Apply</button>
            `;
            listaOfertas.appendChild(ofertaElemento);
        });
    } else {
        const noOfertas = document.querySelector('.no-offers');
        noOfertas.style.display = 'block';
    }
}

// Function to apply for a job offer
async function aplicar(ofertaId) {
    try {
        const response = await fetch('/aplicar', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ oferta_id: ofertaId })
        });
        if (response.ok) {
            const data = await response.json();
            console.log(data.message);
        } else {
            throw new Error('Unable to apply for the job offer');
        }
    } catch (error) {
        console.error('Error:', error);
    }
}

// Call the function to fetch job offers when the page is loaded
window.addEventListener('DOMContentLoaded', obtenerOfertas);
