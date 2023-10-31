let updateButtons = document.querySelectorAll(".btncal");

updateButtons.forEach(function (button) {
    button.addEventListener("click", function () {
        console.log("Clic en el botón de actualización");
    let modal = document.getElementById("myModal1");
    let form = modal.querySelector("form");

    // Obtener los valores ingresados por el usuario en la tarjeta
    let ClieId = button.getAttribute("data-clie-id");
    let ClieTipoDoc = button.parentElement.querySelector(".cardClieTipoDoc").textContent;
    let ClieNumDoc = button.parentElement.querySelector(".cardClieNumDoc").textContent;
    let ClieNombre = button.parentElement.querySelector(".cardClieNombre").textContent;
    let ClieApellido = button.parentElement.querySelector(".cardClieApellido").textContent;
    let ClieDireccion = button.parentElement.querySelector(".cardClieDireccion").textContent;
    let ClieEmail = button.parentElement.querySelector(".cardClieEmail").textContent;

    // Llenar los campos en la ventana modal con los valores obtenidos
    form.Clie_Id.value = ClieId;
    form.Clie_Tipo_Doc.value = ClieTipoDoc;
    form.Clie_Num_Doc.value = ClieNumDoc;
    form.Clie_Nombre.value = ClieNombre;
    form.Clie_Apellido.value = ClieApellido;
    form.Clie_Direccion.value = ClieDireccion;
    form.Clie_Email.value = ClieEmail;

    // Mostrar la ventana modal
    modal.style.display = "block";
  });
});

// Evento de cierre de la ventana modal
let modal = document.getElementById("myModal1");
let closeBtn = document.querySelector(".close1");

closeBtn.addEventListener("click", function () {
  modal.style.display = "none";
});

window.addEventListener("click", function (event) {
  if (event.target === modal) {
    modal.style.display = "none";
  }
});