// Inizializza il budget dalla memoria locale (localStorage)
var budgetElement = document.getElementById("budget");
var budgetText = localStorage.getItem("budget");
var budgetText = budgetElement.textContent;
console.log(budgetText);
var budget = parseFloat(budgetText) || 10000000000;
// var budget = parseFloat(budgetText.replace(',', '.'));


console.log(budget)
var cartCount = 0;
var spesaTotale = 0;

// Aggiorna il budget nella memoria locale (localStorage)
function updateBudget(price) {
    budget -= parseFloat(price);
    if (budget < 0) {
        budget = 0; // Impediamo al budget di diventare negativo
    }
    document.getElementById('budget').textContent = formatCurrency(budget);

    // Salva il budget nella memoria locale
    localStorage.setItem("budget", budget.toString());
}

// Funzione per aggiornare la spesa totale
function updateSpesaTotale(price) {
    spesaTotale += parseFloat(price);
    document.getElementById('spesaTotale').textContent = formatCurrency(spesaTotale);
}

// Funzione per formattare il valore del budget in una stringa con il simbolo dell'euro
function formatCurrency(value) {
    return new Intl.NumberFormat('it-IT', { style: 'currency', currency: 'EUR' }).format(value);
}


document.addEventListener('DOMContentLoaded', function () {
    var purchaseButtons = document.querySelectorAll('.purchaseButton');
    purchaseButtons.forEach(function (button) {
        button.addEventListener('click', function () {
            aggiungi();
        });
    });



    var removeButtons = document.querySelectorAll('.removeButton');
    removeButtons.forEach(function (button) {
        button.addEventListener('click', function () {
            rimuovi();
        });
    });

    var restituisciButton = document.querySelectorAll(".restituisciButton");
restituisciButton.forEach(function(button) {
    button.addEventListener("click", function() {
        const calciatoreRow = this.closest("tr");
        recupera(calciatoreRow);
    });
});
    var sellButtons = document.querySelectorAll(".sellButton");
    sellButtons.forEach(function(button) {
        button.addEventListener("click", function() {
            const calciatoreRow = this.closest("tr");
            vendi(calciatoreRow);
        });
    });
});


function aggiungi() {
    var row = event.target.closest('tr');
    var priceString = row.querySelector('.costo').textContent;
    console.log('Price String:', priceString); // Aggiungi questo per il debug
    var price = parseFloat(priceString.replace(/\./g, '').replace(',', '.')); // Converte la stringa in un numero
    console.log('Parsed Price:', price); // Aggiungi questo per il debug

    if (budget >= price) {
        updateBudget(price); // Aggiorna il budget solo se c'è abbastanza denaro
        updateSpesaTotale(price); // Aggiorna la spesa totale
        cartCount++;
        document.getElementById('cartCount').textContent = cartCount; // Aggiorna il contatore del carrello
    } else {
        alert('Budget insufficiente per l\'acquisto');
    }
}


function rimuovi() {
    var row = event.target.closest('tr');
    var priceString = row.querySelector('.costo').textContent;
    console.log('Price String:', priceString); // Aggiungi questo per il debug
    var price = parseFloat(priceString.replace(/\./g, '').replace(',', '.')); // Converte la stringa in un numero
    console.log('Parsed Price:', price); // Aggiungi questo per il debug


    if (cartCount > 0) {
        var newBudget = budget - price;
        var newSpesaTotale = spesaTotale - price;

        // Assicurati che il budget e la spesa totale non diventino negativi
        if (newSpesaTotale >= 0) {
            updateBudget(-price);
            updateSpesaTotale(-price);
            cartCount--;
            document.getElementById('cartCount').textContent = cartCount;
        }
    } else {
        alert('Non è possibile rimuovere ulteriormente dal carrello.');
    }



}

function svuotaCarrello() {
    budget += spesaTotale;
    cartCount = 0;
    spesaTotale = 0;
    updateBudget(0); // Aggiorna il budget
    updateSpesaTotale(0); // Aggiorna la spesa totale
    document.getElementById('budget').textContent = formatCurrency(budget);
    document.getElementById('spesaTotale').textContent = formatCurrency(spesaTotale);
    document.getElementById('cartCount').textContent = cartCount; // Aggiorna il contatore del carrello
    console.log(budget);
}

function acquistaTutto() {
    cartCount = 0;
    spesaTotale = 0;
    updateSpesaTotale(0); // Aggiorna la spesa totale
    document.getElementById('spesaTotale').textContent = formatCurrency(spesaTotale);
    document.getElementById('cartCount').textContent = cartCount; // Aggiorna il contatore del carrello
    alert("Acquisti completati con successo");
    window.location.reload(true);
}


function vendi(calciatoreRow) {
    var costo = parseFloat(calciatoreRow.querySelector('.costo').textContent);
    updateBudget(-costo);

    calciatoreRow.querySelector('.sellButton').disabled = true;
    calciatoreRow.querySelector('.restituisciButton').disabled = false;
}


/FUNZIONE RECUPERA/
function recupera(calciatoreRow) {
    var costo = parseFloat(calciatoreRow.querySelector('.costo').textContent);
    updateBudget(costo);

    calciatoreRow.querySelector('.restituisciButton').disabled = true;
    calciatoreRow.querySelector('.sellButton').disabled = false;
}

// Inizializza il budget e la spesa totale nella pagina
document.getElementById('budget').textContent = formatCurrency(budget);
document.getElementById('spesaTotale').textContent = formatCurrency(spesaTotale);

