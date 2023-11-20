//? -------------------------|| Modal Actualizacion Usuarios ||-------------------------
let updateButtons = document.querySelectorAll(".btncal");

updateButtons.forEach(function (button) {
  button.addEventListener("click", function () {
      console.log("Clic en el botón de actualización");
      let modal = document.getElementById("myModal1");
      let form = modal.querySelector("form");

      // Obtener los valores ingresados por el usuario en la tarjeta
      let UsuId = button.getAttribute("data-usu-id");
      let UsuNombre = button.parentElement.querySelector(".cardUsuNombre").textContent;
      let UsuRol = button.parentElement.querySelector(".cardUsuRol").textContent;
      let UsuPassword = button.parentElement.querySelector(".cardUsuContraseña").textContent;
      let EmpleId = button.parentElement.querySelector(".cardEmpleId").textContent;

      // Llenar los campos en la ventana modal con los valores obtenidos
      form.Usu_Id.value = UsuId;
      form.Usu_Nombre.value = UsuNombre;
      form.Usu_Rol.value = UsuRol;
      form.Usu_Password.value = UsuPassword;
      form.Emple_Id.value = EmpleId;  // Corregido el nombre del campo

      // Mostrar la ventana modal 
      modal.style.display = "block";
  });
});

function getUsuById(UsuId, callback) {
    // Aquí, realiza una solicitud AJAX al servidor o cualquier otra lógica para obtener los datos del usuario
    // Supongamos que userData es un objeto que contiene la información del usuario por su ID
    let UsuData = {
        Usu_Id: UsuId,
        Usu_Nombre: UsuNombre,
        Usu_Rol: UsuRol,
        Usu_Password: UsuPassword,
        Emple_Id: EmpleId

    };

    // Llamar al callback con los datos del usuario
    callback(UsuData);
}

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