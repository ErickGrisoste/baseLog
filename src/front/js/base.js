const form = document.getElementById("baseForm");

  form.addEventListener("submit", function (event) {
    event.preventDefault();

    const formData = new FormData(form);
    const base = {
      endereco: {
        cep: formData.get("cep"),
        logradouro: formData.get("logradouro"),
        numero: parseInt(formData.get("numero")),
        cidade: formData.get("cidade"),
        bairro: formData.get("bairro"),
        estado: formData.get("estado"),
        complemento: formData.get("complemento")
      },
      status: formData.get("status")
    };

    fetch("http://localhost:8080/base/cadastrar", {
      method: "POST",
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify(base)
    })
    .then(response => {
      if (response.ok) {
        alert("Base cadastrada com sucesso!");
        form.reset();
      } else {
        alert("Erro ao cadastrar base.");
      }
    })
    .catch(error => {
      console.error("Erro:", error);
      alert("Erro de conexão com a API.");
    });
  });