//? -------------------------|| Modal Actualizacion Metodo De Pago ||-------------------------
document.addEventListener("DOMContentLoaded", function() {
    let updateButtons = document.querySelectorAll(".btncal");

updateButtons.forEach(function(button) {
    button.addEventListener("click", function() {
        let modal = document.getElementById("myModal1");
        let form = modal.querySelector("form");

        // Obtener los valores ingresados por el usuario en la tarjeta
        let Mate_Id = button.getAttribute("data-mate-id");
        let Mate_Nombre = button.parentElement.querySelector(".cardMateNombre").textContent;

        // Llenar los campos en la ventana modal con los valores obtenidos
        form.elements.Mate_Id.value = Mate_Id;
        form.elements.Mate_Nombre.value = Mate_Nombre;

        // Mostrar la ventana modal
        modal.style.display = "block";
    });
});

// Aquí, getUserById() es una función ficticia, debes implementarla para obtener los datos del usuario por su ID
function getMateById(Mate_Id, callback) {
    // Aquí, realiza una solicitud AJAX al servidor o cualquier otra lógica para obtener los datos del usuario
    // Supongamos que userData es un objeto que contiene la información del usuario por su ID
    let MateData = {
        Mate_Id: Mate_Id,
        Mate_Nombre: Mate_Nombre,
    };

    // Llamar al callback con los datos del usuario
    callback(MateData);
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