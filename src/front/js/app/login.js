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
          if (!response.ok) throw new Error("Login inválido");
          return response.json();
        })
        .then(data => {
          localStorage.setItem("funcionarioId", data.id); // <-- salvando ID
          window.location.href = "../html/home.html"; // redireciona para tela de ponto
        })
        .catch(error => alert("Erro no login: " + error.message));
      });