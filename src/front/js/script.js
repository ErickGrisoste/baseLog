 fetch("http://localhost:8080/base/listar")
      .then(response => response.json())
      .then(data => {
        const container = document.getElementById("base-list");

        data.forEach(base => {
          const div = document.createElement("div");
          div.className = `base-card status-${base.status}`;

          div.innerHTML = `
            <h2>${base.endereco.cidade} - ${base.endereco.estado}</h2>
            <p><strong>Status:</strong> ${base.status}</p>
            <p><strong>Funcionários:</strong> ${base.funcionarios.map(f => f.nome).join(", ")}</p>
          `;

          container.appendChild(div);
        });
      })
      .catch(error => {
        console.error("Erro ao carregar bases:", error);
      });