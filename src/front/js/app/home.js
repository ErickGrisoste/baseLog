const funcionarioId = localStorage.getItem("funcionarioId");
console.log(funcionarioId);

let nome, email, cargo;


fetch("http://localhost:8080/funcionario/buscar/" + funcionarioId)
    .then(response => response.json())
    .then(data => {
        nome = data.nome;
        email = data.email;
        cargo = data.cargo;
    })
    .catch(error => {
        console.log("Erro");
    });

function toggleCard() {
  const card = document.getElementById("cardUsuario");
  const button = document.getElementById("botaoUser");
  const cardContainer = document.querySelector(".user-container");

  const titulo = card.querySelector('h3');
  const paragrafos = card.querySelectorAll('p');

  titulo.textContent = nome;
  paragrafos[0].textContent = 'Email: ' + email;
  paragrafos[1].textContent = 'Cargo: ' + cargo;

  card.classList.toggle("hidden");

  if (!card.classList.contains("hidden")) {
    // Pega a posição do botão
    const btnRect = button.getBoundingClientRect();
    const cardWidth = card.offsetWidth;
    const windowWidth = window.innerWidth;

    // Calcula a posição horizontal (left)
    let left = btnRect.left;

    // Se ultrapassar a direita da tela, move o card para a esquerda
    if (left + cardWidth > windowWidth) {
      left = windowWidth - cardWidth - 10; // 10px de margem direita
    }

    // Se for muito à esquerda, ajusta
    if (left < 10) {
      left = 10;
    }

    // Aplica a posição em relação à página (scroll incluso)
    card.style.position = "absolute";
    card.style.left = `${left}px`;
    card.style.top = `${btnRect.bottom + window.scrollY + 10}px`; // 10px abaixo do botão
  }
}
