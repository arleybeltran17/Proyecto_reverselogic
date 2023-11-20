//? -------------------------|| Modal Actualizacion Productos Color ||-------------------------
let updateButtons = document.querySelectorAll(".btncal");

updateButtons.forEach(function(button) {
    button.addEventListener("click", function() {
        let modal = document.getElementById("myModal1");
        let form = modal.querySelector("form");

        // Obtener los valores ingresados por el usuario en la tarjeta
        let Color_Id = button.getAttribute("data-color-id");
        let Color_Nombre = button.parentElement.querySelector(".cardColor_Nombre").textContent;
        
        // Llenar los campos en la ventana modal con los valores obtenidos
        form.Color_Id.value = Color_Id;
        form.Color_Nombre.value = Color_Nombre;

        // Mostrar la ventana modal
        modal.style.display = "block";
    });
});

// Aquí, getUserById() es una función ficticia, debes implementarla para obtener los datos del usuario por su ID
function getProdById(Color_Id, callback) {
    // Aquí, realiza una solicitud AJAX al servidor o cualquier otra lógica para obtener los datos del usuario
    // Supongamos que userData es un objeto que contiene la información del usuario por su ID
    let ColorData = {
        Color_Id: Color_Id,
        Color_Nombre: Color_Nombre
    };

    // Llamar al callback con los datos del usuario
    callback(ColorData);
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