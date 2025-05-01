fetch("http://localhost:8080/base/listar")
  .then(response => response.json())
  .then(data => {
    const container = document.getElementById("base-list");

    data.forEach((base, index) => {
      const div = document.createElement("div");
      div.className = `base-card status-${base.status}`;

      const funcionariosId = `func-${index}`;

      div.innerHTML = `
        <div class="card-header">
          <h2>${base.endereco.cidade} - ${base.endereco.estado}</h2>
          <button class="toggle-button" onclick="toggleFuncionarios('${funcionariosId}', this)">+</button>
        </div>
        <p><strong>Status:</strong> ${base.status}</p>
        <div class="funcionarios" id="${funcionariosId}">
          <p><strong>Funcionários:</strong> ${base.funcionarios.map(f => f.nome).join(", ")}</p>
        </div>
      `;

      container.appendChild(div);
    });
  })
  .catch(error => {
    console.error("Erro ao carregar bases:", error);
  });

function toggleFuncionarios(id, btn) {
  const el = document.getElementById(id);
  const isVisible = el.style.display === "block";
  el.style.display = isVisible ? "none" : "block";
  btn.textContent = isVisible ? "+" : "-";
}
