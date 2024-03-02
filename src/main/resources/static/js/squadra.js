// Se vuoi utilizzare un percorso relativo per l'immagine, assicurati che sia corretto
  // Creare un elemento img
  var imgElement = document.createElement("img");

  // Impostare l'attributo alt vuoto (poiché è comune a tutte le squadre)
  imgElement.alt = "";

  // Ottieni il nome della squadra
  var squadraNome = document.getElementById("squadra-nome").textContent;
  // var squadraNome = document.querySelector("span[th:text='${squadra.nome}']").textContent;  DAVA ERRORE

  // Sostituisci gli spazi con trattini nei nomi delle squadre e trasforma tutto in minuscolo
  squadraNome = squadraNome.replace(/\s+/g, "-").toLowerCase();

  // Imposta il percorso dell'immagine in base alla squadra
  console.log(squadraNome);
  console.log("ora entro nell if");
  if (squadraNome === "milan") {
    console.log("entra dentro la 1 console");
    imgElement.src = "/img/milan.jpg";
  } else if (squadraNome === "roma") {
    imgElement.src = "/img/roma.jpg";
  } else if (squadraNome === "lazio") {
    console.log(squadraNome);
    imgElement.src = "/img/lazio.jpg";
  } else if (squadraNome === "napoli") {
    imgElement.src = "/img/napoli.jpg";
  } else if (squadraNome === "inter") {
    imgElement.src = "/img/inter.jpg";
  } else {
    // Se il nome della squadra non corrisponde a nessuna delle squadre conosciute, puoi gestire il fallback qui
  }

  // Seleziona il div "team-allenatore"
  var teamContainer = document.querySelector(".team-allenatore");

  // Aggiungi l'elemento img all'interno del div "team-allenatore"
  teamContainer.appendChild(imgElement);