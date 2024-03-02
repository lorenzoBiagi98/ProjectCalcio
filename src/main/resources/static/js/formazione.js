// Aggiungi la funzione hideContent
function hideContent(option) {
  const formationGrid = document.getElementById('formationGrid');
  const players = formationGrid.getElementsByClassName('formation-player');


  // Nascondi tutti i giocatori
  Array.from(players).forEach(player => {
      player.style.opacity = 0;
      player.style.pointerEvents = 'none';
      player.style.backgroundColor = '';
  
  });

  // Mostra solo i giocatori con la classe corrispondente all'opzione selezionata
const optionPlayers = formationGrid.getElementsByClassName(option);
Array.from(optionPlayers).forEach(player => {
  player.style.opacity = 1;
  player.style.pointerEvents = 'auto';
});

// Rendi il background grigio per il player con la classe 'portiere'
const portierePlayer = formationGrid.getElementsByClassName('portiere')[0];
if (portierePlayer) {
  portierePlayer.style.backgroundColor = 'gray';
}

  // // Mostra solo i giocatori con la classe 'option1'
  // const option1Players = formationGrid.getElementsByClassName('option1');
  // const option2Players = formationGrid.getElementsByClassName('option2');
  // const option3Players = formationGrid.getElementsByClassName('option3');
  // Array.from(option1Players).forEach(player => {
  //     player.style.opacity = 1;
  //     player.style.pointerEvents = 'auto';
  // });
  // Array.from(option2Players).forEach(player => {
  //     player.style.opacity = 1;
  //     player.style.pointerEvents = 'auto';
  // });

  // Array.from(option3Players).forEach(player => {
  //     player.style.opacity = 1;
  //     player.style.pointerEvents = 'auto';
  // });

  // Rendi il background grigio per il player con la classe 'portiere1'
  // const portiere1Player = formationGrid.getElementsByClassName('portiere1')[0];
  // const portiere2Player = formationGrid.getElementsByClassName('portiere2')[0];
  // const portiere3Player = formationGrid.getElementsByClassName('portiere3')[0];

  // if (portiere1Player) {
  //     portiere1Player.style.backgroundColor = 'gray';
  // } else if (portiere2Player) {
  //     portiere2Player.style.backgroundColor = 'gray';
  // } else if (portiere3Player) {
  //     portiere3Player.style.backgroundColor = 'gray';
  // }
}