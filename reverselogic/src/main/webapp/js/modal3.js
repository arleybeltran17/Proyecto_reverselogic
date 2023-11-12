let updateButtons = document.querySelectorAll(".btncal");

updateButtons.forEach(function (button) {
    button.addEventListener("click", function () {
        console.log("Clic en el botón de actualización");
    let modal = document.getElementById("myModal1");
    let form = modal.querySelector("form");

    // Obtener los valores ingresados por el usuario en la tarjeta
    let DevoId = button.getAttribute("data-devo-id");
    let Devo_Cant_Preducto = button.parentElement.querySelector(".cardCantidadDevo").textContent;
    let DevoRazon = button.parentElement.querySelector(".cardRazonDevo").textContent;
    let DevoFecha = button.parentElement.querySelector(".cardDevoFecha").textContent;
    let EmpleId = button.parentElement.querySelector(".cardEmpleidDevo").textContent;


    // Llenar los campos en la ventana modal con los valores obtenidos
    form.Devo_Id.value = DevoId;
    form.Devo_Cant_Preducto.value = Devo_Cant_Preducto;
    form.Devo_Razon.value = DevoRazon;
    form.Devo_Fecha.value = DevoFecha;
    form.Emple_Id.value = EmpleId;

    // Mostrar la ventana modal 
    modal.style.display = "block";
  });
});

function getDevoById(DevoId, callback) {
    // Aquí, realiza una solicitud AJAX al servidor o cualquier otra lógica para obtener los datos del usuario
    // Supongamos que userData es un objeto que contiene la información del usuario por su ID
    let DevoData = {
        Devo_Id: DevoId,
        Devo_Cant_Preducto: EmpleTipoDoc,
        Devo_Razon: DevoRazon,
        Devo_Fecha: DevoFecha,
        Emple_Id: EmpleId

    };

    // Llamar al callback con los datos del usuario
    callback(DevoData);
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