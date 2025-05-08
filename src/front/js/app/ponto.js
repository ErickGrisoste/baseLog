const funcionarioId = localStorage.getItem("funcionarioId");
let statusFuncionario;
console.log("ID do funcionário:", funcionarioId);

// Buscar status do funcionário ao carregar a página
fetch("http://localhost:8080/funcionario/buscar/" + funcionarioId)
  .then(response => response.json())
  .then(data => {
    statusFuncionario = data.status;
    //document.getElementById("statusFuncionario").textContent = statusFuncionario;
  })
  .catch(error => {
    console.log("Erro ao buscar status do funcionário:", error);
  });

// Atualiza relógio em tempo real
function atualizarRelogio() {
  const agora = new Date();
  const horas = agora.getHours().toString().padStart(2, '0');
  const minutos = agora.getMinutes().toString().padStart(2, '0');
  const dia = agora.getDate().toString().padStart(2, '0');
  const mes = (agora.getMonth() + 1).toString().padStart(2, '0');
  const ano = agora.getFullYear();

  document.getElementById("hora").textContent = `${horas}:${minutos}`;
  document.getElementById("data").textContent = `${dia}/${mes}/${ano}`;
}

setInterval(atualizarRelogio, 1000);
atualizarRelogio();

// Evento de clique no botão de ponto
document.getElementById("botaoPonto").addEventListener("click", () => {
  const agora = new Date();
  const horas = agora.getHours().toString().padStart(2, '0');
  const minutos = agora.getMinutes().toString().padStart(2, '0');

  // Define entrada ou saída com base no status atual
  if (statusFuncionario === "OFF") {
    document.getElementById("registroEntrada").textContent = "Entrada: " + horas + ":" + minutos;
  } else if (statusFuncionario === "ON") {
    document.getElementById("registroSaida").textContent = "Saída: " + horas + ":" + minutos;
  }

  // Bate o ponto no backend
  fetch(`http://localhost:8080/funcionario/bater-ponto/${funcionarioId}`, {
    method: "PUT"
  })
    .then(response => response.text())
    .then(mensagem => {
      //document.getElementById("statusFuncionario").textContent = mensagem;

      // Atualiza o status local
      statusFuncionario = (statusFuncionario === "OFF") ? "ON" : "OFF";

      alert(mensagem);
    })
    .catch(err => {
      console.error("Erro ao bater ponto:", err);
    });
});
