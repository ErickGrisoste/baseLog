const form = document.getElementById("funcForm");

  form.addEventListener("submit", function (event) {
    event.preventDefault();

    const formData = new FormData(form);
    const funcionario = {
      nome: formData.get("nome"),
      email: formData.get("email"),
      senha: formData.get("senha"),
      cargo: formData.get("cargo"),
      base: {
        id: parseInt(formData.get("baseId"))
      }
    };

    fetch("http://localhost:8080/funcionario/cadastrar", {
      method: "POST",
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify(funcionario)
    })
    .then(response => {
      if (response.ok) {
        alert("Funcionário cadastrado com sucesso!");
        form.reset();
      } else {
        alert("Erro ao cadastrar funcionário.");
      }
    })
    .catch(error => {
      console.error("Erro:", error);
      alert("Erro de conexão com a API.");
    });
  });