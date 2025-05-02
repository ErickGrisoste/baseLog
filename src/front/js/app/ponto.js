function atualizarRelogio() {
  const agora = new Date();
  const horas = agora.getHours().toString().padStart(2, '0');
  const minutos = agora.getMinutes().toString().padStart(2, '0');
  const dia = agora.getDate().toString().padStart(2, '0');
  const mes = (agora.getMonth() + 1).toString().padStart(2, '0');
  const ano = agora.getFullYear();

  document.getElementById("hora").textContent = `${horas}:${minutos}`
  document.getElementById("data").textContent = `${dia}/${mes}/${ano}`

}

setInterval(atualizarRelogio, 1000);
atualizarRelogio(); // chama a função imediatamente