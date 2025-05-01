const form = document.getElementById("loginForm");

    form.addEventListener("submit", function (e) {
      e.preventDefault();

      const formData = new FormData(form);
      const loginData = {
        email: formData.get("email"),
        senha: formData.get("senha")
      };

      fetch("http://localhost:8080/funcionario/login", {
        method: "POST",
        headers: {
          "Content-Type": "application/json"
        },
        body: JSON.stringify(loginData)
      })
      .then(response => {
        if (response.ok) {
          alert("Login realizado com sucesso!");
          window.location.href = "../html/index.html";
        } else {
          alert("Credenciais inválidas.");
        }
      })
      .catch(error => {
        console.error("Erro:", error);
        alert("Erro de conexão com a API.");
      });
    });