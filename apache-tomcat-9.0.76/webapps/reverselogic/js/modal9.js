//? -------------------------|| Modal Actualizacion Metodo De Pago ||-------------------------
document.addEventListener("DOMContentLoaded", function() {
    let updateButtons = document.querySelectorAll(".btncal");

updateButtons.forEach(function(button) {
    button.addEventListener("click", function() {
        let modal = document.getElementById("myModal1");
        let form = modal.querySelector("form");

        // Obtener los valores ingresados por el usuario en la tarjeta
        let Metod_Id = button.getAttribute("data-metod-id");
        let Metod_Tipo = button.parentElement.querySelector(".cardMetod_Tipo").textContent;

        // Llenar los campos en la ventana modal con los valores obtenidos
        form.elements.Metod_Id.value = Metod_Id;
        form.elements.Metod_Tipo.value = Metod_Tipo;

        // Mostrar la ventana modal
        modal.style.display = "block";
    });
});

// Aquí, getUserById() es una función ficticia, debes implementarla para obtener los datos del usuario por su ID
function getMetodById(Metod_Id, callback) {
    // Aquí, realiza una solicitud AJAX al servidor o cualquier otra lógica para obtener los datos del usuario
    // Supongamos que userData es un objeto que contiene la información del usuario por su ID
    let MetodData = {
        Metod_Id: Metod_Id,
        Metod_Tipo: Metod_Tipo,
    };

    // Llamar al callback con los datos del usuario
    callback(MetodData);
}

// Evento de cierre de la ventana modal
let modal = document.getElementById("myModal1");
let closeBtn = document.querySelector(".close1");

closeBtn.addEventListener("click", function() {
    modal.style.display = "none";
});

window.addEventListener("click", function(event) {
    if (event.target === modal) {
        modal.style.display = "none";
    }
});
});